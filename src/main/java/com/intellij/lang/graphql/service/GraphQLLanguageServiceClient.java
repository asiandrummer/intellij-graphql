// Copyright 2004-present Facebook. All Rights Reserved.

package com.intellij.lang.graphql.service;

import com.google.common.collect.Maps;
import com.intellij.AppTopics;
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer;
import com.intellij.lang.graphql.GraphQLFileType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.vfs.*;
import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.*;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageServer;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.Map;


public class GraphQLLanguageServiceClient {
  private static Map<Project, GraphQLLanguageServiceServer> sLanguageServiceInstances = Maps.newConcurrentMap();
  private Project project;
  private static LanguageServer sLanguageServer;

  private Logger logger;

  private static Map<VirtualFile, Integer> fileVersions = Maps.newConcurrentMap();

  private Socket clientSocket;

  public GraphQLLanguageServiceClient(@NotNull Project project) {
    this.logger = Logger.getInstance(this.getClass());
    ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
      @Override
      public void run() {
        try {
          connectToGraphQLLanguageService(project);
        } catch (InterruptedException e) {
          logger.error("Socket connection retry is interrupted. " + e.getMessage());
        }
      }
    });
  }

  public void connectToGraphQLLanguageService(@NotNull Project project) throws InterruptedException {
    boolean isInstantiated = false;
    GraphQLLanguageServiceServer instance = getGraphQLLanguageServerInstance(project);
    try {
      isInstantiated = instance.createProcessHandler(project);
    } catch (IOException e) {
      this.logger.error("An exception is thrown during server instantiation: " + e.getMessage());
    }

    if (!isInstantiated) {
      return;
    }

    // Retry for 10 seconds with 500ms delay, and if the socket cannot connect then log error.
    int retryLimit = 0;
    while (retryLimit <= 20) {
      try {
        Socket client = new Socket();
        client.connect(new InetSocketAddress("localhost", instance.getPortNumber()));
        clientSocket = client;
        break;
      } catch (IOException e) {
        this.logger.info("An error is thrown during accept: " + e.getMessage() + " Retrying soon...");
        Thread.currentThread().sleep(500);
      }
      retryLimit++;
    }

    if (clientSocket == null) {
      this.logger.error("client could not accept the server socket.");
      return;
    }

    this.project = project;

    try {
      Launcher<LanguageServer> client = LSPLauncher.createClientLauncher(
        new GraphQLLanguageServiceClientInterface(),
        clientSocket.getInputStream(),
        clientSocket.getOutputStream()
      );

      client.startListening();

      InitializeParams params = new InitializeParams();
      params.setRootPath(project.getBasePath());
      this.sLanguageServer = client.getRemoteProxy();
      sLanguageServer.initialize(params);
    } catch (IOException e) {
      this.logger.error("An error is thrown: " + e.getMessage());
    }

    this.listenToFileEditorEvents();

    // File change events aren't fired until there has been significant changes, but
    // the server needs to cache the currently opened files in order to process features
    // such as completion.
    // Gather all opened files and send a `textDocument/didOpen` event for each GraphQL file.
    for (VirtualFile file : FileEditorManager.getInstance(project).getOpenFiles()) {
      sendDidOpenNotification(file);
    }
  }

  public void sendDidOpenNotification(VirtualFile file) {
    try {
      if (file.getFileType() instanceof GraphQLFileType) {
        String content = new String(file.contentsToByteArray());
        TextDocumentItem documentItem = new TextDocumentItem();
        documentItem.setUri(file.getUrl());
        documentItem.setText(content);
        int version = fileVersions.computeIfAbsent(file, f -> new Integer(0));
        documentItem.setVersion(version);
        System.out.println("file version: " + version);
        fileVersions.put(file, version + 1);
        sLanguageServer.getTextDocumentService().didOpen(new DidOpenTextDocumentParams(documentItem, content));
      }
    } catch (IOException e) {
      this.logger.error("An error is thrown within fileOpened: " + e.getMessage());
    }
  }

  public static void sendDidUpdateNotification(VirtualFile file, String updatedText) {
    if (file.getFileType() instanceof GraphQLFileType) {
      TextDocumentIdentifier identifier = new TextDocumentIdentifier(file.getUrl());
      List<TextDocumentContentChangeEvent> contentChangeEvents =
        new ArrayList<TextDocumentContentChangeEvent>();
        contentChangeEvents.add(
          new TextDocumentContentChangeEvent(
            null,
            0,
            updatedText
          )
        );

      int version = fileVersions.computeIfAbsent(file, f -> new Integer(0));
      sLanguageServer.getTextDocumentService().didChange(new DidChangeTextDocumentParams(
        new VersionedTextDocumentIdentifier(version),
        file. getUrl(),
        contentChangeEvents
      ));
      System.out.println("file version: " + version);
      fileVersions.put(file, version + 1);
    }
  }

  public static LanguageServer getCurrentLanguageServer() {
    return sLanguageServer;
  }

  public void clearDiagnosticsList(VirtualFile file) {
    if (file.getFileType() instanceof GraphQLFileType) {
      if (diagnosticList != null) {
        diagnosticList.clear();
      }
    }
  }

  public void listenToFileEditorEvents() {
    ProjectManager.getInstance().addProjectManagerListener(new ProjectManagerListener() {
      @Override
      public void projectOpened(Project project) {
        GraphQLLanguageServiceServer server = getLanguageServiceInstance(project);
        // If there is a currently running server, we can use that instead
        if (server != null) {
          Logger.getInstance(this.getClass()).info("There is a currently running server for this project!");
          return;
        }
        ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
          @Override
          public void run() {
            try {
              connectToGraphQLLanguageService(project);
            } catch (InterruptedException e) {
              logger.error("Socket connection retry is interrupted. " + e.getMessage());
            }
          }
        });
      }

      @Override
      public void projectClosed(Project project) {
        if (clientSocket == null) {
          return;
        }
        try {
          clientSocket.close();
          sLanguageServiceInstances.remove(project);
        } catch (IOException e) {
          Logger.getInstance(this.getClass()).info("Socket failed to close.\n" + e.getMessage());
        }
      }
    });

    this.project.getMessageBus()
      .connect()
      .subscribe(AppTopics.FILE_DOCUMENT_SYNC, new FileDocumentManagerAdapter() {
        @Override
        public void beforeDocumentSaving(@NotNull Document document) {
          super.beforeDocumentSaving(document);
          VirtualFile file = FileDocumentManager.getInstance().getFile(document);
          if (file.getFileType() instanceof GraphQLFileType) {
            GraphQLLanguageServiceClient.sendDidUpdateNotification(file, document.getText());
            clearDiagnosticsList(file);
            TextDocumentIdentifier identifier = new TextDocumentIdentifier(file.getUrl());
            sLanguageServer.getTextDocumentService().didSave(new DidSaveTextDocumentParams(identifier));
          }
        }
      });

    this.project.getMessageBus()
      .connect()
      .subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
        @Override
        public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
          super.fileOpened(source, file);
          sendDidOpenNotification(file);
        }

        @Override
        public void fileClosed(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
          super.fileClosed(source, file);
          if (file.getFileType() instanceof GraphQLFileType) {
            clearDiagnosticsList(file);
            TextDocumentIdentifier identifier = new TextDocumentIdentifier(file.getUrl());
            sLanguageServer.getTextDocumentService().didClose(new DidCloseTextDocumentParams(identifier));
          }
        }
      });
  }


  public static GraphQLLanguageServiceServer getLanguageServiceInstance(Project project) {
    return sLanguageServiceInstances.get(project);
  }

  public GraphQLLanguageServiceServer getGraphQLLanguageServerInstance(@NotNull Project project) {
    final GraphQLLanguageServiceServer instance = sLanguageServiceInstances.computeIfAbsent(
      project,
      GraphQLLanguageServiceServer::new
    );

    return instance;
  }

  private List<Diagnostic> diagnosticList;

  public List<Diagnostic> getDiagnosticList() {
    return diagnosticList;
  }

  public class GraphQLLanguageServiceClientInterface implements LanguageClient {

    @Override
    public void telemetryEvent(Object object) {
    }

    @Override
    public void publishDiagnostics(PublishDiagnosticsParams diagnostics) {
      diagnosticList = diagnostics.getDiagnostics();
      DaemonCodeAnalyzer.getInstance(project).restart();
    }

    @Override
    public void showMessage(MessageParams messageParams) {

    }

    @Override
    public CompletableFuture<Void> showMessageRequest(ShowMessageRequestParams requestParams) {
      return null;
    }

    @Override
    public void logMessage(MessageParams message) {

    }
  }
}

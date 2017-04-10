// Copyright 2004-present Facebook. All Rights Reserved.

package com.intellij.lang.graphql.ide;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.graphql.GraphQLLanguage;
import com.intellij.lang.graphql.psi.GraphQLElementTypes;
import com.intellij.lang.graphql.service.GraphQLLanguageServiceClient;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.services.LanguageServer;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class GraphQLCompletionContributor extends CompletionContributor {
  public GraphQLCompletionContributor() {
    extend(CompletionType.BASIC,
      PlatformPatterns.psiElement(GraphQLElementTypes.NAME).withLanguage(GraphQLLanguage.INSTANCE),
      new CompletionProvider<CompletionParameters>() {
        public void addCompletions(@NotNull CompletionParameters parameters,
                                   ProcessingContext context,
                                   @NotNull CompletionResultSet resultSet) {
          LanguageServer server = GraphQLLanguageServiceClient.getCurrentLanguageServer();
          if (server == null) {
            Logger.getInstance(this.getClass()).warn("Language server is not initialized yet");
            return;
          }
          LogicalPosition logicalPosition = parameters.getEditor().getCaretModel().getLogicalPosition();
          TextDocumentPositionParams params = new TextDocumentPositionParams(
            new TextDocumentIdentifier(parameters.getOriginalFile().getVirtualFile().getUrl()),
            null,
            new Position(logicalPosition.line, logicalPosition.column)
          );
          try {
            // CompletionContributor cannot function in an asynchronous manner - it will ignore any items
            // added from `CompletableFuture.thenAccept` instance.
            // To mock the asynchronous behavior, do a busy-wait loop and check if the currently running
            // completion process is canceled, and return empty with exception handling if it is.
            CompletableFuture<CompletionList> futureList = server
              .getTextDocumentService()
              .completion(params);
            while (!futureList.isDone()) {
              try {
                ProgressManager.checkCanceled();
              } catch (ProcessCanceledException e) {
                // This will throw CancellationException, which is dealt with below
                futureList.cancel(true);
                break;
              }
              Thread.sleep(50);
            }

            CompletionList list = futureList.get();

            for (CompletionItem item : list.getItems()) {
              resultSet.addElement(LookupElementBuilder.create(item.getLabel()));
            }
          } catch (InterruptedException e) {
            Logger.getInstance(this.getClass()).info(
              "InterruptedException was thrown during completion: " + e.getMessage()
            );
          } catch (ExecutionException e) {
            Logger.getInstance(this.getClass()).info(
              "ExecutionException was thrown during completion: " + e.getMessage()
            );
          } catch (CancellationException e) {
            Logger.getInstance(this.getClass()).info(
              "Completion request was cancelled: " + e.getMessage()
            );
          }
        }
      }
    );
  }
}

// Copyright 2004-present Facebook. All Rights Reserved.

package com.intellij.lang.graphql.service;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.ServerSocket;

public class GraphQLLanguageServiceServer {
  private OSProcessHandler processHandler;

  private Logger logger;
  private String basePath;
  private Project project;
  private int portNumber;
  private final static String GRAPHQL_LANGUAGE_SERVER_PLUGIN_ID = "com.intellij.lang.graphql";
  private final static String GRAPHQL_EXECUTABLE_LOCATION =
    "resources/node_modules/graphql-language-service/bin/graphql.js";

  private final int DYNAMICALLY_ALLOCATED_PORT = 0;

  public GraphQLLanguageServiceServer(@NotNull Project project) {
    this.logger = Logger.getInstance(this.getClass());
    this.project = project;
  }

  public boolean isDebugMode() {
    return java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("jdwp") > 0;
  }

  public boolean createProcessHandler(@NotNull Project project) throws IOException {
    try {
      File executable;
      if (isDebugMode()) {
        this.logger.info("DEBUG MODE");
        executable = new File(
          System.getProperty("LangServPath"),
          "bin/graphql.js"
        );
      } else {
        IdeaPluginDescriptor pluginDescriptor = PluginManager.getPlugin(
          PluginId.getId(GRAPHQL_LANGUAGE_SERVER_PLUGIN_ID)
        );
        executable = new File(
          pluginDescriptor.getPath(),
          GRAPHQL_EXECUTABLE_LOCATION
        );
      }

      if (!executable.exists()) {
        this.logger.error("GraphQL Language Service executable does not exist!\n" + GRAPHQL_EXECUTABLE_LOCATION);
        return false;
      }

      this.logger.info("GraphQL Language Service executable location: " + executable.getAbsolutePath());

      executable.setExecutable(true);

      GeneralCommandLine commandLine = new GeneralCommandLine(
        "./graphql.js"
      ).withWorkDirectory(
        executable.getParentFile().getAbsolutePath()
      );

      commandLine.addParameter("server");
      commandLine.addParameter("--configDir");
      commandLine.addParameter(project.getBasePath());

      ServerSocket socket = new ServerSocket(DYNAMICALLY_ALLOCATED_PORT);

      commandLine.addParameter("--port");
      commandLine.addParameter(Integer.toString(socket.getLocalPort()));

      this.portNumber = socket.getLocalPort();

      socket.close();

      processHandler = new OSProcessHandler(commandLine);
      processHandler.startNotify();
      return true;
    } catch (ExecutionException e) {
      this.logger.error("An error is thrown: " + e.getMessage());
    }
    return false;
  }

  public int getPortNumber() {
    return this.portNumber;
  }
}

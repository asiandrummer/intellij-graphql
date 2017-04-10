package com.intellij.lang.graphql.ide;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBusConnection;
import org.jetbrains.annotations.NotNull;

public class GraphQLProjectService implements Disposable, FileEditorManagerListener {
  private MessageBusConnection connection;
  public GraphQLProjectService(@NotNull Project project) {
    System.out.println("init ProjectService");
    connection = project.getMessageBus().connect(this);
    connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, this);
  }

  public static GraphQLProjectService getService(@NotNull Project project) {
    return ServiceManager.getService(project, GraphQLProjectService.class);
  }

  @Override
  public void dispose() {
//    connection.disconnect();
  }

  @Override
  public void fileOpened(@NotNull FileEditorManager fileEditorManager, @NotNull VirtualFile virtualFile) {

  }

  @Override
  public void fileClosed(@NotNull FileEditorManager fileEditorManager, @NotNull VirtualFile virtualFile) {

  }

  @Override
  public void selectionChanged(@NotNull FileEditorManagerEvent fileEditorManagerEvent) {

  }
}

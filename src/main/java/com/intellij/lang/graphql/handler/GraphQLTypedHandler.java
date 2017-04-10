// Copyright 2004-present Facebook. All Rights Reserved.

package com.intellij.lang.graphql.handler;

import com.intellij.lang.graphql.service.GraphQLLanguageServiceClient;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;


public class GraphQLTypedHandler implements TypedActionHandler {
  private TypedActionHandler originalHandler;
  public GraphQLTypedHandler(TypedActionHandler handler) {
    originalHandler = handler;
  }
  @Override
  public void execute(@NotNull Editor editor, char c, @NotNull DataContext dataContext) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        if (GraphQLLanguageServiceClient.getCurrentLanguageServer() == null) {
          originalHandler.execute(editor, c, dataContext);
          return;
        }

        GraphQLLanguageServiceClient.sendDidUpdateNotification(
          dataContext.getData(CommonDataKeys.VIRTUAL_FILE),
          getUpdatedText(editor, c)
        );
        originalHandler.execute(editor, c, dataContext);
      }
    };
    WriteCommandAction.runWriteCommandAction(editor.getProject(), runnable);
  }

  private String getUpdatedText(Editor editor, char c) {
    CaretModel caretModel = editor.getCaretModel();
    String newText = editor.getDocument().getText(new TextRange(0, caretModel.getOffset()));
    newText += c + editor.getDocument().getText(
      new TextRange(caretModel.getOffset(), editor.getDocument().getTextLength())
    );
    return newText;
  }
}

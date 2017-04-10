// Copyright 2004-present Facebook. All Rights Reserved.

package com.intellij.lang.graphql.action;

import com.intellij.lang.graphql.handler.GraphQLTypedHandler;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;

public class GraphQLEditorActions extends AnAction {
  static {
    final EditorActionManager actionManager = EditorActionManager.getInstance();
    final TypedAction typedAction = actionManager.getTypedAction();
    typedAction.setupHandler(new GraphQLTypedHandler(typedAction.getHandler()));
  }

  @Override
  public void actionPerformed(AnActionEvent anActionEvent) {

  }

  @Override
  public void update(AnActionEvent anActionEvent) {

  }
}

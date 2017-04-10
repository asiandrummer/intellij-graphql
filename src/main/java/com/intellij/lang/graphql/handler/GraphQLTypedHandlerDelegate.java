// Copyright 2004-present Facebook. All Rights Reserved.

package com.intellij.lang.graphql.handler;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;

public class GraphQLTypedHandlerDelegate extends TypedHandlerDelegate {
  @Override
  public Result charTyped(char c, Project project, Editor editor, PsiFile file) {
    return Result.CONTINUE;
  }
}

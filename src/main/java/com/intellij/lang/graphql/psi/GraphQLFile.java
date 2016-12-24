package com.intellij.lang.graphql.psi;

import com.intellij.lang.graphql.GraphQLFileType;
import com.intellij.lang.graphql.GraphQLLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class GraphQLFile extends PsiFileBase {
  public GraphQLFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, GraphQLLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return GraphQLFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "GraphQL File";
  }

  @Override
  public Icon getIcon(int flags) {
    return super.getIcon(flags);
  }
}

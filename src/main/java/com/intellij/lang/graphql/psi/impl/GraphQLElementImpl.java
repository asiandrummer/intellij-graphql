package com.intellij.lang.graphql.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.graphql.psi.GraphQLElement;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.NotNull;

public abstract class GraphQLElementImpl extends ASTWrapperPsiElement implements GraphQLElement {
  public GraphQLElementImpl(@NotNull ASTNode node) {
    super(node);
  }
}

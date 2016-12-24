package com.intellij.lang.graphql.psi.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.graphql.psi.GraphQLIdentifier;
import com.intellij.lang.graphql.psi.GraphQLNamedElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.NotNull;

public abstract class GraphQLNamedElementImpl extends GraphQLElementImpl implements GraphQLNamedElement {
  public GraphQLNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }
}

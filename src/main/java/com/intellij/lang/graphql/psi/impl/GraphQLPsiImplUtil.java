package com.intellij.lang.graphql.psi.impl;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.graphql.psi.GraphQLIdentifier;
import com.intellij.lang.graphql.psi.GraphQLNamedElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.graphql.psi.GraphQLVariable;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class GraphQLPsiImplUtil {
  public static String getName(GraphQLNamedElement element) {
    PsiElement identifier = element.getNameIdentifier();
    if (identifier == null) return null;

    ASTNode identifierNode = identifier.getNode();
    if (identifierNode == null) return null;

    return identifierNode.getText();
  }

  public static PsiElement setName(GraphQLNamedElement element, String newName) throws IncorrectOperationException {
    throw new IncorrectOperationException("GraphQLNamedElement does not support setName");
  }
}

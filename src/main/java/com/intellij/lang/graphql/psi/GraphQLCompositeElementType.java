package com.intellij.lang.graphql.psi;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.graphql.GraphQLLanguage;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

public class GraphQLCompositeElementType extends IElementType {
  public GraphQLCompositeElementType(@NotNull @NonNls String debugName) {
    super(debugName, GraphQLLanguage.INSTANCE);
  }
}

package com.intellij.lang.graphql.psi;

import com.intellij.lang.graphql.GraphQLLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

public class GraphQLTokenType extends IElementType {
  public GraphQLTokenType(@NotNull @NonNls String debugName) {
    super(debugName, GraphQLLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "GraphQLTokenType." + super.toString();
  }
}

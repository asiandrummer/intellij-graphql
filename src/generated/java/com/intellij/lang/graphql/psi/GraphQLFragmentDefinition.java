// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraphQLFragmentDefinition extends GraphQLNamedElement {

  @Nullable
  GraphQLSelectionSet getSelectionSet();

  @Nullable
  GraphQLIdentifier getNameIdentifier();

  String getName();

  PsiElement setName(String newName);

  @Nullable
  GraphQLNamedType getTypeCondition();

  @NotNull
  List<GraphQLDirective> getDirectives();

}

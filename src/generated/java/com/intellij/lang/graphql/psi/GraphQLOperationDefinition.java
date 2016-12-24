// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraphQLOperationDefinition extends GraphQLNamedElement {

  @NotNull
  GraphQLOperationType getOperationType();

  @Nullable
  GraphQLSelectionSet getSelectionSet();

  @Nullable
  GraphQLIdentifier getNameIdentifier();

  String getName();

  PsiElement setName(String newName);

  @NotNull
  List<GraphQLVariableDefinition> getVariableDefinitions();

  @NotNull
  List<GraphQLDirective> getDirectives();

}

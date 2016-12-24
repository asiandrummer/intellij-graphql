// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraphQLVariableDefinition extends GraphQLElement {

  @NotNull
  GraphQLType getType();

  @NotNull
  GraphQLVariable getVariable();

  @Nullable
  GraphQLValue getDefaultValue();

}

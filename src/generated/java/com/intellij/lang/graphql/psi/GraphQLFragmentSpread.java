// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraphQLFragmentSpread extends GraphQLSelection, GraphQLNamedElement {

  @NotNull
  GraphQLIdentifier getNameIdentifier();

  String getName();

  PsiElement setName(String newName);

  @NotNull
  List<GraphQLDirective> getDirectives();

}

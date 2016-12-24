// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;

public class GraphQLVisitor extends PsiElementVisitor {

  public void visitAliasedField(@NotNull GraphQLAliasedField o) {
    visitField(o);
  }

  public void visitArgument(@NotNull GraphQLArgument o) {
    visitNamedElement(o);
  }

  public void visitBooleanValue(@NotNull GraphQLBooleanValue o) {
    visitValue(o);
  }

  public void visitDirective(@NotNull GraphQLDirective o) {
    visitNamedElement(o);
  }

  public void visitEnumValue(@NotNull GraphQLEnumValue o) {
    visitValue(o);
  }

  public void visitField(@NotNull GraphQLField o) {
    visitSelection(o);
    // visitNamedElement(o);
  }

  public void visitFragmentDefinition(@NotNull GraphQLFragmentDefinition o) {
    visitNamedElement(o);
  }

  public void visitFragmentSpread(@NotNull GraphQLFragmentSpread o) {
    visitSelection(o);
    // visitNamedElement(o);
  }

  public void visitIdentifier(@NotNull GraphQLIdentifier o) {
    visitElement(o);
  }

  public void visitInlineFragment(@NotNull GraphQLInlineFragment o) {
    visitSelection(o);
  }

  public void visitListType(@NotNull GraphQLListType o) {
    visitType(o);
  }

  public void visitListValue(@NotNull GraphQLListValue o) {
    visitValue(o);
  }

  public void visitNamedType(@NotNull GraphQLNamedType o) {
    visitType(o);
  }

  public void visitNonNullType(@NotNull GraphQLNonNullType o) {
    visitType(o);
  }

  public void visitNullValue(@NotNull GraphQLNullValue o) {
    visitValue(o);
  }

  public void visitNumberValue(@NotNull GraphQLNumberValue o) {
    visitValue(o);
  }

  public void visitObjectField(@NotNull GraphQLObjectField o) {
    visitElement(o);
  }

  public void visitObjectValue(@NotNull GraphQLObjectValue o) {
    visitValue(o);
  }

  public void visitOperationDefinition(@NotNull GraphQLOperationDefinition o) {
    visitNamedElement(o);
  }

  public void visitOperationType(@NotNull GraphQLOperationType o) {
    visitElement(o);
  }

  public void visitSelection(@NotNull GraphQLSelection o) {
    visitElement(o);
  }

  public void visitSelectionSet(@NotNull GraphQLSelectionSet o) {
    visitElement(o);
  }

  public void visitShorthandQueryDefinition(@NotNull GraphQLShorthandQueryDefinition o) {
    visitOperationDefinition(o);
  }

  public void visitStringValue(@NotNull GraphQLStringValue o) {
    visitValue(o);
  }

  public void visitType(@NotNull GraphQLType o) {
    visitElement(o);
  }

  public void visitValue(@NotNull GraphQLValue o) {
    visitElement(o);
  }

  public void visitVariable(@NotNull GraphQLVariable o) {
    visitNamedElement(o);
  }

  public void visitVariableDefinition(@NotNull GraphQLVariableDefinition o) {
    visitElement(o);
  }

  public void visitVariableReference(@NotNull GraphQLVariableReference o) {
    visitValue(o);
  }

  public void visitNamedElement(@NotNull GraphQLNamedElement o) {
    visitElement(o);
  }

  public void visitElement(@NotNull GraphQLElement o) {
    super.visitElement(o);
  }

}

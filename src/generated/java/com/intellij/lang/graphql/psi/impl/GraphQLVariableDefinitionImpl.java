// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.lang.graphql.psi.GraphQLElementTypes.*;
import com.intellij.lang.graphql.psi.*;

public class GraphQLVariableDefinitionImpl extends GraphQLElementImpl implements GraphQLVariableDefinition {

  public GraphQLVariableDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraphQLVisitor visitor) {
    visitor.visitVariableDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraphQLVisitor) accept((GraphQLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GraphQLType getType() {
    return findNotNullChildByClass(GraphQLType.class);
  }

  @Override
  @NotNull
  public GraphQLVariable getVariable() {
    return findNotNullChildByClass(GraphQLVariable.class);
  }

  @Override
  @Nullable
  public GraphQLValue getDefaultValue() {
    return findChildByClass(GraphQLValue.class);
  }

}

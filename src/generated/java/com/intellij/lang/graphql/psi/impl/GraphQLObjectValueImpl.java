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

public class GraphQLObjectValueImpl extends GraphQLValueImpl implements GraphQLObjectValue {

  public GraphQLObjectValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraphQLVisitor visitor) {
    visitor.visitObjectValue(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraphQLVisitor) accept((GraphQLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GraphQLObjectField> getFields() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraphQLObjectField.class);
  }

}

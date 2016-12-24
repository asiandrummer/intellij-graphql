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

public class GraphQLAliasedFieldImpl extends GraphQLFieldImpl implements GraphQLAliasedField {

  public GraphQLAliasedFieldImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraphQLVisitor visitor) {
    visitor.visitAliasedField(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraphQLVisitor) accept((GraphQLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GraphQLIdentifier getAliasIdentifier() {
    List<GraphQLIdentifier> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, GraphQLIdentifier.class);
    return p1.get(0);
  }

  @Override
  @Nullable
  public GraphQLIdentifier getNameIdentifier() {
    List<GraphQLIdentifier> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, GraphQLIdentifier.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

}

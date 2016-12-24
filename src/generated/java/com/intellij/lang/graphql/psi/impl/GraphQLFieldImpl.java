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

public class GraphQLFieldImpl extends GraphQLNamedElementImpl implements GraphQLField {

  public GraphQLFieldImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraphQLVisitor visitor) {
    visitor.visitField(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraphQLVisitor) accept((GraphQLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GraphQLSelectionSet getSelectionSet() {
    return findChildByClass(GraphQLSelectionSet.class);
  }

  @Override
  @NotNull
  public GraphQLIdentifier getNameIdentifier() {
    return findNotNullChildByClass(GraphQLIdentifier.class);
  }

  public String getName() {
    return GraphQLPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return GraphQLPsiImplUtil.setName(this, newName);
  }

  @Override
  @NotNull
  public List<GraphQLArgument> getArguments() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraphQLArgument.class);
  }

  @Override
  @NotNull
  public List<GraphQLDirective> getDirectives() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraphQLDirective.class);
  }

}

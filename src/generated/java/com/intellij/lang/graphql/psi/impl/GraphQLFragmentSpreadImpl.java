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

public class GraphQLFragmentSpreadImpl extends GraphQLNamedElementImpl implements GraphQLFragmentSpread {

  public GraphQLFragmentSpreadImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GraphQLVisitor visitor) {
    visitor.visitFragmentSpread(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GraphQLVisitor) accept((GraphQLVisitor)visitor);
    else super.accept(visitor);
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
  public List<GraphQLDirective> getDirectives() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GraphQLDirective.class);
  }

}

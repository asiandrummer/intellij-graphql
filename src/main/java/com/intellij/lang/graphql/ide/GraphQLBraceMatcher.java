package com.intellij.lang.graphql.ide;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.lang.graphql.psi.GraphQLElementTypes;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GraphQLBraceMatcher implements PairedBraceMatcher {
  @Override
  public BracePair[] getPairs() {
    return new BracePair[]{
        new BracePair(GraphQLElementTypes.PAREN_L, GraphQLElementTypes.PAREN_R, true),
        new BracePair(GraphQLElementTypes.BRACKET_L, GraphQLElementTypes.BRACKET_R, true),
        new BracePair(GraphQLElementTypes.BRACE_L, GraphQLElementTypes.BRACE_R, true)
    };
  }

  @Override
  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
    return true;
  }

  @Override
  public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
    return openingBraceOffset;
  }
}

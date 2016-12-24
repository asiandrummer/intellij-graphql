package com.intellij.lang.graphql.ide;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.graphql.psi.GraphQLElementTypes;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GraphQLBlock extends AbstractBlock {
  public GraphQLBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment) {
    super(node, wrap, alignment);
  }

  @Override
  protected List<Block> buildChildren() {
    List<Block> blocks = new ArrayList<Block>();
    ASTNode child = myNode.getFirstChildNode();
    while (child != null) {
      if (child.getElementType() != TokenType.WHITE_SPACE) {
        Block block = new GraphQLBlock(child, Wrap.createWrap(WrapType.NONE, false), null);
        blocks.add(block);
      }
      child = child.getTreeNext();
    }
    return blocks;
  }

  @Override
  public Indent getIndent() {
    if (getNode().getTreeParent().getElementType() == GraphQLElementTypes.SELECTION_SET &&
        getNode().getElementType() != GraphQLElementTypes.BRACE_R) {
      return Indent.getNormalIndent();
    } else {
      return Indent.getNoneIndent();
    }
  }

  @Nullable
  @Override
  protected Indent getChildIndent() {
    if (getNode().getElementType() == GraphQLElementTypes.SELECTION_SET) {
      return Indent.getNormalIndent();
    } else {
      return Indent.getNoneIndent();
    }
  }

  @Nullable
  @Override
  public Spacing getSpacing (@Nullable Block child1, @NotNull Block child2){
    return null;
  }

  @Override
  public boolean isLeaf() {
    return myNode.getFirstChildNode() == null;
  }
}

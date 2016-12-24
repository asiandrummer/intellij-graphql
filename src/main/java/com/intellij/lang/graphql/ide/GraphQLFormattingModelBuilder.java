package com.intellij.lang.graphql.ide;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GraphQLFormattingModelBuilder implements FormattingModelBuilder {
  @NotNull
  @Override
  public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
    // TODO: Use code style settings
    settings.getIndentOptions().INDENT_SIZE = 2;

    return FormattingModelProvider.createFormattingModelForPsiFile(
        element.getContainingFile(),
        new GraphQLBlock(element.getNode(), Wrap.createWrap(WrapType.NONE, false), null),
        settings);
  }

  @Nullable
  @Override
  public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
    return null;
  }
}

package com.intellij.lang.graphql;

import com.intellij.lang.*;
import com.intellij.lang.graphql.psi.GraphQLElementTypes;
import com.intellij.lang.graphql.psi.GraphQLFile;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.jetbrains.annotations.NotNull;

public class GraphQLParserDefinition implements ParserDefinition {
  public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
  public static final TokenSet COMMENTS = TokenSet.create(GraphQLElementTypes.COMMENT);

  public static final IFileElementType FILE =
      new IFileElementType(Language.<GraphQLLanguage>findInstance(GraphQLLanguage.class));

  public GraphQLParserDefinition() {
    super();
  }

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new GraphQLLexerAdapter();
  }

  @NotNull
  public TokenSet getWhitespaceTokens() {
    return WHITE_SPACES;
  }

  @NotNull
  public TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @NotNull
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  public PsiParser createParser(final Project project) {
    return new GraphQLParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  public PsiFile createFile(FileViewProvider viewProvider) {
    return new GraphQLFile(viewProvider);
  }

  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }

  @NotNull
  public PsiElement createElement(ASTNode node) {
    return GraphQLElementTypes.Factory.createElement(node);
  }
}

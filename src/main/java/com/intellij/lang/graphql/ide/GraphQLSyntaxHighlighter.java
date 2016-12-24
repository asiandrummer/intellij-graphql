package com.intellij.lang.graphql.ide;

import com.intellij.lang.graphql.GraphQLLexerAdapter;
import com.intellij.lang.graphql.psi.GraphQLElementTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GraphQLSyntaxHighlighter extends SyntaxHighlighterBase {
  public static final TextAttributesKey IDENTIFIER =
      createTextAttributesKey("GRAPHQL_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
  public static final TextAttributesKey KEYWORD =
      createTextAttributesKey("GRAPHQL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey NUMBER =
      createTextAttributesKey("GRAPHQL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
  public static final TextAttributesKey STRING =
      createTextAttributesKey("GRAPHQL_STRING", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey COMMENT =
      createTextAttributesKey("GRAPHQL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey BRACES =
      createTextAttributesKey("GRAPHQL_BRACES", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey PARENTHESES =
      createTextAttributesKey("GRAPHQL_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
  public static final TextAttributesKey BRACKETS =
      createTextAttributesKey("GRAPHQL_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
  public static final TextAttributesKey SPREAD =
      createTextAttributesKey("GRAPHQL_SPREAD", DefaultLanguageHighlighterColors.DOT);
  public static final TextAttributesKey BAD_CHARACTER =
      createTextAttributesKey("GRAPHQL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

  private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
  private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
  private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
  private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
  private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[]{BRACES};
  private static final TextAttributesKey[] PARENTHESES_KEYS = new TextAttributesKey[]{PARENTHESES};
  private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[]{BRACKETS};
  private static final TextAttributesKey[] SPREAD_KEYS = new TextAttributesKey[]{SPREAD};
  private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new GraphQLLexerAdapter();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(GraphQLElementTypes.NAME)) {
      return IDENTIFIER_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.KEYWORD)) {
      return KEYWORD_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.NUMBER)) {
      return NUMBER_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.STRING)) {
      return STRING_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.COMMENT)) {
      return COMMENT_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.BRACE_L) || tokenType.equals(GraphQLElementTypes.BRACE_R)) {
      return BRACES_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.PAREN_L) || tokenType.equals(GraphQLElementTypes.PAREN_R)) {
      return PARENTHESES_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.BRACKET_L) || tokenType.equals(GraphQLElementTypes.BRACKET_R)) {
      return BRACKETS_KEYS;
    } else if (tokenType.equals(GraphQLElementTypes.SPREAD)) {
      return SPREAD_KEYS;
    } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHARACTER_KEYS;
    } else {
      return EMPTY_KEYS;
    }
  }
}

package com.intellij.lang.graphql;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.lang.graphql.psi.GraphQLElementTypes.*;

%%

%{
  public GraphQLLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class GraphQLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

SourceCharacter = [\u0009\u000A\u000D\u0020-\uFFFF]
UnicodeBOM = \uFEFF
WhiteSpace = \u0009|\u0020
LineTerminator = \u000A | (\u000D \u000A?)
Comment = "#" [\u0009\u0020-\uFFFF]*
Name = [_A-Za-z][_0-9A-Za-z]*
Number = -?([0-9]+|[0-9]*\.[0-9]+([eE][-+]?[0-9]+)?)
String = \"([^\"\\\u000A\u000D]|(\\(u[0-9a-fA-F]{4}|[\"\\/bfnrt])))*\"?

%%
<YYINITIAL> {
  // Ignored tokens
  {UnicodeBOM}       { return WHITE_SPACE; }
  {WhiteSpace}       { return WHITE_SPACE; }
  {LineTerminator}   { return WHITE_SPACE; }
  {Comment}          { return COMMENT; }
  ","                { return WHITE_SPACE; }

  // Punctuators
  "!"                { return BANG; }
  "$"                { return DOLLAR; }
  "("                { return PAREN_L; }
  ")"                { return PAREN_R; }
  "..."              { return SPREAD; }
  ":"                { return COLON; }
  "="                { return EQUALS; }
  "@"                { return AT; }
  "["                { return BRACKET_L; }
  "]"                { return BRACKET_R; }
  "{"                { return BRACE_L; }
  "|"                { return PIPE; }
  "}"                { return BRACE_R; }

  "query" |
  "mutation" |
  "subscription" |
  "fragment" |
  "on"               { return KEYWORD; }

  {Name}             { return NAME; }
  {Number}           { return NUMBER; }
  {String}           { return STRING; }
}

[^] { return BAD_CHARACTER; }

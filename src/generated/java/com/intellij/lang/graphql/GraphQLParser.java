// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.intellij.lang.graphql.psi.GraphQLElementTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GraphQLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType type, PsiBuilder builder) {
    parseLight(type, builder);
    return builder.getTreeBuilt();
  }

  public void parseLight(IElementType type, PsiBuilder builder) {
    boolean result;
    builder = adapt_builder_(type, builder, this, EXTENDS_SETS_);
    Marker marker = enter_section_(builder, 0, _COLLAPSE_, null);
    if (type == ALIASED_FIELD) {
      result = aliasedField(builder, 0);
    }
    else if (type == ARGUMENT) {
      result = argument(builder, 0);
    }
    else if (type == BOOLEAN_VALUE) {
      result = booleanValue(builder, 0);
    }
    else if (type == DIRECTIVE) {
      result = directive(builder, 0);
    }
    else if (type == ENUM_VALUE) {
      result = enumValue(builder, 0);
    }
    else if (type == FIELD) {
      result = field(builder, 0);
    }
    else if (type == FRAGMENT_DEFINITION) {
      result = fragmentDefinition(builder, 0);
    }
    else if (type == FRAGMENT_SPREAD) {
      result = fragmentSpread(builder, 0);
    }
    else if (type == IDENTIFIER) {
      result = identifier(builder, 0);
    }
    else if (type == INLINE_FRAGMENT) {
      result = inlineFragment(builder, 0);
    }
    else if (type == LIST_TYPE) {
      result = listType(builder, 0);
    }
    else if (type == LIST_VALUE) {
      result = listValue(builder, 0);
    }
    else if (type == NAMED_TYPE) {
      result = namedType(builder, 0);
    }
    else if (type == NON_NULL_TYPE) {
      result = nonNullType(builder, 0);
    }
    else if (type == NULL_VALUE) {
      result = nullValue(builder, 0);
    }
    else if (type == NUMBER_VALUE) {
      result = numberValue(builder, 0);
    }
    else if (type == OBJECT_FIELD) {
      result = objectField(builder, 0);
    }
    else if (type == OBJECT_VALUE) {
      result = objectValue(builder, 0);
    }
    else if (type == OPERATION_DEFINITION) {
      result = operationDefinition(builder, 0);
    }
    else if (type == OPERATION_TYPE) {
      result = operationType(builder, 0);
    }
    else if (type == SELECTION) {
      result = selection(builder, 0);
    }
    else if (type == SELECTION_SET) {
      result = selectionSet(builder, 0);
    }
    else if (type == SHORTHAND_QUERY_DEFINITION) {
      result = shorthandQueryDefinition(builder, 0);
    }
    else if (type == STRING_VALUE) {
      result = stringValue(builder, 0);
    }
    else if (type == TYPE) {
      result = type(builder, 0);
    }
    else if (type == VALUE) {
      result = value(builder, 0);
    }
    else if (type == VARIABLE) {
      result = variable(builder, 0);
    }
    else if (type == VARIABLE_DEFINITION) {
      result = variableDefinition(builder, 0);
    }
    else if (type == VARIABLE_REFERENCE) {
      result = variableReference(builder, 0);
    }
    else {
      result = parse_root_(type, builder, 0);
    }
    exit_section_(builder, 0, marker, type, result, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType type, PsiBuilder builder, int level) {
    return queryDocument(builder, level + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(OPERATION_DEFINITION, SHORTHAND_QUERY_DEFINITION),
    create_token_set_(LIST_TYPE, NAMED_TYPE, NON_NULL_TYPE, TYPE),
    create_token_set_(ALIASED_FIELD, FIELD, FRAGMENT_SPREAD, INLINE_FRAGMENT,
      SELECTION),
    create_token_set_(BOOLEAN_VALUE, ENUM_VALUE, LIST_VALUE, NULL_VALUE,
      NUMBER_VALUE, OBJECT_VALUE, STRING_VALUE, VALUE,
      VARIABLE_REFERENCE),
  };

  /* ********************************************************** */
  // identifier ':' identifier arguments? directives? selectionSet?
  public static boolean aliasedField(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "aliasedField")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = identifier(builder, level + 1);
    result = result && consumeToken(builder, COLON);
    result = result && identifier(builder, level + 1);
    result = result && aliasedField_3(builder, level + 1);
    result = result && aliasedField_4(builder, level + 1);
    result = result && aliasedField_5(builder, level + 1);
    exit_section_(builder, marker, ALIASED_FIELD, result);
    return result;
  }

  // arguments?
  private static boolean aliasedField_3(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "aliasedField_3")) return false;
    arguments(builder, level + 1);
    return true;
  }

  // directives?
  private static boolean aliasedField_4(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "aliasedField_4")) return false;
    directives(builder, level + 1);
    return true;
  }

  // selectionSet?
  private static boolean aliasedField_5(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "aliasedField_5")) return false;
    selectionSet(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier ':' value
  public static boolean argument(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "argument")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = identifier(builder, level + 1);
    result = result && consumeToken(builder, COLON);
    result = result && value(builder, level + 1);
    exit_section_(builder, marker, ARGUMENT, result);
    return result;
  }

  /* ********************************************************** */
  // '(' argument+ ')'
  static boolean arguments(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "arguments")) return false;
    if (!nextTokenIs(builder, PAREN_L)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_);
    result = consumeToken(builder, PAREN_L);
    pinned = result; // pin = 1
    result = result && report_error_(builder, arguments_1(builder, level + 1));
    result = pinned && consumeToken(builder, PAREN_R) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // argument+
  private static boolean arguments_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "arguments_1")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = argument(builder, level + 1);
    int pos = current_position_(builder);
    while (result) {
      if (!argument(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "arguments_1", pos)) break;
      pos = current_position_(builder);
    }
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean booleanValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "booleanValue")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NONE_, BOOLEAN_VALUE, "<boolean value>");
    result = consumeToken(builder, "true");
    if (!result) result = consumeToken(builder, "false");
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // '=' value
  static boolean defaultValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "defaultValue")) return false;
    if (!nextTokenIs(builder, EQUALS)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, EQUALS);
    result = result && value(builder, level + 1);
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // shorthandQueryDefinition | operationDefinition | fragmentDefinition
  static boolean definition(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "definition")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NONE_);
    result = shorthandQueryDefinition(builder, level + 1);
    if (!result) result = operationDefinition(builder, level + 1);
    if (!result) result = fragmentDefinition(builder, level + 1);
    exit_section_(builder, level, marker, result, false, definitionRecover_parser_);
    return result;
  }

  /* ********************************************************** */
  // !(operationType | 'fragment')
  static boolean definitionRecover(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "definitionRecover")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NOT_);
    result = !definitionRecover_0(builder, level + 1);
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  // operationType | 'fragment'
  private static boolean definitionRecover_0(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "definitionRecover_0")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = operationType(builder, level + 1);
    if (!result) result = consumeToken(builder, "fragment");
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // '@' identifier arguments?
  public static boolean directive(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "directive")) return false;
    if (!nextTokenIs(builder, AT)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, AT);
    result = result && identifier(builder, level + 1);
    result = result && directive_2(builder, level + 1);
    exit_section_(builder, marker, DIRECTIVE, result);
    return result;
  }

  // arguments?
  private static boolean directive_2(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "directive_2")) return false;
    arguments(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // directive*
  static boolean directives(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "directives")) return false;
    int pos = current_position_(builder);
    while (true) {
      if (!directive(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "directives", pos)) break;
      pos = current_position_(builder);
    }
    return true;
  }

  /* ********************************************************** */
  // !('true' | 'false' | 'null') identifier
  public static boolean enumValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "enumValue")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = enumValue_0(builder, level + 1);
    result = result && identifier(builder, level + 1);
    exit_section_(builder, marker, ENUM_VALUE, result);
    return result;
  }

  // !('true' | 'false' | 'null')
  private static boolean enumValue_0(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "enumValue_0")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NOT_);
    result = !enumValue_0_0(builder, level + 1);
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  // 'true' | 'false' | 'null'
  private static boolean enumValue_0_0(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "enumValue_0_0")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, "true");
    if (!result) result = consumeToken(builder, "false");
    if (!result) result = consumeToken(builder, "null");
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // identifier arguments? directives? selectionSet?
  public static boolean field(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "field")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = identifier(builder, level + 1);
    result = result && field_1(builder, level + 1);
    result = result && field_2(builder, level + 1);
    result = result && field_3(builder, level + 1);
    exit_section_(builder, marker, FIELD, result);
    return result;
  }

  // arguments?
  private static boolean field_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "field_1")) return false;
    arguments(builder, level + 1);
    return true;
  }

  // directives?
  private static boolean field_2(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "field_2")) return false;
    directives(builder, level + 1);
    return true;
  }

  // selectionSet?
  private static boolean field_3(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "field_3")) return false;
    selectionSet(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // 'fragment' fragmentName typeCondition directives? selectionSet
  public static boolean fragmentDefinition(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "fragmentDefinition")) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, FRAGMENT_DEFINITION, "<fragment definition>");
    result = consumeToken(builder, "fragment");
    pinned = result; // pin = 1
    result = result && report_error_(builder, fragmentName(builder, level + 1));
    result = pinned && report_error_(builder, typeCondition(builder, level + 1)) && result;
    result = pinned && report_error_(builder, fragmentDefinition_3(builder, level + 1)) && result;
    result = pinned && selectionSet(builder, level + 1) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // directives?
  private static boolean fragmentDefinition_3(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "fragmentDefinition_3")) return false;
    directives(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // !'on' identifier
  static boolean fragmentName(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "fragmentName")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = fragmentName_0(builder, level + 1);
    result = result && identifier(builder, level + 1);
    exit_section_(builder, marker, null, result);
    return result;
  }

  // !'on'
  private static boolean fragmentName_0(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "fragmentName_0")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NOT_);
    result = !consumeToken(builder, "on");
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // '...' fragmentName directives?
  public static boolean fragmentSpread(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "fragmentSpread")) return false;
    if (!nextTokenIs(builder, SPREAD)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, SPREAD);
    result = result && fragmentName(builder, level + 1);
    result = result && fragmentSpread_2(builder, level + 1);
    exit_section_(builder, marker, FRAGMENT_SPREAD, result);
    return result;
  }

  // directives?
  private static boolean fragmentSpread_2(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "fragmentSpread_2")) return false;
    directives(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // NAME
  public static boolean identifier(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "identifier")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, NAME);
    exit_section_(builder, marker, IDENTIFIER, result);
    return result;
  }

  /* ********************************************************** */
  // '...' typeCondition? directives? selectionSet
  public static boolean inlineFragment(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "inlineFragment")) return false;
    if (!nextTokenIs(builder, SPREAD)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, SPREAD);
    result = result && inlineFragment_1(builder, level + 1);
    result = result && inlineFragment_2(builder, level + 1);
    result = result && selectionSet(builder, level + 1);
    exit_section_(builder, marker, INLINE_FRAGMENT, result);
    return result;
  }

  // typeCondition?
  private static boolean inlineFragment_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "inlineFragment_1")) return false;
    typeCondition(builder, level + 1);
    return true;
  }

  // directives?
  private static boolean inlineFragment_2(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "inlineFragment_2")) return false;
    directives(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' type ']'
  public static boolean listType(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "listType")) return false;
    if (!nextTokenIs(builder, BRACKET_L)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, LIST_TYPE, null);
    result = consumeToken(builder, BRACKET_L);
    pinned = result; // pin = 1
    result = result && report_error_(builder, type(builder, level + 1));
    result = pinned && consumeToken(builder, BRACKET_R) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  /* ********************************************************** */
  // '[' value+ ']'
  public static boolean listValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "listValue")) return false;
    if (!nextTokenIs(builder, BRACKET_L)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, LIST_VALUE, null);
    result = consumeToken(builder, BRACKET_L);
    pinned = result; // pin = 1
    result = result && report_error_(builder, listValue_1(builder, level + 1));
    result = pinned && consumeToken(builder, BRACKET_R) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // value+
  private static boolean listValue_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "listValue_1")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = value(builder, level + 1);
    int pos = current_position_(builder);
    while (result) {
      if (!value(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "listValue_1", pos)) break;
      pos = current_position_(builder);
    }
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // identifier
  public static boolean namedType(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "namedType")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = identifier(builder, level + 1);
    exit_section_(builder, marker, NAMED_TYPE, result);
    return result;
  }

  /* ********************************************************** */
  // (namedType | listType) '!'
  public static boolean nonNullType(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "nonNullType")) return false;
    if (!nextTokenIs(builder, "<non null type>", BRACKET_L, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NONE_, NON_NULL_TYPE, "<non null type>");
    result = nonNullType_0(builder, level + 1);
    result = result && consumeToken(builder, BANG);
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  // namedType | listType
  private static boolean nonNullType_0(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "nonNullType_0")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = namedType(builder, level + 1);
    if (!result) result = listType(builder, level + 1);
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // 'null'
  public static boolean nullValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "nullValue")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NONE_, NULL_VALUE, "<null value>");
    result = consumeToken(builder, "null");
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean numberValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "numberValue")) return false;
    if (!nextTokenIs(builder, NUMBER)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, NUMBER);
    exit_section_(builder, marker, NUMBER_VALUE, result);
    return result;
  }

  /* ********************************************************** */
  // identifier ':' value
  public static boolean objectField(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "objectField")) return false;
    if (!nextTokenIs(builder, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = identifier(builder, level + 1);
    result = result && consumeToken(builder, COLON);
    result = result && value(builder, level + 1);
    exit_section_(builder, marker, OBJECT_FIELD, result);
    return result;
  }

  /* ********************************************************** */
  // '{' objectField+ '}'
  public static boolean objectValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "objectValue")) return false;
    if (!nextTokenIs(builder, BRACE_L)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, OBJECT_VALUE, null);
    result = consumeToken(builder, BRACE_L);
    pinned = result; // pin = 1
    result = result && report_error_(builder, objectValue_1(builder, level + 1));
    result = pinned && consumeToken(builder, BRACE_R) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // objectField+
  private static boolean objectValue_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "objectValue_1")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = objectField(builder, level + 1);
    int pos = current_position_(builder);
    while (result) {
      if (!objectField(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "objectValue_1", pos)) break;
      pos = current_position_(builder);
    }
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // operationType identifier? variableDefinitions? directives? selectionSet
  public static boolean operationDefinition(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "operationDefinition")) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, OPERATION_DEFINITION, "<operation definition>");
    result = operationType(builder, level + 1);
    pinned = result; // pin = 1
    result = result && report_error_(builder, operationDefinition_1(builder, level + 1));
    result = pinned && report_error_(builder, operationDefinition_2(builder, level + 1)) && result;
    result = pinned && report_error_(builder, operationDefinition_3(builder, level + 1)) && result;
    result = pinned && selectionSet(builder, level + 1) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // identifier?
  private static boolean operationDefinition_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "operationDefinition_1")) return false;
    identifier(builder, level + 1);
    return true;
  }

  // variableDefinitions?
  private static boolean operationDefinition_2(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "operationDefinition_2")) return false;
    variableDefinitions(builder, level + 1);
    return true;
  }

  // directives?
  private static boolean operationDefinition_3(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "operationDefinition_3")) return false;
    directives(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // 'query' | 'mutation' | 'subscription'
  public static boolean operationType(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "operationType")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _NONE_, OPERATION_TYPE, "<operation type>");
    result = consumeToken(builder, "query");
    if (!result) result = consumeToken(builder, "mutation");
    if (!result) result = consumeToken(builder, "subscription");
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // definition*
  static boolean queryDocument(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "queryDocument")) return false;
    int pos = current_position_(builder);
    while (true) {
      if (!definition(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "queryDocument", pos)) break;
      pos = current_position_(builder);
    }
    return true;
  }

  /* ********************************************************** */
  // aliasedField | field | fragmentSpread | inlineFragment
  public static boolean selection(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "selection")) return false;
    if (!nextTokenIs(builder, "<selection>", SPREAD, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _COLLAPSE_, SELECTION, "<selection>");
    result = aliasedField(builder, level + 1);
    if (!result) result = field(builder, level + 1);
    if (!result) result = fragmentSpread(builder, level + 1);
    if (!result) result = inlineFragment(builder, level + 1);
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // '{' selection+ '}'
  public static boolean selectionSet(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "selectionSet")) return false;
    if (!nextTokenIs(builder, BRACE_L)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, SELECTION_SET, null);
    result = consumeToken(builder, BRACE_L);
    pinned = result; // pin = 1
    result = result && report_error_(builder, selectionSet_1(builder, level + 1));
    result = pinned && consumeToken(builder, BRACE_R) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // selection+
  private static boolean selectionSet_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "selectionSet_1")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = selection(builder, level + 1);
    int pos = current_position_(builder);
    while (result) {
      if (!selection(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "selectionSet_1", pos)) break;
      pos = current_position_(builder);
    }
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // selectionSet
  public static boolean shorthandQueryDefinition(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "shorthandQueryDefinition")) return false;
    if (!nextTokenIs(builder, BRACE_L)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = selectionSet(builder, level + 1);
    exit_section_(builder, marker, SHORTHAND_QUERY_DEFINITION, result);
    return result;
  }

  /* ********************************************************** */
  // STRING
  public static boolean stringValue(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "stringValue")) return false;
    if (!nextTokenIs(builder, STRING)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, STRING);
    exit_section_(builder, marker, STRING_VALUE, result);
    return result;
  }

  /* ********************************************************** */
  // listType | nonNullType | namedType
  public static boolean type(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "type")) return false;
    if (!nextTokenIs(builder, "<type>", BRACKET_L, NAME)) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _COLLAPSE_, TYPE, "<type>");
    result = listType(builder, level + 1);
    if (!result) result = nonNullType(builder, level + 1);
    if (!result) result = namedType(builder, level + 1);
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // 'on' namedType
  static boolean typeCondition(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "typeCondition")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = consumeToken(builder, "on");
    result = result && namedType(builder, level + 1);
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // variableReference | numberValue | stringValue | booleanValue | nullValue | enumValue | listValue | objectValue
  public static boolean value(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "value")) return false;
    boolean result;
    Marker marker = enter_section_(builder, level, _COLLAPSE_, VALUE, "<value>");
    result = variableReference(builder, level + 1);
    if (!result) result = numberValue(builder, level + 1);
    if (!result) result = stringValue(builder, level + 1);
    if (!result) result = booleanValue(builder, level + 1);
    if (!result) result = nullValue(builder, level + 1);
    if (!result) result = enumValue(builder, level + 1);
    if (!result) result = listValue(builder, level + 1);
    if (!result) result = objectValue(builder, level + 1);
    exit_section_(builder, level, marker, result, false, null);
    return result;
  }

  /* ********************************************************** */
  // '$' identifier
  public static boolean variable(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "variable")) return false;
    if (!nextTokenIs(builder, DOLLAR)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_, VARIABLE, null);
    result = consumeToken(builder, DOLLAR);
    pinned = result; // pin = 1
    result = result && identifier(builder, level + 1);
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  /* ********************************************************** */
  // variable ':' type defaultValue?
  public static boolean variableDefinition(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "variableDefinition")) return false;
    if (!nextTokenIs(builder, DOLLAR)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = variable(builder, level + 1);
    result = result && consumeToken(builder, COLON);
    result = result && type(builder, level + 1);
    result = result && variableDefinition_3(builder, level + 1);
    exit_section_(builder, marker, VARIABLE_DEFINITION, result);
    return result;
  }

  // defaultValue?
  private static boolean variableDefinition_3(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "variableDefinition_3")) return false;
    defaultValue(builder, level + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' variableDefinition+ ')'
  static boolean variableDefinitions(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "variableDefinitions")) return false;
    if (!nextTokenIs(builder, PAREN_L)) return false;
    boolean result, pinned;
    Marker marker = enter_section_(builder, level, _NONE_);
    result = consumeToken(builder, PAREN_L);
    pinned = result; // pin = 1
    result = result && report_error_(builder, variableDefinitions_1(builder, level + 1));
    result = pinned && consumeToken(builder, PAREN_R) && result;
    exit_section_(builder, level, marker, result, pinned, null);
    return result || pinned;
  }

  // variableDefinition+
  private static boolean variableDefinitions_1(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "variableDefinitions_1")) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = variableDefinition(builder, level + 1);
    int pos = current_position_(builder);
    while (result) {
      if (!variableDefinition(builder, level + 1)) break;
      if (!empty_element_parsed_guard_(builder, "variableDefinitions_1", pos)) break;
      pos = current_position_(builder);
    }
    exit_section_(builder, marker, null, result);
    return result;
  }

  /* ********************************************************** */
  // variable
  public static boolean variableReference(PsiBuilder builder, int level) {
    if (!recursion_guard_(builder, level, "variableReference")) return false;
    if (!nextTokenIs(builder, DOLLAR)) return false;
    boolean result;
    Marker marker = enter_section_(builder);
    result = variable(builder, level + 1);
    exit_section_(builder, marker, VARIABLE_REFERENCE, result);
    return result;
  }

  final static Parser definitionRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder, int level) {
      return definitionRecover(builder, level + 1);
    }
  };
}

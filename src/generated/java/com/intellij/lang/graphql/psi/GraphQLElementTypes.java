// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graphql.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.graphql.psi.impl.*;

public interface GraphQLElementTypes {

  IElementType ALIASED_FIELD = new GraphQLCompositeElementType("ALIASED_FIELD");
  IElementType ARGUMENT = new GraphQLCompositeElementType("ARGUMENT");
  IElementType BOOLEAN_VALUE = new GraphQLCompositeElementType("BOOLEAN_VALUE");
  IElementType DIRECTIVE = new GraphQLCompositeElementType("DIRECTIVE");
  IElementType ENUM_VALUE = new GraphQLCompositeElementType("ENUM_VALUE");
  IElementType FIELD = new GraphQLCompositeElementType("FIELD");
  IElementType FRAGMENT_DEFINITION = new GraphQLCompositeElementType("FRAGMENT_DEFINITION");
  IElementType FRAGMENT_SPREAD = new GraphQLCompositeElementType("FRAGMENT_SPREAD");
  IElementType IDENTIFIER = new GraphQLCompositeElementType("IDENTIFIER");
  IElementType INLINE_FRAGMENT = new GraphQLCompositeElementType("INLINE_FRAGMENT");
  IElementType LIST_TYPE = new GraphQLCompositeElementType("LIST_TYPE");
  IElementType LIST_VALUE = new GraphQLCompositeElementType("LIST_VALUE");
  IElementType NAMED_TYPE = new GraphQLCompositeElementType("NAMED_TYPE");
  IElementType NON_NULL_TYPE = new GraphQLCompositeElementType("NON_NULL_TYPE");
  IElementType NULL_VALUE = new GraphQLCompositeElementType("NULL_VALUE");
  IElementType NUMBER_VALUE = new GraphQLCompositeElementType("NUMBER_VALUE");
  IElementType OBJECT_FIELD = new GraphQLCompositeElementType("OBJECT_FIELD");
  IElementType OBJECT_VALUE = new GraphQLCompositeElementType("OBJECT_VALUE");
  IElementType OPERATION_DEFINITION = new GraphQLCompositeElementType("OPERATION_DEFINITION");
  IElementType OPERATION_TYPE = new GraphQLCompositeElementType("OPERATION_TYPE");
  IElementType SELECTION = new GraphQLCompositeElementType("SELECTION");
  IElementType SELECTION_SET = new GraphQLCompositeElementType("SELECTION_SET");
  IElementType SHORTHAND_QUERY_DEFINITION = new GraphQLCompositeElementType("SHORTHAND_QUERY_DEFINITION");
  IElementType STRING_VALUE = new GraphQLCompositeElementType("STRING_VALUE");
  IElementType TYPE = new GraphQLCompositeElementType("TYPE");
  IElementType VALUE = new GraphQLCompositeElementType("VALUE");
  IElementType VARIABLE = new GraphQLCompositeElementType("VARIABLE");
  IElementType VARIABLE_DEFINITION = new GraphQLCompositeElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_REFERENCE = new GraphQLCompositeElementType("VARIABLE_REFERENCE");

  IElementType AT = new GraphQLTokenType("@");
  IElementType BANG = new GraphQLTokenType("!");
  IElementType BRACE_L = new GraphQLTokenType("{");
  IElementType BRACE_R = new GraphQLTokenType("}");
  IElementType BRACKET_L = new GraphQLTokenType("[");
  IElementType BRACKET_R = new GraphQLTokenType("]");
  IElementType COLON = new GraphQLTokenType(":");
  IElementType COMMENT = new GraphQLTokenType("COMMENT");
  IElementType DOLLAR = new GraphQLTokenType("$");
  IElementType EQUALS = new GraphQLTokenType("=");
  IElementType KEYWORD = new GraphQLTokenType("KEYWORD");
  IElementType NAME = new GraphQLTokenType("NAME");
  IElementType NUMBER = new GraphQLTokenType("NUMBER");
  IElementType PAREN_L = new GraphQLTokenType("(");
  IElementType PAREN_R = new GraphQLTokenType(")");
  IElementType PIPE = new GraphQLTokenType("|");
  IElementType SPREAD = new GraphQLTokenType("...");
  IElementType STRING = new GraphQLTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ALIASED_FIELD) {
        return new GraphQLAliasedFieldImpl(node);
      }
      else if (type == ARGUMENT) {
        return new GraphQLArgumentImpl(node);
      }
      else if (type == BOOLEAN_VALUE) {
        return new GraphQLBooleanValueImpl(node);
      }
      else if (type == DIRECTIVE) {
        return new GraphQLDirectiveImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new GraphQLEnumValueImpl(node);
      }
      else if (type == FIELD) {
        return new GraphQLFieldImpl(node);
      }
      else if (type == FRAGMENT_DEFINITION) {
        return new GraphQLFragmentDefinitionImpl(node);
      }
      else if (type == FRAGMENT_SPREAD) {
        return new GraphQLFragmentSpreadImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new GraphQLIdentifierImpl(node);
      }
      else if (type == INLINE_FRAGMENT) {
        return new GraphQLInlineFragmentImpl(node);
      }
      else if (type == LIST_TYPE) {
        return new GraphQLListTypeImpl(node);
      }
      else if (type == LIST_VALUE) {
        return new GraphQLListValueImpl(node);
      }
      else if (type == NAMED_TYPE) {
        return new GraphQLNamedTypeImpl(node);
      }
      else if (type == NON_NULL_TYPE) {
        return new GraphQLNonNullTypeImpl(node);
      }
      else if (type == NULL_VALUE) {
        return new GraphQLNullValueImpl(node);
      }
      else if (type == NUMBER_VALUE) {
        return new GraphQLNumberValueImpl(node);
      }
      else if (type == OBJECT_FIELD) {
        return new GraphQLObjectFieldImpl(node);
      }
      else if (type == OBJECT_VALUE) {
        return new GraphQLObjectValueImpl(node);
      }
      else if (type == OPERATION_DEFINITION) {
        return new GraphQLOperationDefinitionImpl(node);
      }
      else if (type == OPERATION_TYPE) {
        return new GraphQLOperationTypeImpl(node);
      }
      else if (type == SELECTION_SET) {
        return new GraphQLSelectionSetImpl(node);
      }
      else if (type == SHORTHAND_QUERY_DEFINITION) {
        return new GraphQLShorthandQueryDefinitionImpl(node);
      }
      else if (type == STRING_VALUE) {
        return new GraphQLStringValueImpl(node);
      }
      else if (type == VARIABLE) {
        return new GraphQLVariableImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new GraphQLVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new GraphQLVariableReferenceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

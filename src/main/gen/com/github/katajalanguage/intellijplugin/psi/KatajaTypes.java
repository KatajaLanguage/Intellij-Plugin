// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.katajalanguage.intellijplugin.parser.KatajaElementType;
import com.github.katajalanguage.intellijplugin.lexer.KatajaTokenType;
import com.github.katajalanguage.intellijplugin.psi.impl.*;

public interface KatajaTypes {

  IElementType ACCESS_MODIFIER = new KatajaElementType("ACCESS_MODIFIER");
  IElementType CALC = new KatajaElementType("CALC");
  IElementType CALC_ARG = new KatajaElementType("CALC_ARG");
  IElementType CALL = new KatajaElementType("CALL");
  IElementType CALL_ARG = new KatajaElementType("CALL_ARG");
  IElementType CLAZZ = new KatajaElementType("CLAZZ");
  IElementType CODE = new KatajaElementType("CODE");
  IElementType COMPLEX_TYPE = new KatajaElementType("COMPLEX_TYPE");
  IElementType DATA = new KatajaElementType("DATA");
  IElementType DATA_TYPE = new KatajaElementType("DATA_TYPE");
  IElementType DO = new KatajaElementType("DO");
  IElementType END_OF_STATEMENT = new KatajaElementType("END_OF_STATEMENT");
  IElementType FIELD = new KatajaElementType("FIELD");
  IElementType FOR = new KatajaElementType("FOR");
  IElementType GENERIC_TYPE = new KatajaElementType("GENERIC_TYPE");
  IElementType IF = new KatajaElementType("IF");
  IElementType INTERFACE = new KatajaElementType("INTERFACE");
  IElementType IN_CLASS_STATEMENT = new KatajaElementType("IN_CLASS_STATEMENT");
  IElementType IN_FILE_STATEMENT = new KatajaElementType("IN_FILE_STATEMENT");
  IElementType IN_METHOD_STATEMENT = new KatajaElementType("IN_METHOD_STATEMENT");
  IElementType METHOD = new KatajaElementType("METHOD");
  IElementType MODIFIER = new KatajaElementType("MODIFIER");
  IElementType MULTI_USE = new KatajaElementType("MULTI_USE");
  IElementType PARAMETER = new KatajaElementType("PARAMETER");
  IElementType PARAMETER_LIST = new KatajaElementType("PARAMETER_LIST");
  IElementType PRIMITIVE_TYPE = new KatajaElementType("PRIMITIVE_TYPE");
  IElementType RETURN = new KatajaElementType("RETURN");
  IElementType SIMPLE_WHITE_SPACE = new KatajaElementType("SIMPLE_WHITE_SPACE");
  IElementType SINGLE_USE = new KatajaElementType("SINGLE_USE");
  IElementType STATEMENT = new KatajaElementType("STATEMENT");
  IElementType TYPE = new KatajaElementType("TYPE");
  IElementType VALUE = new KatajaElementType("VALUE");
  IElementType WHILE = new KatajaElementType("WHILE");
  IElementType WHITESPACES = new KatajaElementType("WHITESPACES");

  IElementType CHAR = new KatajaTokenType("CHAR");
  IElementType COMMENT = new KatajaTokenType("COMMENT");
  IElementType IDENTIFIER = new KatajaTokenType("IDENTIFIER");
  IElementType NEW_LINE = new KatajaTokenType("NEW_LINE");
  IElementType NUMBER = new KatajaTokenType("NUMBER");
  IElementType OPERATOR = new KatajaTokenType("OPERATOR");
  IElementType PRIMITIVE = new KatajaTokenType("PRIMITIVE");
  IElementType WHITESPACE = new KatajaTokenType("WHITESPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACCESS_MODIFIER) {
        return new KatajaAccessModifierImpl(node);
      }
      else if (type == CALC) {
        return new KatajaCalcImpl(node);
      }
      else if (type == CALC_ARG) {
        return new KatajaCalcArgImpl(node);
      }
      else if (type == CALL) {
        return new KatajaCallImpl(node);
      }
      else if (type == CALL_ARG) {
        return new KatajaCallArgImpl(node);
      }
      else if (type == CLAZZ) {
        return new KatajaClazzImpl(node);
      }
      else if (type == CODE) {
        return new KatajaCodeImpl(node);
      }
      else if (type == COMPLEX_TYPE) {
        return new KatajaComplexTypeImpl(node);
      }
      else if (type == DATA) {
        return new KatajaDataImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new KatajaDataTypeImpl(node);
      }
      else if (type == DO) {
        return new KatajaDoImpl(node);
      }
      else if (type == END_OF_STATEMENT) {
        return new KatajaEndOfStatementImpl(node);
      }
      else if (type == FIELD) {
        return new KatajaFieldImpl(node);
      }
      else if (type == FOR) {
        return new KatajaForImpl(node);
      }
      else if (type == GENERIC_TYPE) {
        return new KatajaGenericTypeImpl(node);
      }
      else if (type == IF) {
        return new KatajaIfImpl(node);
      }
      else if (type == INTERFACE) {
        return new KatajaInterfaceImpl(node);
      }
      else if (type == IN_CLASS_STATEMENT) {
        return new KatajaInClassStatementImpl(node);
      }
      else if (type == IN_FILE_STATEMENT) {
        return new KatajaInFileStatementImpl(node);
      }
      else if (type == IN_METHOD_STATEMENT) {
        return new KatajaInMethodStatementImpl(node);
      }
      else if (type == METHOD) {
        return new KatajaMethodImpl(node);
      }
      else if (type == MODIFIER) {
        return new KatajaModifierImpl(node);
      }
      else if (type == MULTI_USE) {
        return new KatajaMultiUseImpl(node);
      }
      else if (type == PARAMETER) {
        return new KatajaParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new KatajaParameterListImpl(node);
      }
      else if (type == PRIMITIVE_TYPE) {
        return new KatajaPrimitiveTypeImpl(node);
      }
      else if (type == RETURN) {
        return new KatajaReturnImpl(node);
      }
      else if (type == SIMPLE_WHITE_SPACE) {
        return new KatajaSimpleWhiteSpaceImpl(node);
      }
      else if (type == SINGLE_USE) {
        return new KatajaSingleUseImpl(node);
      }
      else if (type == STATEMENT) {
        return new KatajaStatementImpl(node);
      }
      else if (type == TYPE) {
        return new KatajaTypeImpl(node);
      }
      else if (type == VALUE) {
        return new KatajaValueImpl(node);
      }
      else if (type == WHILE) {
        return new KatajaWhileImpl(node);
      }
      else if (type == WHITESPACES) {
        return new KatajaWhitespacesImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

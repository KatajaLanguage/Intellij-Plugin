// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.katajalanguage.intellijplugin.psi.KatajaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;

import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KatajaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return katajaFile(b, l + 1);
  }

  /* ********************************************************** */
  // 'public' | 'proteced' | 'private'
  public static boolean accessModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "accessModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESS_MODIFIER, "<access modifier>");
    r = consumeToken(b, "public");
    if (!r) r = consumeToken(b, "proteced");
    if (!r) r = consumeToken(b, "private");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // calcArg (OPERATOR calcArg)*
  public static boolean calc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALC, "<calc>");
    r = calcArg(b, l + 1);
    r = r && calc_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OPERATOR calcArg)*
  private static boolean calc_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calc_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!calc_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "calc_1", c)) break;
    }
    return true;
  }

  // OPERATOR calcArg
  private static boolean calc_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calc_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR);
    r = r && calcArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (OPERATOR? (value | call)) | ('(' calc ')') | (IDENTIFIER calc)
  public static boolean calcArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calcArg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALC_ARG, "<calc arg>");
    r = calcArg_0(b, l + 1);
    if (!r) r = calcArg_1(b, l + 1);
    if (!r) r = calcArg_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPERATOR? (value | call)
  private static boolean calcArg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calcArg_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = calcArg_0_0(b, l + 1);
    r = r && calcArg_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPERATOR?
  private static boolean calcArg_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calcArg_0_0")) return false;
    consumeToken(b, OPERATOR);
    return true;
  }

  // value | call
  private static boolean calcArg_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calcArg_0_1")) return false;
    boolean r;
    r = value(b, l + 1);
    if (!r) r = call(b, l + 1);
    return r;
  }

  // '(' calc ')'
  private static boolean calcArg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calcArg_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && calc(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER calc
  private static boolean calcArg_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calcArg_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && calc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // callArg ('.' callArg)*
  public static boolean call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = callArg(b, l + 1);
    r = r && call_1(b, l + 1);
    exit_section_(b, m, CALL, r);
    return r;
  }

  // ('.' callArg)*
  private static boolean call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!call_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "call_1", c)) break;
    }
    return true;
  }

  // '.' callArg
  private static boolean call_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && callArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('<' complexType '>')? ('(' (calc (',' calc)*)? ')')? ('[' calc ']')*
  public static boolean callArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && callArg_1(b, l + 1);
    r = r && callArg_2(b, l + 1);
    r = r && callArg_3(b, l + 1);
    exit_section_(b, m, CALL_ARG, r);
    return r;
  }

  // ('<' complexType '>')?
  private static boolean callArg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_1")) return false;
    callArg_1_0(b, l + 1);
    return true;
  }

  // '<' complexType '>'
  private static boolean callArg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<");
    r = r && complexType(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('(' (calc (',' calc)*)? ')')?
  private static boolean callArg_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_2")) return false;
    callArg_2_0(b, l + 1);
    return true;
  }

  // '(' (calc (',' calc)*)? ')'
  private static boolean callArg_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && callArg_2_0_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (calc (',' calc)*)?
  private static boolean callArg_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_2_0_1")) return false;
    callArg_2_0_1_0(b, l + 1);
    return true;
  }

  // calc (',' calc)*
  private static boolean callArg_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = calc(b, l + 1);
    r = r && callArg_2_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' calc)*
  private static boolean callArg_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_2_0_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!callArg_2_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "callArg_2_0_1_0_1", c)) break;
    }
    return true;
  }

  // ',' calc
  private static boolean callArg_2_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_2_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && calc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('[' calc ']')*
  private static boolean callArg_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!callArg_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "callArg_3", c)) break;
    }
    return true;
  }

  // '[' calc ']'
  private static boolean callArg_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArg_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && calc(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifier 'class' IDENTIFIER genericType ('extends' IDENTIFIER (',' IDENTIFIER)*)? '{' (whitespaces? inClassStatement*)* '}'
  public static boolean clazz(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLAZZ, "<clazz>");
    r = modifier(b, l + 1);
    r = r && consumeToken(b, "class");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && genericType(b, l + 1);
    r = r && clazz_4(b, l + 1);
    r = r && consumeToken(b, "{");
    r = r && clazz_6(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('extends' IDENTIFIER (',' IDENTIFIER)*)?
  private static boolean clazz_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_4")) return false;
    clazz_4_0(b, l + 1);
    return true;
  }

  // 'extends' IDENTIFIER (',' IDENTIFIER)*
  private static boolean clazz_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "extends");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && clazz_4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean clazz_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_4_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!clazz_4_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "clazz_4_0_2", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean clazz_4_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_4_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespaces? inClassStatement*)*
  private static boolean clazz_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!clazz_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "clazz_6", c)) break;
    }
    return true;
  }

  // whitespaces? inClassStatement*
  private static boolean clazz_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = clazz_6_0_0(b, l + 1);
    r = r && clazz_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespaces?
  private static boolean clazz_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_6_0_0")) return false;
    whitespaces(b, l + 1);
    return true;
  }

  // inClassStatement*
  private static boolean clazz_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "clazz_6_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inClassStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "clazz_6_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ('->' inMethodStatement) | ('{' (whitespaces? inMethodStatement*)* '}')
  public static boolean code(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE, "<code>");
    r = code_0(b, l + 1);
    if (!r) r = code_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '->' inMethodStatement
  private static boolean code_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "->");
    r = r && inMethodStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' (whitespaces? inMethodStatement*)* '}'
  private static boolean code_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && code_1_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespaces? inMethodStatement*)*
  private static boolean code_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!code_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "code_1_1", c)) break;
    }
    return true;
  }

  // whitespaces? inMethodStatement*
  private static boolean code_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = code_1_1_0_0(b, l + 1);
    r = r && code_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespaces?
  private static boolean code_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_1_1_0_0")) return false;
    whitespaces(b, l + 1);
    return true;
  }

  // inMethodStatement*
  private static boolean code_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inMethodStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "code_1_1_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER ('<' complexType '>')? ('['']')*
  public static boolean complexType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && complexType_1(b, l + 1);
    r = r && complexType_2(b, l + 1);
    exit_section_(b, m, COMPLEX_TYPE, r);
    return r;
  }

  // ('<' complexType '>')?
  private static boolean complexType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType_1")) return false;
    complexType_1_0(b, l + 1);
    return true;
  }

  // '<' complexType '>'
  private static boolean complexType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<");
    r = r && complexType(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('['']')*
  private static boolean complexType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!complexType_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "complexType_2", c)) break;
    }
    return true;
  }

  // '['']'
  private static boolean complexType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifier 'data' IDENTIFIER '=' parameterList
  public static boolean data(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA, "<data>");
    r = modifier(b, l + 1);
    r = r && consumeToken(b, "data");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && parameterList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primitiveType | complexType
  public static boolean dataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType")) return false;
    if (!nextTokenIs(b, "<data type>", IDENTIFIER, PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_TYPE, "<data type>");
    r = primitiveType(b, l + 1);
    if (!r) r = complexType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'do' ('{' (whitespace* inMethodStatement*)* '}') while calc endOfStatement
  public static boolean do_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "do_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DO, "<do $>");
    r = consumeToken(b, "do");
    r = r && do_1(b, l + 1);
    r = r && while_$(b, l + 1);
    r = r && calc(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '{' (whitespace* inMethodStatement*)* '}'
  private static boolean do_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "do_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && do_1_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespace* inMethodStatement*)*
  private static boolean do_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "do_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!do_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "do_1_1", c)) break;
    }
    return true;
  }

  // whitespace* inMethodStatement*
  private static boolean do_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "do_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = do_1_1_0_0(b, l + 1);
    r = r && do_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean do_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "do_1_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "do_1_1_0_0", c)) break;
    }
    return true;
  }

  // inMethodStatement*
  private static boolean do_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "do_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inMethodStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "do_1_1_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ';' | NEW_LINE
  public static boolean endOfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endOfStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, END_OF_STATEMENT, "<end of statement>");
    r = consumeToken(b, ";");
    if (!r) r = consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // modifier dataType IDENTIFIER ('=' calc)? endOfStatement
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = modifier(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && field_3(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('=' calc)?
  private static boolean field_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_3")) return false;
    field_3_0(b, l + 1);
    return true;
  }

  // '=' calc
  private static boolean field_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && calc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'for' IDENTIFIER 'in' calc code endOfStatement
  public static boolean for_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR, "<for $>");
    r = consumeToken(b, "for");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "in");
    r = r && calc(b, l + 1);
    r = r && code(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '<' IDENTIFIER ('extends' IDENTIFIER)? '>'
  public static boolean genericType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE, "<generic type>");
    r = consumeToken(b, "<");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && genericType_2(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('extends' IDENTIFIER)?
  private static boolean genericType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericType_2")) return false;
    genericType_2_0(b, l + 1);
    return true;
  }

  // 'extends' IDENTIFIER
  private static boolean genericType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "extends");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'if' calc code ('else' 'if' calc code)* ('else' code)? endOfStatement
  public static boolean if_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF, "<if $>");
    r = consumeToken(b, "if");
    r = r && calc(b, l + 1);
    r = r && code(b, l + 1);
    r = r && if_3(b, l + 1);
    r = r && if_4(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('else' 'if' calc code)*
  private static boolean if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_3", c)) break;
    }
    return true;
  }

  // 'else' 'if' calc code
  private static boolean if_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && consumeToken(b, "if");
    r = r && calc(b, l + 1);
    r = r && code(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' code)?
  private static boolean if_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_4")) return false;
    if_4_0(b, l + 1);
    return true;
  }

  // 'else' code
  private static boolean if_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && code(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // field | method
  public static boolean inClassStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inClassStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IN_CLASS_STATEMENT, "<in class statement>");
    r = field(b, l + 1);
    if (!r) r = method(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // singleUse | multiUse | field | type | data | interface | clazz
  public static boolean inFileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inFileStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IN_FILE_STATEMENT, "<in file statement>");
    r = singleUse(b, l + 1);
    if (!r) r = multiUse(b, l + 1);
    if (!r) r = field(b, l + 1);
    if (!r) r = type(b, l + 1);
    if (!r) r = data(b, l + 1);
    if (!r) r = interface_$(b, l + 1);
    if (!r) r = clazz(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // return | if | while | for | do | statement | ('break' endOfStatement) | (calc  endOfStatement)
  public static boolean inMethodStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inMethodStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IN_METHOD_STATEMENT, "<in method statement>");
    r = return_$(b, l + 1);
    if (!r) r = if_$(b, l + 1);
    if (!r) r = while_$(b, l + 1);
    if (!r) r = for_$(b, l + 1);
    if (!r) r = do_$(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = inMethodStatement_6(b, l + 1);
    if (!r) r = inMethodStatement_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'break' endOfStatement
  private static boolean inMethodStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inMethodStatement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "break");
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // calc  endOfStatement
  private static boolean inMethodStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inMethodStatement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = calc(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifier 'interface' IDENTIFIER genericType '{' (whitespaces? inClassStatement*)* '}'
  public static boolean interface_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE, "<interface $>");
    r = modifier(b, l + 1);
    r = r && consumeToken(b, "interface");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && genericType(b, l + 1);
    r = r && consumeToken(b, "{");
    r = r && interface_5(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespaces? inClassStatement*)*
  private static boolean interface_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!interface_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "interface_5", c)) break;
    }
    return true;
  }

  // whitespaces? inClassStatement*
  private static boolean interface_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = interface_5_0_0(b, l + 1);
    r = r && interface_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespaces?
  private static boolean interface_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_5_0_0")) return false;
    whitespaces(b, l + 1);
    return true;
  }

  // inClassStatement*
  private static boolean interface_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inClassStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "interface_5_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (whitespaces? inFileStatement*)*
  static boolean katajaFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "katajaFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!katajaFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "katajaFile", c)) break;
    }
    return true;
  }

  // whitespaces? inFileStatement*
  private static boolean katajaFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "katajaFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = katajaFile_0_0(b, l + 1);
    r = r && katajaFile_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespaces?
  private static boolean katajaFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "katajaFile_0_0")) return false;
    whitespaces(b, l + 1);
    return true;
  }

  // inFileStatement*
  private static boolean katajaFile_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "katajaFile_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inFileStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "katajaFile_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ((modifier dataType IDENTIFIER parameterList) | 'main') (('=' inMethodStatement) | code)
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = method_0(b, l + 1);
    r = r && method_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (modifier dataType IDENTIFIER parameterList) | 'main'
  private static boolean method_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_0_0(b, l + 1);
    if (!r) r = consumeToken(b, "main");
    exit_section_(b, m, null, r);
    return r;
  }

  // modifier dataType IDENTIFIER parameterList
  private static boolean method_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && parameterList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' inMethodStatement) | code
  private static boolean method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_1_0(b, l + 1);
    if (!r) r = code(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' inMethodStatement
  private static boolean method_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && inMethodStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // accessModifier? ('final' | 'const' | 'abstract' | 'synchronized' | 'static' | 'volatile' | 'transient' | 'strict' | 'native')*
  public static boolean modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
    r = modifier_0(b, l + 1);
    r = r && modifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // accessModifier?
  private static boolean modifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_0")) return false;
    accessModifier(b, l + 1);
    return true;
  }

  // ('final' | 'const' | 'abstract' | 'synchronized' | 'static' | 'volatile' | 'transient' | 'strict' | 'native')*
  private static boolean modifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifier_1", c)) break;
    }
    return true;
  }

  // 'final' | 'const' | 'abstract' | 'synchronized' | 'static' | 'volatile' | 'transient' | 'strict' | 'native'
  private static boolean modifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_1_0")) return false;
    boolean r;
    r = consumeToken(b, "final");
    if (!r) r = consumeToken(b, "const");
    if (!r) r = consumeToken(b, "abstract");
    if (!r) r = consumeToken(b, "synchronized");
    if (!r) r = consumeToken(b, "static");
    if (!r) r = consumeToken(b, "volatile");
    if (!r) r = consumeToken(b, "transient");
    if (!r) r = consumeToken(b, "strict");
    if (!r) r = consumeToken(b, "native");
    return r;
  }

  /* ********************************************************** */
  // 'use' simpleWhiteSpace IDENTIFIER (',' IDENTIFIER)+ 'from' IDENTIFIER ('/' IDENTIFIER)*
  public static boolean multiUse(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiUse")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTI_USE, "<multi use>");
    r = consumeToken(b, "use");
    r = r && simpleWhiteSpace(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && multiUse_3(b, l + 1);
    r = r && consumeToken(b, "from");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && multiUse_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' IDENTIFIER)+
  private static boolean multiUse_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiUse_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiUse_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!multiUse_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiUse_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' IDENTIFIER
  private static boolean multiUse_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiUse_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('/' IDENTIFIER)*
  private static boolean multiUse_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiUse_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiUse_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiUse_6", c)) break;
    }
    return true;
  }

  // '/' IDENTIFIER
  private static boolean multiUse_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiUse_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'const'? dataType IDENTIFIER
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = parameter_0(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'const'?
  private static boolean parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0")) return false;
    consumeToken(b, "const");
    return true;
  }

  /* ********************************************************** */
  // '(' (parameter (',' parameter)*) ')'
  public static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    r = consumeToken(b, "(");
    r = r && parameterList_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // parameter (',' parameter)*
  private static boolean parameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && parameterList_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' parameter)*
  private static boolean parameterList_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameterList_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_1_1", c)) break;
    }
    return true;
  }

  // ',' parameter
  private static boolean parameterList_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PRIMITIVE ('['']')*
  public static boolean primitiveType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveType")) return false;
    if (!nextTokenIs(b, PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PRIMITIVE);
    r = r && primitiveType_1(b, l + 1);
    exit_section_(b, m, PRIMITIVE_TYPE, r);
    return r;
  }

  // ('['']')*
  private static boolean primitiveType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveType_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primitiveType_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primitiveType_1", c)) break;
    }
    return true;
  }

  // '['']'
  private static boolean primitiveType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'return' calc endOfStatement
  public static boolean return_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETURN, "<return $>");
    r = consumeToken(b, "return");
    r = r && calc(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (WHITESPACE | COMMENT | NEW_LINE)+
  public static boolean simpleWhiteSpace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleWhiteSpace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_WHITE_SPACE, "<simple white space>");
    r = simpleWhiteSpace_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!simpleWhiteSpace_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleWhiteSpace", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITESPACE | COMMENT | NEW_LINE
  private static boolean simpleWhiteSpace_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleWhiteSpace_0")) return false;
    boolean r;
    r = consumeToken(b, WHITESPACE);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // 'use' simpleWhiteSpace IDENTIFIER ((('/' IDENTIFIER)+ ('from' IDENTIFIER)?) | (('from' IDENTIFIER)?)) ('as' IDENTIFIER)?
  public static boolean singleUse(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_USE, "<single use>");
    r = consumeToken(b, "use");
    r = r && simpleWhiteSpace(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && singleUse_3(b, l + 1);
    r = r && singleUse_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (('/' IDENTIFIER)+ ('from' IDENTIFIER)?) | (('from' IDENTIFIER)?)
  private static boolean singleUse_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = singleUse_3_0(b, l + 1);
    if (!r) r = singleUse_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('/' IDENTIFIER)+ ('from' IDENTIFIER)?
  private static boolean singleUse_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = singleUse_3_0_0(b, l + 1);
    r = r && singleUse_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('/' IDENTIFIER)+
  private static boolean singleUse_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = singleUse_3_0_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!singleUse_3_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "singleUse_3_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '/' IDENTIFIER
  private static boolean singleUse_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('from' IDENTIFIER)?
  private static boolean singleUse_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_0_1")) return false;
    singleUse_3_0_1_0(b, l + 1);
    return true;
  }

  // 'from' IDENTIFIER
  private static boolean singleUse_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "from");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('from' IDENTIFIER)?
  private static boolean singleUse_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_1")) return false;
    singleUse_3_1_0(b, l + 1);
    return true;
  }

  // 'from' IDENTIFIER
  private static boolean singleUse_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "from");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('as' IDENTIFIER)?
  private static boolean singleUse_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_4")) return false;
    singleUse_4_0(b, l + 1);
    return true;
  }

  // 'as' IDENTIFIER
  private static boolean singleUse_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleUse_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "as");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('_' | dataType)? IDENTIFIER '=' calc endOfStatement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && calc(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('_' | dataType)?
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    statement_0_0(b, l + 1);
    return true;
  }

  // '_' | dataType
  private static boolean statement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_0")) return false;
    boolean r;
    r = consumeToken(b, "_");
    if (!r) r = dataType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // modifier 'type' IDENTIFIER '=' IDENTIFIER ('|' IDENTIFIER)* endOfStatement
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = modifier(b, l + 1);
    r = r && consumeToken(b, "type");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && type_5(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('|' IDENTIFIER)*
  private static boolean type_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_5", c)) break;
    }
    return true;
  }

  // '|' IDENTIFIER
  private static boolean type_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "|");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | CHAR
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    if (!nextTokenIs(b, "<value>", CHAR, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, CHAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'while' calc code endOfStatement
  public static boolean while_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHILE, "<while $>");
    r = consumeToken(b, "while");
    r = r && calc(b, l + 1);
    r = r && code(b, l + 1);
    r = r && endOfStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (WHITESPACE | COMMENT | endOfStatement)+
  public static boolean whitespaces(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespaces")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHITESPACES, "<whitespaces>");
    r = whitespaces_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!whitespaces_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "whitespaces", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WHITESPACE | COMMENT | endOfStatement
  private static boolean whitespaces_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespaces_0")) return false;
    boolean r;
    r = consumeToken(b, WHITESPACE);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = endOfStatement(b, l + 1);
    return r;
  }

}

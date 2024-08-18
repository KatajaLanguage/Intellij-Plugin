// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KatajaDo extends PsiElement {

  @NotNull
  KatajaCalc getCalc();

  @NotNull
  KatajaEndOfStatement getEndOfStatement();

  @NotNull
  List<KatajaInMethodStatement> getInMethodStatementList();

  @NotNull
  KatajaWhile getWhile();

}

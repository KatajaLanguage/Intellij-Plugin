// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KatajaInterface extends PsiElement {

  @NotNull
  KatajaGenericType getGenericType();

  @NotNull
  List<KatajaInClassStatement> getInClassStatementList();

  @NotNull
  KatajaModifier getModifier();

  @NotNull
  List<KatajaWhitespaces> getWhitespacesList();

}

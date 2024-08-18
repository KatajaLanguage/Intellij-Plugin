// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KatajaInMethodStatement extends PsiElement {

  @Nullable
  KatajaCalc getCalc();

  @Nullable
  KatajaDo getDo();

  @Nullable
  KatajaEndOfStatement getEndOfStatement();

  @Nullable
  KatajaFor getFor();

  @Nullable
  KatajaIf getIf();

  @Nullable
  KatajaReturn getReturn();

  @Nullable
  KatajaStatement getStatement();

  @Nullable
  KatajaWhile getWhile();

}

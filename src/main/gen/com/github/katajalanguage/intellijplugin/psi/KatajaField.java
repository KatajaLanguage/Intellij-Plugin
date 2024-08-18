// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KatajaField extends PsiElement {

  @Nullable
  KatajaCalc getCalc();

  @NotNull
  KatajaDataType getDataType();

  @NotNull
  KatajaEndOfStatement getEndOfStatement();

  @NotNull
  KatajaModifier getModifier();

}

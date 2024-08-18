// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KatajaInFileStatement extends PsiElement {

  @Nullable
  KatajaClazz getClazz();

  @Nullable
  KatajaData getData();

  @Nullable
  KatajaField getField();

  @Nullable
  KatajaInterface getInterface();

  @Nullable
  KatajaMultiUse getMultiUse();

  @Nullable
  KatajaSingleUse getSingleUse();

  @Nullable
  KatajaType getType();

}

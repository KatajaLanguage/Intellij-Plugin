// This is a generated file. Not intended for manual editing.
package com.github.katajalanguage.intellijplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.katajalanguage.intellijplugin.psi.KatajaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.katajalanguage.intellijplugin.psi.*;

public class KatajaInFileStatementImpl extends ASTWrapperPsiElement implements KatajaInFileStatement {

  public KatajaInFileStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KatajaVisitor visitor) {
    visitor.visitInFileStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KatajaVisitor) accept((KatajaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KatajaClazz getClazz() {
    return findChildByClass(KatajaClazz.class);
  }

  @Override
  @Nullable
  public KatajaData getData() {
    return findChildByClass(KatajaData.class);
  }

  @Override
  @Nullable
  public KatajaField getField() {
    return findChildByClass(KatajaField.class);
  }

  @Override
  @Nullable
  public KatajaInterface getInterface() {
    return findChildByClass(KatajaInterface.class);
  }

  @Override
  @Nullable
  public KatajaMultiUse getMultiUse() {
    return findChildByClass(KatajaMultiUse.class);
  }

  @Override
  @Nullable
  public KatajaSingleUse getSingleUse() {
    return findChildByClass(KatajaSingleUse.class);
  }

  @Override
  @Nullable
  public KatajaType getType() {
    return findChildByClass(KatajaType.class);
  }

}

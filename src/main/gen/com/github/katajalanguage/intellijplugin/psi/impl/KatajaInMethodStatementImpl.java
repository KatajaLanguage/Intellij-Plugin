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

public class KatajaInMethodStatementImpl extends ASTWrapperPsiElement implements KatajaInMethodStatement {

  public KatajaInMethodStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KatajaVisitor visitor) {
    visitor.visitInMethodStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KatajaVisitor) accept((KatajaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KatajaCalc getCalc() {
    return findChildByClass(KatajaCalc.class);
  }

  @Override
  @Nullable
  public KatajaDo getDo() {
    return findChildByClass(KatajaDo.class);
  }

  @Override
  @Nullable
  public KatajaEndOfStatement getEndOfStatement() {
    return findChildByClass(KatajaEndOfStatement.class);
  }

  @Override
  @Nullable
  public KatajaFor getFor() {
    return findChildByClass(KatajaFor.class);
  }

  @Override
  @Nullable
  public KatajaIf getIf() {
    return findChildByClass(KatajaIf.class);
  }

  @Override
  @Nullable
  public KatajaReturn getReturn() {
    return findChildByClass(KatajaReturn.class);
  }

  @Override
  @Nullable
  public KatajaStatement getStatement() {
    return findChildByClass(KatajaStatement.class);
  }

  @Override
  @Nullable
  public KatajaWhile getWhile() {
    return findChildByClass(KatajaWhile.class);
  }

}

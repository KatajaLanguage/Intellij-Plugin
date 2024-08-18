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

public class KatajaIfImpl extends ASTWrapperPsiElement implements KatajaIf {

  public KatajaIfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KatajaVisitor visitor) {
    visitor.visitIf(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KatajaVisitor) accept((KatajaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KatajaCalc> getCalcList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KatajaCalc.class);
  }

  @Override
  @NotNull
  public List<KatajaCode> getCodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KatajaCode.class);
  }

  @Override
  @NotNull
  public KatajaEndOfStatement getEndOfStatement() {
    return findNotNullChildByClass(KatajaEndOfStatement.class);
  }

}

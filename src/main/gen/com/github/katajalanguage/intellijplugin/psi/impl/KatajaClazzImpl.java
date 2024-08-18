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

public class KatajaClazzImpl extends ASTWrapperPsiElement implements KatajaClazz {

  public KatajaClazzImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KatajaVisitor visitor) {
    visitor.visitClazz(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KatajaVisitor) accept((KatajaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KatajaGenericType getGenericType() {
    return findNotNullChildByClass(KatajaGenericType.class);
  }

  @Override
  @NotNull
  public List<KatajaInClassStatement> getInClassStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KatajaInClassStatement.class);
  }

  @Override
  @NotNull
  public KatajaModifier getModifier() {
    return findNotNullChildByClass(KatajaModifier.class);
  }

  @Override
  @NotNull
  public List<KatajaWhitespaces> getWhitespacesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KatajaWhitespaces.class);
  }

}

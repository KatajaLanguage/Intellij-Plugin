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

public class KatajaMultiUseImpl extends ASTWrapperPsiElement implements KatajaMultiUse {

  public KatajaMultiUseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KatajaVisitor visitor) {
    visitor.visitMultiUse(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KatajaVisitor) accept((KatajaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KatajaSimpleWhiteSpace getSimpleWhiteSpace() {
    return findNotNullChildByClass(KatajaSimpleWhiteSpace.class);
  }

}

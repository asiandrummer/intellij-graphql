package com.intellij.lang.graphql.psi;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.Nullable;

public interface GraphQLNamedElement extends PsiNameIdentifierOwner {
  @Nullable
  @Override
  GraphQLIdentifier getNameIdentifier();
}

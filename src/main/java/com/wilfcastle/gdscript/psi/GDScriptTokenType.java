package com.wilfcastle.gdscript.psi;

import com.wilfcastle.gdscript.GDScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GDScriptTokenType extends IElementType {
    public GDScriptTokenType(@NotNull @NonNls String debugName) {
        super(debugName, GDScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "GDScriptTokenType." + super.toString();
    }
}

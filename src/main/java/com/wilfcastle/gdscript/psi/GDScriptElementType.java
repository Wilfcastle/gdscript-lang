package com.wilfcastle.gdscript.psi;

import com.wilfcastle.gdscript.GDScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;

public class GDScriptElementType extends IElementType {
    public GDScriptElementType(@NotNull @NonNls String debugName) {
        super(debugName, GDScriptLanguage.INSTANCE);
    }
}

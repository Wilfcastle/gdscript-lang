package com.golmschenk.gdscript;

import com.intellij.lang.Language;

public class GDScriptLanguage extends Language {
    public static final GDScriptLanguage INSTANCE = new GDScriptLanguage();

    private GDScriptLanguage() {
        super("GDScript");
    }
}

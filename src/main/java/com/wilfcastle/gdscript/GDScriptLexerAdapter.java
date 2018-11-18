package com.wilfcastle.gdscript;

import com.intellij.lexer.FlexAdapter;
import java.io.Reader;

public class GDScriptLexerAdapter extends FlexAdapter {
    public GDScriptLexerAdapter() {
        super(new GDScriptLexer((Reader) null));
    }
}

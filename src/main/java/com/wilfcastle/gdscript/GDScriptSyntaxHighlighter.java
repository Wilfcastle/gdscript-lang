package com.wilfcastle.gdscript;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.wilfcastle.gdscript.psi.GDScriptTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GDScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] EMPTY_KEYS =
            new TextAttributesKey[0];

    private static final TextAttributesKey[] BAD_CHAR_KEYS =
            createKeys(HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] COMMENT_KEYS =
            createKeys(DefaultLanguageHighlighterColors.LINE_COMMENT);

    private static final TextAttributesKey[] NUMBER_KEYS =
            createKeys(DefaultLanguageHighlighterColors.NUMBER);

    private static final TextAttributesKey[] KEYWORD_KEYS =
            createKeys(DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey[] OPERATOR_KEYS =
            createKeys(DefaultLanguageHighlighterColors.OPERATION_SIGN);

    private static final TextAttributesKey[] IDENTIFIER_KEYS =
            createKeys(DefaultLanguageHighlighterColors.IDENTIFIER);

    private static final TextAttributesKey[] STRING_KEYS =
            createKeys(DefaultLanguageHighlighterColors.STRING);

    private static final List<IElementType> KEYWORDS = Arrays.asList(GDScriptTypes.VAR);
    private static final List<IElementType> OPERATORS = Arrays.asList(GDScriptTypes.EQUALS);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GDScriptLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(GDScriptTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(GDScriptTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (tokenType.equals(GDScriptTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (OPERATORS.contains(tokenType)) {
            return OPERATOR_KEYS;
        } else if (tokenType.equals(GDScriptTypes.STRING)) {
            return STRING_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

    private static TextAttributesKey[] createKeys(TextAttributesKey key) {
        return new TextAttributesKey[]{createTextAttributesKey(
                key.toString().replace("DEFAULT", "GDScript"), key)};
    }
}


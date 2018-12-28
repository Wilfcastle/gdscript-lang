package com.wilfcastle.gdscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.wilfcastle.gdscript.psi.GDScriptTypes;

%%

%class GDScriptLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

DIGIT=[0-9]
LETTER=[a-zA-Z]

IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

NUMBER = {DIGIT}+
HEX_DIGIT = [A-F0-9]
HEX_NUMBER = "0x"{HEX_DIGIT}+
FLOATING_NUMBER = {DIGIT}*"."{DIGIT}+

COMMENT="#"[^\r\n]*

STRING="\""[^\"]*"\""

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

("var")                                                     { return GDScriptTypes.VAR; }

("const")                                                   { return GDScriptTypes.CONST; }

({IDENTIFIER})                                              { return GDScriptTypes.IDENTIFIER; }

({NUMBER}|{HEX_NUMBER}|{FLOATING_NUMBER})                   { return GDScriptTypes.NUMBER; }

("=")                                                       { return GDScriptTypes.EQUALS; }

({COMMENT})                                                 { return GDScriptTypes.COMMENT; }

({STRING})                                                  { return GDScriptTypes.STRING; }

("[")                                                       { return GDScriptTypes.OPEN_SQ_BRACKET; }

("]")                                                       { return GDScriptTypes.CLOSED_SQ_BRACKET; }

(",")                                                       { return GDScriptTypes.COMMA; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }


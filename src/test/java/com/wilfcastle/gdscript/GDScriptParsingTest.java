package com.wilfcastle.gdscript;

import com.intellij.testFramework.ParsingTestCase;

public class GDScriptParsingTest extends ParsingTestCase {
    public GDScriptParsingTest() {
        super("", "gdscript", new GDScriptParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/resources/parsing";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}

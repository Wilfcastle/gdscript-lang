package com.wilfcastle.gdscript;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GDScriptFileType extends LanguageFileType {
    public static final GDScriptFileType INSTANCE = new GDScriptFileType();

    private GDScriptFileType() {
        super(GDScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GDScript file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "GDScript language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "gd";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GDScriptIcons.FILE;
    }
}
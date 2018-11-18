package com.wilfcastle.gdscript.psi;

import com.wilfcastle.gdscript.GDScriptFileType;
import com.wilfcastle.gdscript.GDScriptLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class GDScriptFile extends PsiFileBase {
    public GDScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GDScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GDScriptFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "GDScript File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}

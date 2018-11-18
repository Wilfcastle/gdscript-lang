package com.golmschenk.gdscript;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class GDScriptFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(GDScriptFileType.INSTANCE);
    }
}

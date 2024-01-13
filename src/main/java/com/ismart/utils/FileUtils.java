package com.ismart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static Path loadFile(String path) throws IOException {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Could not find resource in classpath: " + path);
            }

            Path tempFilePath = Files.createTempFile("temp_file_prefix_", "_temp_file_suffix_");
            Files.copy(inputStream, tempFilePath, StandardCopyOption.REPLACE_EXISTING);

            return tempFilePath;
        }
    }
}

package com.px.unidbg.utils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static File loadFile(String path) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("demo_resources/"+path);
        if (inputStream == null) {
            throw new FileNotFoundException("Could not find resource in classpath: " + path);
        }

        Path tempFilePath = Files.createTempFile("temp_file_prefix_", "_temp_file_suffix_");
        try {
            Files.copy(inputStream, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
        } finally {
            inputStream.close();
        }

        return tempFilePath.toFile();
    }
}

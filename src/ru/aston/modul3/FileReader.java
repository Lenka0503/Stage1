package ru.aston.modul3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class FileReader implements FileProcessor {

    @Override
    public void process(String filename, String data) throws MyFileOperationException {
        Path path = Paths.get(filename);
        try {
            String content = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println("Содержимое файла:");
            System.out.println(content);
        } catch (IOException e) {
            throw new MyFileOperationException("Ошибка чтения из файла: " + filename, e);
        }
    }
}
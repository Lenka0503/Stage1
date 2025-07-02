package ru.aston.modul3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class FileWriter implements FileProcessor {

    @Override
    public void process(String filename, String data) throws MyFileOperationException {
        Path path = Paths.get(filename);
        Path parent = path.getParent();
        try {
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, data, StandardCharsets.UTF_8);
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e) {
            throw new MyFileOperationException("Ошибка записи в файл: " + filename, e);
        }
    }
}
package ru.aston.modul3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Scanner;

class MyFileOperationException extends IOException {
    public MyFileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Main {
    public static void writeToFile(String filename, String data) throws MyFileOperationException {
        Path path = Paths.get(filename);
        Path parent = path.getParent();
        try {
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new MyFileOperationException("Ошибка записи в файл: " + filename, e);
        }
    }

    public static String readFromFile(String filename) throws MyFileOperationException {
        try {
            return Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new MyFileOperationException("Ошибка чтения из файла: " + filename, e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите полный путь к файлу: ");
        String filename = scanner.nextLine().trim();
        System.out.print("Введите текст для записи в файл: ");
        String data = scanner.nextLine();
        try {
            writeToFile(filename, data);
            System.out.println("Данные успешно записаны в файл.");
            String readData = readFromFile(filename);
            System.out.println("Данные успешно прочитаны из файла:");
            System.out.println(readData);
        } catch (MyFileOperationException e) {
            System.out.println("Произошла ошибка при работе с файлом:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

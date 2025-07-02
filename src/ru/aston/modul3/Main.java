package ru.aston.modul3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите полный путь к файлу: ");
        String filename = scanner.nextLine().trim();
        System.out.print("Введите текст для записи в файл: ");
        String data = scanner.nextLine();
        FileProcessor writer = new FileWriter();
        FileProcessor reader = new FileReader();
        try {
            writer.process(filename, data);
            reader.process(filename, null);
        } catch (MyFileOperationException e) {
            System.out.println("Произошла ошибка при работе с файлом:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
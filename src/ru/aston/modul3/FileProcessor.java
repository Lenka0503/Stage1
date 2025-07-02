package ru.aston.modul3;

public interface FileProcessor {
    void process(String filename, String data) throws MyFileOperationException;
}
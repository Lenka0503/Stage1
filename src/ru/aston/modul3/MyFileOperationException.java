package ru.aston.modul3;

import java.io.IOException;

public class MyFileOperationException extends IOException {
    public MyFileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
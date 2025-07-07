package ru.aston.modul4;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumber(1));
        Thread t2 = new Thread(new PrintNumber(2));
        t1.start();
        t2.start();
    }
}

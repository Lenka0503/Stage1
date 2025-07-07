package ru.aston.modul4;

public class LivelockExample {

    public static void main(String[] args) {
        final FriendlyLock lock1 = new FriendlyLock("Замок1");
        final FriendlyLock lock2 = new FriendlyLock("Замок2");

        Thread t1 = new Thread(new Task1(lock1, lock2), "Поток-1");
        Thread t2 = new Thread(new Task2(lock1, lock2), "Поток-2");

        t1.start();
        t2.start();
    }
}


package ru.aston.modul4;

import java.util.concurrent.locks.Lock;

public class Task implements Runnable {
    private final Lock firstLock;
    private final Lock secondLock;
    private final String name;

    public Task(Lock firstLock, Lock secondLock, String name) {
        this.firstLock = firstLock;
        this.secondLock = secondLock;
        this.name = name;
    }

    @Override
    public void run() {
        firstLock.lock();
        System.out.println(name + " захватил первый замок");
        try {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " пытается захватить второй замок");
            secondLock.lock();
            try {
                System.out.println(name + " захватил второй замок");
            } finally {
                secondLock.unlock();
                System.out.println(name + " отпустил второй замок");
            }
        } finally {
            firstLock.unlock();
            System.out.println(name + " отпустил первый замок");
        }
    }
}
package ru.aston.modul4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(new Task(example.lock1, example.lock2, "Task1"));
        Thread t2 = new Thread(new Task(example.lock2, example.lock1, "Task2"));

        t1.start();
        t2.start();

        try {
            t1.join(1000);
            t2.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (t1.isAlive() || t2.isAlive()) {
            t1.interrupt();
            t2.interrupt();
            System.out.println("Обнаружен Livelock или Deadlock - выполняется принудительная остановка и выход из программы");
            System.exit(1);
        } else {
            System.out.println("Потоки завершились успешно");
        }
    }
}
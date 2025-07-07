package ru.aston.modul4;

public class DeadlockExample {

    public final Object lock1 = new Object();
    public final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(new Task1(example.lock1, example.lock2));
        Thread t2 = new Thread(new Task2(example.lock1, example.lock2));

        t1.start();
        t2.start();
    }
}
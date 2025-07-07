package ru.aston.modul4;

class Task2 implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public Task2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock2) {
                System.out.print("2");
                synchronized (lock1) {
                    System.out.println("Поток 2 захватывает lock1 после lock2");
                }
            }
        }
    }
}

package ru.aston.modul4;

class Task1 implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public Task1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock1) {
                System.out.print("1");
                synchronized (lock2) {
                    System.out.println("Поток 1 захватывает lock2 после lock1");
                }
            }
        }
    }
}

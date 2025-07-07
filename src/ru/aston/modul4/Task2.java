package ru.aston.modul4;

class Task2 implements Runnable {
    private final FriendlyLock lock1;
    private final FriendlyLock lock2;

    public Task2(FriendlyLock lock1, FriendlyLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true) {
            if (lock2.tryLock()) {
                if (lock1.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " успешно захватил оба замка, но вежливо освободил");
                    lock1.unlock();
                }
                lock2.unlock();
            }
        }
    }
}

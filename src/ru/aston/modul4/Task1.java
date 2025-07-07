package ru.aston.modul4;

class Task1 implements Runnable {
    private final FriendlyLock lock1;
    private final FriendlyLock lock2;

    public Task1(FriendlyLock lock1, FriendlyLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true) {
            if (lock1.tryLock()) {
                if (lock2.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " успешно захватил оба замка, но вежливо освободил");
                    lock2.unlock();
                }
                lock1.unlock();
            }
        }
    }
}


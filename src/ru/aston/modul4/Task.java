package ru.aston.modul4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
    private final ReentrantLock firstLock;
    private final ReentrantLock secondLock;
    private final String firstLockName;
    private final String secondLockName;

    public Task(ReentrantLock firstLock, String firstLockName,
                ReentrantLock secondLock, String secondLockName) {
        this.firstLock = firstLock;
        this.secondLock = secondLock;
        this.firstLockName = firstLockName;
        this.secondLockName = secondLockName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (firstLock.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " захватил " + firstLockName);
                        boolean secondLockAcquired = false;
                        try {
                            secondLockAcquired = secondLock.tryLock(500, TimeUnit.MILLISECONDS);
                            if (secondLockAcquired) {
                                System.out.println(Thread.currentThread().getName() + " захватил " + secondLockName);
                                System.out.println(Thread.currentThread().getName() + " успешно захватил оба замка");
                            }
                        } finally {
                            if (secondLockAcquired) {
                                secondLock.unlock();
                                System.out.println(Thread.currentThread().getName() + " отпустил " + secondLockName);
                            }
                        }
                    } finally {
                        firstLock.unlock();
                        System.out.println(Thread.currentThread().getName() + " отпустил " + firstLockName);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " прерван");
                break;
            }
        }
    }
}
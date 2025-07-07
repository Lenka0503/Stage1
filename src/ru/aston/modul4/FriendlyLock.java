package ru.aston.modul4;

class FriendlyLock {
    private final String name;
    private boolean isLocked = false;

    public FriendlyLock(String name) {
        this.name = name;
    }

    public synchronized boolean tryLock() {
        if (!isLocked) {
            isLocked = true;
            System.out.println(Thread.currentThread().getName() + " захватил " + name);
            return true;
        }
        return false;
    }

    public synchronized void unlock() {
        isLocked = false;
        System.out.println(Thread.currentThread().getName() + " освободил " + name);
    }
}

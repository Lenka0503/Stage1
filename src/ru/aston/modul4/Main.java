package ru.aston.modul4;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumber(1));
        Thread t2 = new Thread(new PrintNumber(2));
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

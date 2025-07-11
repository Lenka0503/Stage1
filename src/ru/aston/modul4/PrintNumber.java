package ru.aston.modul4;

public class PrintNumber implements Runnable {

    private static final Object lock = new Object();
    private static volatile boolean turn = true;
    private final int numberToPrint;

    public PrintNumber(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    while (turn != (numberToPrint == 1)) {
                        lock.wait();
                    }
                    System.out.println(numberToPrint);
                    turn = !turn;
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
    }
}
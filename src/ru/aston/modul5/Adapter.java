package ru.aston.modul5;

public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public String request() {
        return "Adapter: " + adaptee.specificRequest();
    }
}

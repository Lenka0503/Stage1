package ru.aston.modul5;

public class Proxy implements Subject {
    private RealSubject realSubject;
    private String name;

    public Proxy(String name) {
        this.name = name;
    }

    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("Pre-request processing for " + name);
    }

    private void postRequest() {
        System.out.println("Post-request processing for " + name);
    }
}

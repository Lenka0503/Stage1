package ru.aston.modul5;

public class ConcreteHandler1 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("ConcreteHandler1 handled the request");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

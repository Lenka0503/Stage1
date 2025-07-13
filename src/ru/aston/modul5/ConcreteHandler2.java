package ru.aston.modul5;

class ConcreteHandler2 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("ConcreteHandler2 handled the request");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
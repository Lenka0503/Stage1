package ru.aston.modul5;

class ConcreteHandler3 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("C")) {
            System.out.println("ConcreteHandler3 handled the request");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
package ru.aston.modul5;

abstract public class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public String operation() {
        return component.operation();
    }
}

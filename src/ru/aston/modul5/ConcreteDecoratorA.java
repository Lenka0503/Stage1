package ru.aston.modul5;

public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public String operation() {
        return "DecoratorA(" + super.operation() + ")";
    }
}

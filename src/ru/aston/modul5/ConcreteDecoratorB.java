package ru.aston.modul5;

public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public String operation() {
        return "DecoratorB(" + super.operation() + ")";
    }
}

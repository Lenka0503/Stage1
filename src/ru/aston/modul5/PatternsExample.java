package ru.aston.modul5;

public class PatternsExample {
    public static void main(String[] args) {
        //Strategy
        Context context = new Context(new ConcreteStrategyAdd());
        System.out.println("3+2=" + context.executeStrategy(3, 2));
        context = new Context(new ConcreteStrategySubtract());
        System.out.println("3-2=" + context.executeStrategy(3, 2));
        // Proxy
        Subject subject = new Proxy("Proxy1");
        subject.request();
        //Chain of Responsibility
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        handler1.handleRequest("A");
        handler1.handleRequest("B");
        handler1.handleRequest("C");
        handler1.handleRequest("D");
        //Builder
        Builder builder = new Builder();
        builder.buildPartA();
        builder.buildPartB();
        Product product = builder.getResult();
        product.show();
        //Decorator
        Component component = new ConcreteComponent();
        Component decorated = new ConcreteDecoratorA(new ConcreteDecoratorB(component));
        System.out.println(decorated.operation());
        //Adapter
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        System.out.println(adapter.request());
    }
}

package ru.aston.modul5;

public class Builder {
    private Product product = new Product();

    public void buildPartA() {
        product.add("PartA");
    }

    public void buildPartB() {
        product.add("PartB");
    }

    public Product getResult() {
        return product;
    }
}

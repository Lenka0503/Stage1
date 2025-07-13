package ru.aston.modul5;

public class ConcreteStrategySubtract implements Strategy {
    public int execute(int num1, int num2) {
        return num1 - num2;
    }
}

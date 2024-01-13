package org.example.learnsmashers.Project08;

public class Calculator {
    private String operation;
    private int num1;
    private int num2;

    public Calculator(int num1, int num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public int calculate() {
        return switch (this.operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> num1 + num2;
        };
    }
}

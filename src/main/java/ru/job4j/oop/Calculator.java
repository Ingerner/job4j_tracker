package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    Calculator calculator = new Calculator();
    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return Math.abs(y - x);
    }

    public int drive(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return Calculator.sum(1) +  calculator.multiply(y)
               + Calculator.minus(y) + calculator.drive(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
    }
}

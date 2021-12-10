package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int drive(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return Calculator.sum(y) +  multiply(y)
               + Calculator.minus(y) + drive(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("sum = " + result);
        Calculator cal = new Calculator();
        result = cal.multiply(2);
        System.out.println("multiply = "  + result);
        result = Calculator.minus(10);
        System.out.println("minus = "  + result);
        result = cal.drive(10);
        System.out.println("drive = " + result);
        result = cal.sumAllOperation(2);
        System.out.println("sumAllOperation = " + result);
    }
}

package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
        System.out.println(minus(8));
        Calculator operation = new Calculator();
        System.out.println(operation.divide(25));
        System.out.println(operation.multiply(7));
        System.out.println(operation.sumAllOperation(4));
    }
}
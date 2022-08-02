package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condition) {
        String context = condition ? "колобок съеден" : "колобок сбежал";
        System.out.println(context);
    }
}

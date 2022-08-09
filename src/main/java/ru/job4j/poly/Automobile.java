package ru.job4j.poly;

public class Automobile implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автомобиль едет по дороге");
    }
}

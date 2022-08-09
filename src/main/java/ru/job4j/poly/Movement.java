package ru.job4j.poly;

public class Movement {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle automobile = new Automobile();
        Vehicle[] transports = {airplane, train, automobile};
        for (Vehicle transport: transports) {
            transport.move();
        }
    }
}

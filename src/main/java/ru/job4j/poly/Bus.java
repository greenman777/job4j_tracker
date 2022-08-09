package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Start bus");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Boarded " + number + " passengers");
    }

    @Override
    public double refuel(double fuelQuantity) {
        double fuel95 = 50.20;
        return fuel95 * fuelQuantity;
    }
}

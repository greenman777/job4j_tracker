package ru.job4j.oop;

public class Battery {
    int load;

    public int getLoad() {
        return load;
    }

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += getLoad();
        load = 0;
    }
}

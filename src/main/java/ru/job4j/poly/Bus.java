package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        int kilometers = 1000;
        System.out.println("Расстояние поездки " + kilometers + " км.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров в автобусе " + count);
    }

    @Override
    public void fill(double litre, float price) {
        double fillPrice = litre * price;
        System.out.println("Затраты на топливо: " + fillPrice);
    }
}

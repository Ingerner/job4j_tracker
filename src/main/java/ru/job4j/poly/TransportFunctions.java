package ru.job4j.poly;

public class TransportFunctions {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus1();
        Vehicle[] vihicle = new Vehicle[] {airplane, train, bus};
        for (Vehicle index : vihicle) {
            index.move();
        }
    }
}

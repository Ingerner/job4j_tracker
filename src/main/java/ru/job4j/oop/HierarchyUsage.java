package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        /* Создаем объект класса Car. */
        Car car = new Car();
        /*Делаем приведение к типу родителя Transport. */
        Transport tp = car;
        /* Делаем приведение к типу родителя object.*/
        Object obj = car;
        /* Приведение типа  при создании объекта. */
        Object ocar = new Car();
        /* Приведение типа  за счет понижения по иерархии.*/
        Car carFromObject = (Car) ocar;

        /* Ощибка в приведении типа. */
     /*   Object bicycle = new Bicycle();
        Car cb = (Car) bicycle;
     */
        System.out.println(new Car());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}

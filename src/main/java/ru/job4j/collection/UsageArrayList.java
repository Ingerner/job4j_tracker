package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String value : names) {
            System.out.println(value);
        }
    }
}

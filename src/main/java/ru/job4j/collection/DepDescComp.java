package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] stro1 = o1.split("/");
        String[] stro2 = o2.split("/");
        int rsl = stro2[0].compareTo(stro1[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}

package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rez = 1;
        String[] stro1 = o1.split("/");
        String[] stro2 = o2.split("/");
        for (int i = 0; i < Math.min(stro1.length, stro2.length); i++) {
            if (i == 0) {
                rez = stro2[i].compareTo(stro1[i]);
            } else {
                rez = stro1[i].compareTo(stro2[i]);
            }
            if (rez != 0) {
                break;
            }
        }
        if (rez == 0) {
            rez = Integer.compare(stro2.length,  stro1.length);
        }
        return rez;
    }

}

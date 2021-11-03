package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rez = 1;
        String[] first = o1.split("/");
        String[] second = o2.split("/");
       for (int i = 0; i < Math.min(first.length, second.length); i++) {
           rez = second[i].compareTo(first[0]);
           if(rez != 0) {
               break;
           }
           return rez
        }
       for ()

        return 0;
    }
}

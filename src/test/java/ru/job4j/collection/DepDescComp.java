package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] strO1 = o1.split("/");
        String[] strO2 = o2.split("/");
        int rez=0;
        for(int i = 0; i < Math.min(strO1.length, strO2.length); i++) {
            rez = strO2[i].compareTo(strO1[i]);
            if(rez==0) {
                continue;
            } else {
                 rez = strO1[i].compareTo(strO2[i]);
                 break;
            }
        }

        return rez;
    }
}

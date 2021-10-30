package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Integer first = Integer.parseInt(o1.split(". ")[0]);
        Integer second = Integer.parseInt(o2.split(". ")[0]);

        return first.compareTo(second);
    }
}

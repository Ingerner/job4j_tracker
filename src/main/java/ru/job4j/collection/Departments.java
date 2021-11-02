package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                 tmp.add (start  + el);
                 start = start + el + "/";
            }

        }
        return new ArrayList<>(tmp);
    }

    public static void main(String[] args) {

    }
}

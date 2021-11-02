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
                 start = el +"/";
            }

        }
        System.out.println( new ArrayList<>(tmp));
        return null; //new ArrayList<>(tmp);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("k1/sk1/ssk2", "k2/sk2/ssk2");
        List<String> result = Departments.fillGaps(input);
    }

}

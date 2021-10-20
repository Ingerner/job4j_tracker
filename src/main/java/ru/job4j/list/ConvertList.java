package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] i : list) {
            for (int index : i) {
                rsl.add(index);
            }
        }
        return rsl;
    }
}

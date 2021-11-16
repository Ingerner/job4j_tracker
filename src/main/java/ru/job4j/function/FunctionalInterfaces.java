package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        int j =1;
        for (String index : list) {
            biCon.accept(j++, index);
        }

        /*
            Замените вставку элементов в карту на использование BiConsumer, он уже объявлен, требуется его реализовать.
         */
//        map.put(1, "one");
//        map.put(2, "two");
//        map.put(3, "three");
//        map.put(4, "four");
//        map.put(5, "five");
//        map.put(6, "six");
//        map.put(7, "seven");

        BiPredicate<Integer, String> biPred = (k, v) -> k % 2 == 0 || v.length() == 4;
        for (Integer i : map.keySet()) {
           biPred.test(i, map.get(i));
            /*
                Замените проверку в if() на использование BiPredicate, он объявлен выше, требуется его реализовать.
             */
//            if (i % 2 == 0 || map.get(i).length() == 4) {
//                System.out.println("key: " + i + " value: " + map.get(i));
//            }
        }
        /*
            Заменить создание ArrayList из значений Map на Supplier, объявлен ниже, требуется его реализовать.
         */
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func =
        for (String s : strings) {
            System.out.println(s);
            /*
                Заменить вывод строк на применение Consumer
                Заменить преобразование строк к строкам в верхнем регистре с помощью Function
                Необходимое объявлено выше, требуется их реализовать.
            */
            //System.out.println(s.toUpperCase());
        }
    }
}

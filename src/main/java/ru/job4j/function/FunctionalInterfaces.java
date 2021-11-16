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
        int j = 1;
        for (String index : list) {
            biCon.accept(j++, index);
        }
        BiPredicate<Integer, String> biPred = (k, v) -> k % 2 == 0 || v.length() == 4;
        for (Integer i : map.keySet()) {
           if (biPred.test(i, map.get(i))) {
               System.out.println("key: " + i + " value: " + map.get(i));
           }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();
        Function<String, String> functionUpperCase = (s) -> s.toUpperCase();
        Consumer<String> consumer = (el) -> System.out.println(functionUpperCase.apply(el));
        for (String s : strings) {
            consumer.accept(s);
        }
    }
}

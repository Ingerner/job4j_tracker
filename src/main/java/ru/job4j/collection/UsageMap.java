package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("korokity.o@mail.ru", "Korotkiy O.Y.");
        map.put("1swk3@andex.ru", "Tarasov I.K.");
        for(String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

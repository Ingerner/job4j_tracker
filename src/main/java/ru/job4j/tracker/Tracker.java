package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }
// разобраться с данным методом тест проходит но нечего непонятно
    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[items.length];
        int i = 0;
        for (int index = 0; index < size; index++) {
            if(items[index]!=null) {
                namesWithoutNull[i] = items[index];
                i++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, i);
        return namesWithoutNull;
    }
/*
    public Item[] findByName(String key) {

    }
*/
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
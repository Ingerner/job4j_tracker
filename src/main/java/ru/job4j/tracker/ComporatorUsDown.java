package ru.job4j.tracker;

import java.util.Comparator;

public class ComporatorUsDown implements Comparator<Item> {

    @Override
    public int compare(Item dataFirst, Item dataSecond) {
        return Integer.compare(dataSecond.getId(), dataFirst.getId());
    }
}


package ru.job4j.tracker;

import java.util.Comparator;

public class ComporatorUsDown implements Comparator<Item> {

    @Override
    public int compare(Item dataFirst, Item dataSecond) {
        return dataSecond.getId().compareTo(dataFirst.getId());
    }
}


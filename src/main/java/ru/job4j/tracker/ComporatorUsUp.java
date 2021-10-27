package ru.job4j.tracker;

import java.util.Comparator;

public class ComporatorUsUp implements Comparator<Item>  {

    @Override
    public int compare(Item dataFirst, Item dataSecond) {
        return dataFirst.getId().compareTo(dataSecond.getId());
    }
}


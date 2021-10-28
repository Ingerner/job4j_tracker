package ru.job4j.tracker;

import java.util.Comparator;

public class ComporatorUsUp implements Comparator<Item>  {

    @Override
    public int compare(Item dataFirst, Item dataSecond) {

        return Integer.compare(dataFirst.getId(), dataSecond.getId());
    }
}


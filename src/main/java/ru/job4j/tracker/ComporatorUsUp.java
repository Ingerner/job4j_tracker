package ru.job4j.tracker;

import java.util.Comparator;

public class ComporatorUsUp implements Comparator<Item>  {

    @Override
    public int compare(Item dataFirst, Item dataSecond) {
        if ((dataFirst.getId() - dataSecond.getId()) > 0) {
            return 1;
        } else if ((dataFirst.getId() - dataSecond.getId()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}


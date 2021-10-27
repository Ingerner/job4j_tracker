package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortUp() {

        List<Item> list = Arrays.asList(new Item(5, "five"),
                new Item(3, "three"), new Item(1, "one"));
        List<Item> expected = Arrays.asList(new Item(1, "one"),  new Item(3, "three"),
                                            new Item(5, "five"));
        Collections.sort(list, new ComporatorUsUp());
        Assert.assertEquals(list, expected);

    }

    @Test
    public void sortDown() {

        List<Item> list = Arrays.asList(new Item(5, "five"),
                new Item(3, "three"), new Item(1, "one"));
        List<Item> expected = Arrays.asList(new Item(5, "five"),  new Item(3, "three"),
                                    new Item(1, "one"));
        Collections.sort(list, new ComporatorUsDown());
        Assert.assertEquals(list, expected);
    }

}

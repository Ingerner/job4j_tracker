package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListOfNumbersTest {

    @Test
    public void convert() {
        Integer[][] array = new Integer[][] {{1, 2}, {3, 4}};
        ListOfNumbers matrix = new ListOfNumbers();
        List<Integer> rsl = matrix.convert(array);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }

}
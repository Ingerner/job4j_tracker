package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(4, 0.001));
    }

    @Test
    public void distance3d1() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 3, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(5, 0.001));
    }
}
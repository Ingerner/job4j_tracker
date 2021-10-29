package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenCompatorByNameAndProrityDown() {
        Comparator<Job> cmpNamePriority = new SortNameDown().thenComparing(new SortPriorityDown());
        int rsl = cmpNamePriority.compare(
                 new Job("Impl task", 0),
                 new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityUp() {
        Comparator<Job> cmpNamePriority = new SortNameUp().thenComparing(new SortPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameUpAndProrityDown() {
        Comparator<Job> cmpNamePriority = new SortNameUp().thenComparing(new SortPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDownAndProrityUp() {
        Comparator<Job> cmpNamePriority = new SortNameDown().thenComparing(new SortPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityUpAndNameUp() {
        Comparator<Job> cmpNamePriority = new SortPriorityUp().thenComparing(new SortNameUp());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameUp() {
        Comparator<Job> cmpName = new SortNameUp();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDown() {
        Comparator<Job> cmpName = new SortNameDown();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorotyUp() {
        Comparator<Job> cmpPrioroty = new SortPriorityUp();
        int rsl = cmpPrioroty.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorotyDown() {
        Comparator<Job> cmpPrioroty = new SortPriorityDown();
        int rsl = cmpPrioroty.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}
package ru.job4j.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = st -> st.getScope() >= 70 && st.getScope() <= 100;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = st -> st.getScope() >= 50 && st.getScope() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = st -> st.getScope() > 0 && st.getScope() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenConvertListWithDuplicatesThenReceiveMapWithFirstElements() {
        Student st1 = new Student(10, "Surname1");
        Student st2 = new Student(30, "Surname3");
        Student st3 = new Student(40, "Surname4");
        Student st4 = new Student(60, "Surname6");
        Student st5 = new Student(90, "Surname9");
        Student st6 = new Student(20, "Surname1");
         List<Student> students = List.of(st1, st2, st3, st4, st5, st6);
        School sc = new School();
        Map<String, Student> rsl = sc.convert(students);
        Map<String, Student> expeced = Map.of(
                "Surname1", st1,
                "Surname3", st2,
                "Surname4", st3,
                "Surname6", st4,
                "Surname9", st5
        );
        assertThat(rsl, is(expeced));
    }
}
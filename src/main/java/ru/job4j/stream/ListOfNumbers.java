package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfNumbers {
    public List<Integer> convert(Integer[][] matrix){
        return Stream.of(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
    }
}

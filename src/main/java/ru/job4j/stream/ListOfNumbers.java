package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfNumbers {
    public List<Integer> convert(int[][] matrix){
        Stream.of(matrix);
        return Arrays.stream(matrix);

    }
}

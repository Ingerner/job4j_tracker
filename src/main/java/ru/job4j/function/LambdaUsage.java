package ru.job4j.function;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare -" + left + ":" + right);
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Integer.compare -" + left.length() + ":"  + right.length());
           return Integer.compare(right.length(), left.length());
        };
    }
}

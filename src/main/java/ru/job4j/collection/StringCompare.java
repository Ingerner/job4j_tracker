package ru.job4j.collection;

import java.lang.module.FindException;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        if (Integer.compare(left.length(), right.length()) == 0) {
            for (int i = 0; i < left.length(); i++) {
                 int rez = Character.compare(left.charAt(i), right.charAt(i));
                if (rez != 0) {
                    return rez;
                }
            }
        } else if (left.length() < right.length()) {
            for (int i = 0; i < left.length(); i++) {
                int rez = Character.compare(left.charAt(i), right.charAt(i));
                if (rez != 0) {
                    return rez;
                }
            }
        } else {
            for (int i = 0; i < right.length(); i++) {
                 int rez = Character.compare(left.charAt(i), right.charAt(i));
                if (rez != 0) {
                   return rez;
                }
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}

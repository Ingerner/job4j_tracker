package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String i : value) {
            if (i == key) {
               return  1;
            }
        }
        throw new ElementNotFoundException("Не найден искомый элемент.");
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */

    }

    public static void main(String[] args) {

        try {
            String[] arrya = new String[]{"1", "2", "3", "4", "5"};
            indexOf(arrya, "8");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

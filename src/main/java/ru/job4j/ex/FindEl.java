package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
              rsl = i;
              return  rsl;
            }
        }
        throw new ElementNotFoundException("Не найден искомый элемент.");
    }

    public static void main(String[] args) {

        try {
            String[] arrya = new String[]{"1", "2", "3", "4", "5"};
            indexOf(arrya, "7");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

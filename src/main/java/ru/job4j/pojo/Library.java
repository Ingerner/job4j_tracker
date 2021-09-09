package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {

        Book cleanCode = new Book("Clean Code", 3500);
        Book javaPhilosophy = new Book("Philosophy Java", 3000);
        Book database = new Book("Oracle Database", 1500);
        Book htmlAndCss = new Book("HTML и CSS", 1300);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = javaPhilosophy;
        books[2] = database;
        books[3] = htmlAndCss;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " " + bk.getCount());
        }
        System.out.println();
        books[0] = htmlAndCss;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " " + bk.getCount());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean Code")) {
                System.out.println(bk.getName() + " " + bk.getCount());
            }
        }
    }
}

package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        //item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdDateTimeFormat =  item.getCreated().format(formatter);
        System.out.println(createdDateTimeFormat);
       //-----------------toString-------------------------//
        Item data = new Item();
        System.out.println(data.toString());
    }
}

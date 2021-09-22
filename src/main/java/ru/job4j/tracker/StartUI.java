package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
//import java.util.Scanner;

public class StartUI {
    
    public static void createItem(Input input, Tracker tracker) { // Добавление заявки
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public  static void displayAllItem(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка заменена успешно.");
        } else {
            System.out.println("Oшибка замены заявки.");
        }
    }

    public static void deteleItem(Input input, Tracker tracker) {
        System.out.println("Delete item");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void receivingItemId(Input input, Tracker tracker) {
        System.out.println("=== Find item bu id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id " + id + " не найдена");
        }
    }

    public static void receivingItemName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем " + name + " не найдены");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
           /* if (select == 0) {     // Добавление заявки
                StartUI.createItem(input, tracker);
            }  else
            */
            if (select == 1) {      // Вывод всех заявок

                StartUI.displayAllItem(tracker);
            } else if (select == 2) {    // Редактирование заявки
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {   //Удаление заявки
                StartUI.deteleItem(input, tracker);
            } else if (select == 4) {     //вывод заявки по id
               StartUI.receivingItemId(input, tracker);
            } else if (select == 5) {
                StartUI.receivingItemName(input, tracker);
            } else if (select == 6) {  //Выход из меню заявок
                run = false;
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + "." + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        //UserAction actions = new CreateAction[];
        UserAction[] actions = {new CreateAction()};
        new StartUI().init(input, tracker, actions);
    }
}

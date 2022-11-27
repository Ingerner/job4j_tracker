package ru.job4j.tracker;

public class AddManyItem implements UserAction {

    private final Output out;

    public AddManyItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ===");
        int numberOfPlane = input.askInt("Введите количество заявок: ");
        for (int i = 0; i <= numberOfPlane; i++) {
            Item item = new Item(Integer.toString(i));
            tracker.add(item);
        }
        out.println("Добавленно заявок: " + numberOfPlane);
        return true;
    }
}

package ru.job4j.tracker;

public class SingleTracker {
    private static SingleTracker tracker = null;

    private SingleTracker() {

    }

    public static SingleTracker getTracker() {
        if (tracker == null) {
            tracker = new SingleTracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return  null;
    }

    public Item[] findByName(String key) {
        return null;
    }

    public boolean replace(int id, Item item) {
        return true;
    }

    public boolean delete(int id) {

        return true;
    }

}




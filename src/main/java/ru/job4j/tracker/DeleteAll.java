package ru.job4j.tracker;

public class DeleteAll implements UserAction {

    private final Output out;

    public DeleteAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete All";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (Item i : tracker.findAll()) {
            tracker.delete(i.getId());
        }
        out.println("Заявки удалены");
        return true;
    }
}

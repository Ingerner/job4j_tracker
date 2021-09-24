package ru.job4j.tracker;

public class ReceivingActionId implements UserAction {
    private  final   Output out;

    public ReceivingActionId(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item bu id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item bu id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id " + id + " не найдена");
        }
        return true;
    }
}

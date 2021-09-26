package ru.job4j.tracker;

public class ReceivingActionId implements UserAction {
    private  final   Output out;

    public ReceivingActionId(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return " Find item bu id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item bu id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id " + id + " не найдена");
        }
        return true;
    }
}

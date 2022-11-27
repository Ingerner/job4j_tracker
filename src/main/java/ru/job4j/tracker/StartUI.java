package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + "." + actions.get(i).name());
        }
    }

    public static void main(String[] args) throws Exception {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
/*        try (SqlTracker sqlTracker = new SqlTracker()) {
            sqlTracker.init();
            List<UserAction> actions = Arrays.asList(
                    new CreateAction(output), new DisplayAllAction(output),
                    new ReplaceItem(output), new DeteleAction(output),
                    new ReceivingActionId(output), new ReceivingActionName(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, sqlTracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }

 */
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                    new CreateAction(output), new DisplayAllAction(output),
                    new ReplaceItem(output), new DeteleAction(output),
                    new ReceivingActionId(output), new ReceivingActionName(output),
                    new AddManyItem(output), new DeleteAll(output),  new Exit(output)
            );
        new StartUI(output).init(input, memTracker, actions);
    }
}

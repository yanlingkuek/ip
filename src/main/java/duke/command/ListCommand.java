package duke.command;

import duke.Storage;
import duke.ui.Ui;
import duke.task.TaskList;

/**
 * Represents a command to list all current tasks.
 */
public class ListCommand extends Command {

    /**
     * Creates a new instance of <code>ListCommand</code>.
     */
    public ListCommand() {
        this.type = "list";
        this.description = "";
        this.isExit = false;
    }

    /**
     * Prints tasks in task list.
     *
     * @param tasks Task list.
     * @param ui User interface.
     * @param storage Storage.
     * @return Output string.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return tasks.printTaskList();
    }

    @Override
    public boolean isExit() {
        return this.isExit;
    }
}

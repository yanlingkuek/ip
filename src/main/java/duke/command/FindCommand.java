package duke.command;

import duke.Storage;
import duke.ui.Ui;
import duke.task.TaskList;

/**
 * Represents a command to find tasks by searching a keyword.
 */
public class FindCommand extends Command {

    /**
     * Creates a new instance of <code>FindCommand</code>.
     *
     * @param description Keyword to be matched to current tasks.
     */
    public FindCommand(String description) {
        this.type = "find";
        this.description = description;
        this.isExit = false;
    }

    /**
     * Prints tasks with the matching keyword.
     *
     * @param tasks Task list.
     * @param ui User interface.
     * @param storage Storage.
     * @return Output string.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return tasks.printTasksWith(description);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

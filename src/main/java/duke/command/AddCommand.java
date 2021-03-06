package duke.command;

import java.io.IOException;

import duke.Storage;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.TaskType;

/**
 * Represents a command to add a task.
 */
public class AddCommand extends Command {

    /**
     * Creates a new instance of <code>AddCommand</code>.
     *
     * @param type Type of add command (todo, deadline, event).
     * @param description Description of task.
     */
    public AddCommand(String type, String description) {
        this.type = type;
        this.description = description;
        this.isExit = false;
    }

    /**
     * Adds todo, deadline or event tasks.
     *
     * @param tasks Task list.
     * @param ui User interface.
     * @param storage Storage.
     * @return Output string.
     * @throws IOException If there are any input or output issues.
     * @throws DukeException If user input is not in the correct format or is invalid.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws IOException, DukeException {
        return tasks.addTask(TaskType.valueOf(this.type.toUpperCase()), description, false, false, storage);
    }

    @Override
    public boolean isExit() {
        return this.isExit;
    }
}

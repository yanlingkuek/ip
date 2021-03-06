package duke.command;

import java.io.IOException;

import duke.Storage;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.task.TaskList;

/**
 * Represents a command called by the user.
 */
public abstract class Command {

    protected String type;
    protected String description;
    protected boolean isExit;

    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws IOException, DukeException;

    public abstract boolean isExit();
}

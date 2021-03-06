package duke.command;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import duke.Storage;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.task.TaskList;

/**
 * Represents a command to list all tasks that corresponds to a given date.
 */
public class TaskdateCommand extends Command {

    /**
     * Creates a new instance of <code>TaskdateCommand</code>.
     *
     * @param description Date to be matched to current tasks.
     */
    public TaskdateCommand(String description) {
        this.type = "taskdate";
        this.description = description;
        this.isExit = false;
    }

    /**
     * Filters out tasks that match given date.
     *
     * @param tasks Task list.
     * @param ui User interface.
     * @param storage Storage.
     * @return Output string.
     * @throws DukeException If description is in the wrong format or is invalid.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(description);

        if (!matcher.find()) {
            throw new DukeException("Your task date is given in the wrong format! "
                    + "Please make sure it is in the following format: YYYY-MM-DD");
        }

        try {
            LocalDate date = LocalDate.parse(this.description);
            return tasks.printTasksOn(date);
        } catch (DateTimeParseException e) {
            return ui.showError("This date is invalid!");
        }
    }

    @Override
    public boolean isExit() {
        return this.isExit;
    }
}

package duke;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import duke.command.Command;
import duke.exception.DukeException;
import duke.ui.DialogBox;
import duke.ui.Ui;
import duke.task.TaskList;

/**
 * Represents a task manager that allows users to add, delete and mark tasks as done.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Creates a new instance of <code>Duke</code> with given filePath.
     *
     * @param filePath
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException | IOException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
            ui.showLine();
        }
    }

    /**
     * Runs Duke and executes commands, until Duke is terminated.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException | IOException | DateTimeParseException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }


    public String getResponse(String input) {
        //boolean isExit = false;
        //while (!isExit) {
            try {
                Command c = Parser.parse(input);
                return c.execute(tasks, ui, storage);
                //isExit = c.isExit();
            } catch (DukeException | IOException | DateTimeParseException e) {
                return e.getMessage();
            }
        //}
        //return "Duke heard: " + input;
    }

    /**
     * Runs Duke for the given file path
     *
     * @param args
     */
    /*
    public static void main(String[] args) {
        String filePath = "data/duke.txt";
        new Duke(filePath).run();
    }
     */
}

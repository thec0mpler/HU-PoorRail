package commands;

import cli_interpreter.CommandParser;
import model.RichRail;

public abstract class Command {
    protected static Client client = Client.getInstance();
    protected RichRail richRail = RichRail.getInstance();

    protected cli_interpreter.Command interpreterCommand;
    protected String name;

    Command(String name) {
        this.name = name;
        this.interpreterCommand = this.getInterpreterCommand();
    }

    public String getName() {
        return name;
    }

    public abstract cli_interpreter.Command getInterpreterCommand();

    public abstract String execute(CommandParser parser) throws Exception;
}

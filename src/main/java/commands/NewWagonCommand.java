package commands;

import cli_interpreter.Argument;
import cli_interpreter.CommandParser;
import model.vehicle.Wagon;

public class NewWagonCommand extends Command {
    public NewWagonCommand() {
        super("new wagon");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("new wagon");
        command.setRequiredValue(true);
        command.addArgument(new Argument("numseats"));

        return command;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        Client client = Client.getInstance();
        String name = parser.getRequiredArgument();

        Wagon wagon = new Wagon(name);

        if (parser.has("numseats")) {
            wagon.setSeats(Integer.valueOf(parser.valueOf("numseats")));
        }

        return client.addWagon(wagon);
    }
}

package commands;

import cli_interpreter.CommandParser;
import model.vehicle.Wagon;

public class DeleteWagonCommand extends Command {
    public DeleteWagonCommand() {
        super("delete wagon");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("delete wagon");
        command.setRequiredValue(true);

        return command;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        Client client = Client.getInstance();
        String wagonName = parser.getRequiredArgument();
        Wagon wagon = client.getWagon(wagonName);

        if (null != wagon) {
            client.removeWagon(wagon);

            return "Wagon '" + wagonName + "' deleted";
        }

        return  "Wagon '" + wagonName + "' does not exist";
    }
}

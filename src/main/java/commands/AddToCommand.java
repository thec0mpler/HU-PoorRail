package commands;

import cli_interpreter.Argument;
import cli_interpreter.CommandParser;
import model.Train;
import model.vehicle.Wagon;

public class AddToCommand extends Command {
    public AddToCommand() {
        super("add");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("add");
        command.setRequiredValue(true);
        command.addArgument(new Argument("to", true));

        return command;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        Client client = Client.getInstance();
        String wagonString = parser.getRequiredArgument();
        String trainString = parser.valueOf("to");

        Wagon wagon = client.getWagon(wagonString);
        Train train = richRail.getTrain(trainString);

        if (null == wagon)
            return "ERROR: wagon does not exist";
        if (null == train)
            return "ERROR: train does not exist";

        train.addVehicle(wagon);

        return "Wagon '" + wagon.getName() + "' added to '" + train.getName() + "'";
    }
}

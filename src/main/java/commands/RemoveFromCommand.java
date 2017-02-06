package commands;

import cli_interpreter.Argument;
import cli_interpreter.CommandParser;
import model.Train;
import model.vehicle.Wagon;

public class RemoveFromCommand extends Command {
    public RemoveFromCommand() {
        super("remove");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("remove");
        command.setRequiredValue(true);
        command.addArgument(new Argument("from", true));

        return command;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        Client client = Client.getInstance();
        String wagonString = parser.getRequiredArgument();
        String trainString = parser.valueOf("from");

        Wagon wagon = client.getWagon(wagonString);
        Train train = richRail.getTrain(trainString);

        if (null == wagon)
            return "ERROR: wagon does not exist";
        if (null == train)
            return "ERROR: train does not exist";

        train.removeVehicle(wagon);

        return "Wagon '" + wagon.getName() + "' removed from '" + train.getName() + "'";
    }
}

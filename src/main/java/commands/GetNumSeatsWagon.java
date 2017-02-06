package commands;

import cli_interpreter.CommandParser;
import model.vehicle.Wagon;

public class GetNumSeatsWagon extends Command {
    public GetNumSeatsWagon() {
        super("getnumseats wagon");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("getnumseats wagon");
        command.setRequiredValue(true);

        return command;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String wagonName = parser.getRequiredArgument();
        Wagon wagon = richRail.getWagon(wagonName);

        if (null != wagon) {
            return "Wagon '" + wagon.getName() + "' has " + wagon.getSeats() + " seats";
        }

        return "Wagon '" + wagonName + "' does not exist";
    }
}

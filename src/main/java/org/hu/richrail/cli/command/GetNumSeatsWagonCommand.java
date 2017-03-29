package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;
import org.hu.richrail.model_old.vehicle.Wagon;

public class GetNumSeatsWagonCommand extends Command {
    public GetNumSeatsWagonCommand() {
        super("getnumseats wagon");
    }

    @Override
    public org.hu.command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true);
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

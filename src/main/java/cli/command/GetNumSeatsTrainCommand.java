package cli.command;

import command_line_parser.CommandParser;
import model.Train;

public class GetNumSeatsTrainCommand extends Command {
    public GetNumSeatsTrainCommand() {
        super("getnumseats train");
    }

    @Override
    public command_line_parser.Command getParserCommand() {
        return parserFacade
                .newCommand()
                .setRequiredValue(true);
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String trainName = parser.getRequiredArgument();
        Train train = richRail.getTrain(trainName);

        if (null != train) {
            return "Train '" + train.getName() + "' has " + train.getSeats() + " seats";
        }

        return "Train '" + trainName + "' does not exist";
    }
}

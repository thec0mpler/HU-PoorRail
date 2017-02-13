package cli.command;

import command_line_parser.CommandParser;
import model.Train;

public class DeleteTrainCommand extends Command {
    public DeleteTrainCommand() {
        super("delete train");
    }

    @Override
    public command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true);
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String trainName = parser.getRequiredArgument();
        Train train = richRail.getTrain(trainName);

        if (null != train) {
            richRail.removeTrain(train);

            return "Train '" + trainName + "' deleted";
        }

        return  "Train '" + trainName + "' does not exist";
    }
}

package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;
import org.hu.richrail.model.Train;
import org.hu.richrail.model.Wagon;

public class RemoveFromCommand extends Command {
    public RemoveFromCommand() {
        super("remove");
    }

    @Override
    public org.hu.command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true)
                .addArgument(parserFacade.newArgument("from", true));
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        // remove w1 from t1
        String wagonName = parser.getRequiredArgument();
        String trainName = parser.valueOf("from");

        Wagon wagon = trainManager.getWagonByName(wagonName);
        Train train = trainManager.getTrainByName(trainName);

        if (wagon != null && train != null && wagon.getTrain().equals(train)) {
            wagon.removeTrain();

            return "Wagon '" + wagon.getName() + "' is removed from train '" + train.getName() + "'";
        }

        return "Something went wrong!";
    }
}

package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;
import org.hu.richrail.model.Train;
import org.hu.richrail.model.Wagon;

public class AddToCommand extends Command {
    public AddToCommand() {
        super("add");
    }

    @Override
    public org.hu.command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true)
                .addArgument(parserFacade.newArgument("to", true));
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String wagonString = parser.getRequiredArgument();
        String trainString = parser.valueOf("to");

        Train train = trainManager.getTrainByName(trainString);
        Wagon wagon = trainManager.getWagonByName(wagonString);

        if (train != null && wagon != null) {
            wagon.setTrain(train);

            return "Added wagon '" + wagon.getName() + "' to train '" + train.getName() + "'";
        }

        return "Train or wagon does not exist!";
    }
}

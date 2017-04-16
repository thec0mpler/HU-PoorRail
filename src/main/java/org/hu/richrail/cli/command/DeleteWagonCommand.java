package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;
import org.hu.richrail.model.Wagon;

public class DeleteWagonCommand extends Command {
    public DeleteWagonCommand() {
        super("delete wagon");
    }

    @Override
    public org.hu.command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true);
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String wagonName = parser.getRequiredArgument();
        Wagon wagon = trainManager.getWagonByName(wagonName);

        if (wagon != null) {
            trainManager.removeWagon(wagon);

            return "Wagon '" + wagonName + "' deleted";
        }

        return  "Wagon '" + wagonName + "' does not exist";
    }
}

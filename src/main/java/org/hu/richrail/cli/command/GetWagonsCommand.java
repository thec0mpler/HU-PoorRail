package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;
import org.hu.richrail.model.Wagon;

public class GetWagonsCommand extends Command {
    public GetWagonsCommand() {
        super("get wagons");
    }

    @Override
    public org.hu.command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand();
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String output = "Wagons:\n";

        for (Wagon wagon : trainManager.getWagons()) {
            output += wagon.getName() + "\n";
        }

        return output;
    }
}

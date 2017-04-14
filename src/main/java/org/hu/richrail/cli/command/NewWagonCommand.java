package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;
import org.hu.richrail.model.Wagon;

public class NewWagonCommand extends Command {
    public NewWagonCommand() {
        super("new wagon");
    }

    @Override
    public org.hu.command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true)
                .addArgument(parserFacade.newArgument("numseats"));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String name = parser.getRequiredArgument();

        Wagon wagon = new Wagon(name);


        if (trainManager.addWagon(wagon)){
            return "Add wagon added, name '" + wagon.getName() + "'";
        } else {
            return "Wagon already exists: '" + wagon.getName() + "'";
        }
    }

}

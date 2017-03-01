package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;

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
        return null;
    }
}
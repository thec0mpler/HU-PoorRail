package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;

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
        return null;
    }
}

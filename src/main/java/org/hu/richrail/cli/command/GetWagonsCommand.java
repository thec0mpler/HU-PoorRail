package org.hu.richrail.cli.command;

import org.hu.command_line_parser.CommandParser;

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
        return null;
    }
}

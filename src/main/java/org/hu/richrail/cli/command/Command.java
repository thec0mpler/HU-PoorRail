package org.hu.richrail.cli.command;

import org.hu.richrail.cli.Client;
import org.hu.command_line_parser.CommandParser;
import org.hu.command_line_parser.ParserFacade;
import org.hu.richrail.model_old.RichRail;

public abstract class Command {
    RichRail richRail = RichRail.getInstance();
    ParserFacade parserFacade = new ParserFacade();

    static Client client = Client.getInstance();
    String name;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // TODO: make 'org.hu.command_line_parser.Command' changeable?
    public abstract org.hu.command_line_parser.Command getParserCommand();

    public abstract String execute(CommandParser parser) throws Exception;
}

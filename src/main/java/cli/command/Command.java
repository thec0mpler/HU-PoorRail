package cli.command;

import cli.Client;
import command_line_parser.CommandParser;
import command_line_parser.ParserFacade;
import model.RichRail;

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

    // TODO: make 'command_line_parser.Command' changeable?
    public abstract command_line_parser.Command getParserCommand();

    public abstract String execute(CommandParser parser) throws Exception;
}

package cli.command;

import command_line_parser.CommandParser;

public class DeleteWagonCommand extends Command {
    public DeleteWagonCommand() {
        super("delete wagon");
    }

    @Override
    public command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true);
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        return null;
    }
}

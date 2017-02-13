package cli.command;

import command_line_parser.CommandParser;

public class RemoveFromCommand extends Command {
    public RemoveFromCommand() {
        super("remove");
    }

    @Override
    public command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true)
                .addArgument(parserFacade.newArgument("from", true));
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        return null;
    }
}

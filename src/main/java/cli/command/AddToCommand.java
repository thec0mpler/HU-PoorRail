package cli.command;

import command_line_parser.CommandParser;

public class AddToCommand extends Command {
    public AddToCommand() {
        super("add");
    }

    @Override
    public command_line_parser.Command getParserCommand() {
       return parserFacade.newCommand()
               .setRequiredValue(true)
               .addArgument(parserFacade.newArgument("to", true));
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        System.out.println(client);

        return null;
    }
}

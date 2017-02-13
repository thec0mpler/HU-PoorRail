package command_line_parser;

/**
 * A facade for the hole package.
 */
public class ParserFacade {
    public Argument newArgument(String name) {
        return new Argument(name);
    }

    public Argument newArgument(String name, boolean required) {
        return new Argument(name, required);
    }

    public Command newCommand() {
        return new Command();
    }

    public CommandParser newParser(Command command, String context) throws Exception {
        return new CommandParser(command, context);
    }
}

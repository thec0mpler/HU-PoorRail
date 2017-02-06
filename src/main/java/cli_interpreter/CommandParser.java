package cli_interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The interpreterCommand parser reads the interpreterCommand with the required arguments and checks if the required values are set.
 */
public class CommandParser {
    private Command command;
    private List<String> context = new ArrayList<>();

    CommandParser(Command command, Context context) {
        this.command = command;
        this.context = Arrays.asList(context.getString().split("[\\s]"));
    }

    public boolean hasRequiredArgument() throws Exception {
        if (!command.hasRequiredArgument()) {
            throw new Exception("Command has not a required argument");
        }

        return null != context;
    }

    public String getRequiredArgument() throws Exception {
        if (hasRequiredArgument()) {
            return context.get(0);
        }

        return "";
    }

    public boolean has(String argument) {
        List<String> context2 = context;

        if (command.hasRequiredArgument())
            context2 = context.subList(1, context.size());

        return context2.indexOf(argument) != -1            // value exist
                && (context2.indexOf(argument) + 1) != -1; // next value exist
    }

    public String valueOf(String argument) throws Exception {
        if (!this.has(argument)) {
            throw new Exception("Command has not the requested argument");
        }

        return context.get(context.indexOf(argument) + 1);
    }

    // TODO: 5-2-2017 Make a validator to check for invalid arguments
    private void validate() {
        for (Argument argument : command.getArguments()) {
            if (argument.isRequired() && !has(argument.getName())) {

            }
        }

    }
}

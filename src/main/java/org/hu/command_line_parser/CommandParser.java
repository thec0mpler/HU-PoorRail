package org.hu.command_line_parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private Command command;
    private List<String> context = new ArrayList<>();

    /**
     * Create a new command parser.
     *
     * @param command The command that is used
     * @param context The command that is entered
     */
    CommandParser(Command command, String context) throws Exception {
        this.command = command;
        this.context = getContext(context);

        validate();
    }

    /**
     * Get the context split in values by spaces.
     *
     * @param context A string to be processed
     * @return A list with values.
     */
    private List<String> getContext(String context) {
        // Trim whitespace and split in values by spaces
        List<String> arguments = Arrays.asList(context
                .trim()
                .split("[\\s]"));

        // Create a new list of values that are trimmed and not empty
        List<String> newContext = new ArrayList<>();
        for (String argument : arguments) {
            argument = argument.trim();

            if (!argument.isEmpty())
                newContext.add(argument.trim());
        }

        return newContext;
    }

    /**
     * Get the context without the required argument.
     *
     * @return The context
     */
    private List<String> getArguments() {
        List<String> newContext = null;

        if (command.hasRequiredValue())
            newContext = context.subList(1, context.size());

        return newContext;
    }

    /**
     * Get the required value.
     *
     * @return The required value
     * @throws Exception If the command has no required value specified
     */
    public String getRequiredArgument() throws Exception {
        if (!command.hasRequiredValue()) {
            throw new Exception("Command has not a required argument");
        }

        if (!context.isEmpty()) {
            return context.get(0);
        }

        return null;
    }

    /**
     * Checks if the command has the requested argument.
     *
     * @param argument The argument to be checked
     * @return True if the argument was entered, false otherwise
     */
    public boolean has(String argument) {
        List<String> context = getArguments();

        return context.indexOf(argument) != -1                       // value exist
                && (context.indexOf(argument) + 1) < context.size(); // next value exist
    }

    /**
     * Get the value of the requested argument.
     *
     * @param argument The argument
     * @return Value of the requested argument
     * @throws Exception If the command has not the requested argument
     */
    public String valueOf(String argument) throws Exception {
        if (!this.has(argument)) {
            throw new Exception("ParserCommand has not the requested argument: " + argument);
        }

        return context.get(context.indexOf(argument) + 1);
    }

    /**
     * Validate the command.
     *
     * @throws Exception If the command is not valid
     */
    private void validate() throws Exception {
        // Check if the first required argument exists
        if (null == getRequiredArgument()) {
            throw new Exception("Command has not the first required argument");
        }

        // Get possible arguments
        List<Argument> commandArguments = command.getArguments();

        // Get required arguments
        List<Argument> requiredCommandArguments = new ArrayList<>();

        for (Argument argument : commandArguments) {
            if (argument.isRequired()) {
                requiredCommandArguments.add(argument);
            }
        }

        // If the previous argument was a command
        boolean previousCommand = false;

        // Size of the arguments list
        int argumentsSize = this.getArguments().size();

        // Loop through every argument
        int i = 1;
        for (String argumentString : this.getArguments()) {
            Argument argument = new Argument(argumentString);

            // Check if it is a command, but skip if the previous was a command
            if (commandArguments.contains(argument) && !previousCommand) {
                previousCommand = true;

                // If it is a required argument, remove is from the list
                if (requiredCommandArguments.contains(argument)) {
                    requiredCommandArguments.remove(argument);
                }

                // Check if it has a next value
                if (argumentsSize <= i) {
                    throw new Exception("Command has not a value: " + argument.getName());
                }
            }

            i++;
        }

        // If the required arguments list is not empty
        if (!requiredCommandArguments.isEmpty()) {
            throw new Exception("Command required: " + requiredCommandArguments.get(0));
        }
    }
}

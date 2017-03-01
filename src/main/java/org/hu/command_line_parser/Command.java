package org.hu.command_line_parser;

import java.util.ArrayList;
import java.util.List;

/**
 * A command with the possibilities for:
 *     - a first required value
 *     - arguments
 */
public class Command {
    private boolean requiredValue = false;
    private List<Argument> arguments = new ArrayList<>();

    /**
     * Create a command
     */
    Command() {
    }

    /**
     * Check if the command needs a required value.
     *
     * @return True if the command needs a required value, false otherwise
     */
    boolean hasRequiredValue() {
        return requiredValue;
    }

    /**
     * Set the required value option.
     *
     * @param required If command need a required value
     * @return This command instance
     */
    public Command setRequiredValue(boolean required) {
        this.requiredValue = required;

        return this;
    }

    /**
     * Get a list of the arguments.
     *
     * @return List of arguments
     */
    List<Argument> getArguments() {
        return arguments;
    }

    /**
     * Add an argument to the command
     *
     * @param argument The argument to be added
     * @return This command instance
     */
    public Command addArgument(Argument argument) {
        this.arguments.add(argument);

        return this;
    }
}

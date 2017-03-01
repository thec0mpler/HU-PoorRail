package org.hu.command_line_parser;

/**
 * An argument
 */
public class Argument {
    private String name;
    private boolean required = false;

    /**
     * Create a new optional argument.
     *
     * @param name The name of the argument
     */
    Argument(String name) {
        this(name, false);
    }

    /**
     * Create a new argument that can be required.
     *
     * @param name     The name of the argument
     * @param required If the argument is required
     */

    Argument(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    /**
     * Get the name of the argument.
     *
     * @return The name of the argument
     */
    public String getName() {
        return name;
    }

    /**
     * Check if the argument is required.
     *
     * @return True if the argument is required, otherwise
     */
    boolean isRequired() {
        return required;
    }
}

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
     * @return True if the argument is required, otherwise false
     */
    boolean isRequired() {
        return required;
    }

    /**
     * Check if the argument is the same by name.
     *
     * @param object Object to be checked
     * @return True if the argument names are the same, otherwise false
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Argument) {
            Argument argument = (Argument) object;

            if (this.name.equals(argument.getName())) {
                return true;
            }
        }

        return false;
    }
}

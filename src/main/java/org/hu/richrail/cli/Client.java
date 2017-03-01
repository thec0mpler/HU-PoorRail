package org.hu.richrail.cli;

import org.hu.richrail.cli.command.*;
import org.hu.command_line_parser.CommandParser;
import org.hu.command_line_parser.ParserFacade;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static Client instance = new Client();
    private List<Command> commands = new ArrayList<>();

    private Client() {
    }

    public static Client getInstance() {
        return instance;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public String execute(String input) throws Exception {
        if (null == input)
            return error("Input is empty");

        input = input.trim();

        for (Command command : commands) {
            // Find command
            if (input.startsWith(command.getName())) {
                // Remove command name, keep arguments
                input = input.substring(command.getName().length());

                // Parse command
                CommandParser parser = new ParserFacade().newParser(command.getParserCommand(), input);

                return command.execute(parser);
            }
        }

        return error("Command not found: " + input);
    }

    private String error(String message) {
        return "[ERROR] " + message;
    }
}

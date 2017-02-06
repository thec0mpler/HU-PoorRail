import cli_interpreter.Command;
import cli_interpreter.Context;
import cli_interpreter.CommandParser;
import cli_interpreter.Argument;

public class cli_interpreter {
    public static void main(String[] args) throws Exception {
        // Command that can be used in the terminal
        String commandString = "new wagon wg1 numseats 15";

        // Create a new command with the first value required without a name and a optional argument
        Command command = new Command("new wagon");
        command.setRequiredValue(true);
        command.addArgument(new Argument("numseats"));

        // Parse the command
        CommandParser parser = command.parse(new Context(commandString));

        // Print some output
        System.out.println(parser.hasRequiredArgument());

        if (parser.has("numseats"))
            System.out.println(parser.valueOf("numseats"));
    }
}

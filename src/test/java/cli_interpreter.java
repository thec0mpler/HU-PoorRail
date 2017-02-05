import cli_interpreter.Command;
import cli_interpreter.Context;
import cli_interpreter.CommandParser;
import cli_interpreter.Argument;

public class cli_interpreter {
    public static void main(String[] args) throws Exception {
        String commandString = "new wagon wg1 numseats 15";
//        String commandString = "new wagon wg1";

        Command command = new Command("new wagon");
        command.setRequiredValue(true);
        command.addArgument(new Argument("numseats"));

        CommandParser parser = command.parse(new Context(commandString));

        System.out.println(parser.hasRequiredArgument());

        if (parser.has("numseats"))
            System.out.println(parser.valueOf("numseats"));
    }
}

import cli_interpreter.Command;
import cli_interpreter.Context;
import cli_interpreter.CommandParser;
import cli_interpreter.Argument;
import commands.Client;

public class cli_interpreter {
    public static void main(String[] args) throws Exception {
        Client client = Client.getInstance();
        System.out.println(client.execute("new wagon wg1"));
        System.out.println(client.execute("new wagon wg2 numseats 25"));
        System.out.println(client.execute("get wagons"));
        System.out.println(client.execute("new train tr1"));
        System.out.println(client.execute("new train tr1"));
        System.out.println(client.execute("add wg2 to tr1"));
        System.out.println(client.execute("getnumseats wagon wg2"));
        System.out.println(client.execute("add wg1 to tr1"));
        System.out.println(client.execute("add wg2 to tr1"));
        System.out.println(client.execute("getnumseats train tr1"));
        System.out.println(client.execute("delete wagon wg1"));
        System.out.println(client.execute("get wagons"));
        System.out.println(client.execute("delete train tr1"));
        System.out.println(client.execute("new train tr1"));
        System.out.println(client.execute("new wagon wg1"));
        System.out.println(client.execute("add wg1 to tr1"));
        System.out.println(client.execute("remove wg1 from tr1"));
    }

    public static void main2() throws Exception {
        // Command that can be used in the terminal
        String commandString = "new wagon wg1 numseats 15";

        // Create a new interpreterCommand with the first value required without a name and a optional argument
        Command command = new Command("new wagon");
        command.setRequiredValue(true);
        command.addArgument(new Argument("numseats"));

        // Parse the interpreterCommand
        CommandParser parser = command.parse(new Context(commandString));

        // Print some output
        System.out.println(parser.hasRequiredArgument());

        if (parser.has("numseats"))
            System.out.println(parser.valueOf("numseats"));
    }
}

import org.hu.richrail.cli.Client;
import org.hu.richrail.cli.command.*;
import org.hu.command_line_parser.Command;
import org.hu.command_line_parser.CommandParser;
import org.hu.command_line_parser.ParserFacade;

public class cli_interpreter {
    public static void main(java.lang.String[] args) throws Exception {
        Client client = Client.getInstance();

        client.addCommand(new NewTrainCommand());
        client.addCommand(new NewWagonCommand());
        client.addCommand(new GetWagonsCommand());
        client.addCommand(new AddToCommand());
        client.addCommand(new GetNumSeatsWagonCommand());
        client.addCommand(new GetNumSeatsTrainCommand());
        client.addCommand(new DeleteWagonCommand());
        client.addCommand(new DeleteTrainCommand());
        client.addCommand(new RemoveFromCommand());



        System.out.println(client.execute("add wg1 to"));

//        List<String> arguments = new ArrayList<>();
//        arguments.add("argument1 ");
//        arguments.add("argument2 ");
//        arguments.add("argument3 ");
//
//        List<String> newContext = new ArrayList<>();
//
//        for (String argument : arguments) {
//            newContext.add(argument.trim());
//        }
//
//        System.out.println(newContext);
//
//        System.exit(0);

//        String input = "wg2 numseats 25";
//        ParserCommand command = new ParserCommand()
//                .setRequiredValue(true)
//                .addArgument(new Argument("numseats"));
//        CommandParser parser = command.parse(input);
//
//        System.out.println(parser.getRequiredArgument());
//
//        System.exit(0);

//        System.out.println(client.execute("new wagon wg1"));
//        System.out.println(client.execute("new wagon wg2 numseats 25"));
//        System.out.println(client.execute("get wagons"));
//        System.out.println(client.execute("new train tr1"));
//        System.out.println(client.execute("new train tr1"));
//        System.out.println(client.execute("add wg2 to tr1"));
//        System.out.println(client.execute("getnumseats wagon wg2"));
//        System.out.println(client.execute("add wg1 to tr1"));
//        System.out.println(client.execute("add wg2 to tr1"));
//        System.out.println(client.execute("getnumseats train tr1"));
//        System.out.println(client.execute("delete wagon wg1"));
//        System.out.println(client.execute("get wagons"));
//        System.out.println(client.execute("delete train tr1"));
//        System.out.println(client.execute("new train tr1"));
//        System.out.println(client.execute("new wagon wg1"));
//        System.out.println(client.execute("add wg1 to tr1"));
//        System.out.println(client.execute("remove wg1 from tr1"));
//        System.out.println(client.execute("remove wg2 from tr1"));
    }

    public static void main2() throws Exception {
        ParserFacade parserFacade = new ParserFacade();

        // ParserCommand that can be used in the terminal
        java.lang.String commandString = "new wagon wg1 numseats 15";

        // Create a new command with the first value required without a name and a optional argument
        Command command = parserFacade.newCommand();
        command.setRequiredValue(true);
        command.addArgument(parserFacade.newArgument("numseats"));

        // Parse the command
        CommandParser parser = parserFacade.newParser(command, commandString);

        // Print some output
        System.out.println(parser.getRequiredArgument());

        if (parser.has("numseats"))
            System.out.println(parser.valueOf("numseats"));
    }
}

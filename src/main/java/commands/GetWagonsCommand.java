package commands;

import cli_interpreter.CommandParser;
import model.vehicle.Wagon;

import java.util.List;

public class GetWagonsCommand extends Command {

    GetWagonsCommand() {
        super("get wagons");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("new wagons");

        return command;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        Client client = Client.getInstance();
        List<Wagon> wagons = client.getWagons();

        if (wagons.isEmpty())
            return "There are no wagons";

        String output = "Wagons:";
        for (Wagon wagon : wagons) {
            output += "\n\t'" + wagon.getName() + "', seats: " + wagon.getSeats();
        }

        return output;
    }
}

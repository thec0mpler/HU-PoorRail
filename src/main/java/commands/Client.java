package commands;

import cli_interpreter.CommandParser;
import cli_interpreter.Context;
import model.vehicle.Wagon;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static Client instance = new Client();
    private List<Command> commands = new ArrayList<>();
    private List<Wagon> wagons = new ArrayList<>();

    private Client() {
        this.commands.add(new NewTrainCommand());
        this.commands.add(new NewWagonCommand());
        this.commands.add(new GetWagonsCommand());
        this.commands.add(new AddToCommand());
        this.commands.add(new GetNumSeatsWagonCommand());
        this.commands.add(new GetNumSeatsTrainCommand());
        this.commands.add(new DeleteWagonCommand());
        this.commands.add(new DeleteTrainCommand());
        this.commands.add(new RemoveFromCommand());
    }

    public static Client getInstance() {
        return instance;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public String addWagon(Wagon wagon) {
        if (!wagons.contains(wagon)) {
            wagons.add(wagon);

            return "New wagon added," +
                    " name '" + wagon.getName() + "'," +
                    " seats '" + wagon.getSeats() + "'";
        } else {
            return "Wagon name already exists";
        }
    }

    public void removeWagon(Wagon wagon) {
        wagons.remove(wagon);
    }

    public Wagon getWagon(String name) {
        Wagon tempWagon = new Wagon(name);

        for (Wagon wagon : wagons) {
            if (wagon.equals(tempWagon)) {
                return wagon;
            }
        }

        return null;
    }

    public String execute(String input) throws Exception {
        if (null == input)
            return "Input is empty";

        for (Command command : commands) {
            if (input.startsWith(command.getName())) {
                CommandParser parser = command.getInterpreterCommand().parse(new Context(input));

                return command.execute(parser);
            }
        }

        return "ERROR: Command not found '" + input + "'";
    }
}

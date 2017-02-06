package commands;

import cli_interpreter.Argument;
import cli_interpreter.CommandParser;
import model.Train;
import model.vehicle.Wagon;

public class NewTrainCommand extends Command {
    public NewTrainCommand() {
        super("new train");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("new train");
        command.setRequiredValue(true);

        return command;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String name = parser.getRequiredArgument();

        Train train = new Train(name);

        if (richRail.addTrain(train)) {
            return "Add train added, name '" + train.getName() + "'";
        } else {
            return "Train already exists: '" + train.getName() + "'";
        }
    }
}

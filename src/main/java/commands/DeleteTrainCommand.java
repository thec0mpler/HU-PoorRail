package commands;

import cli_interpreter.CommandParser;
import model.Train;
import model.vehicle.Wagon;

public class DeleteTrainCommand extends Command {
    public DeleteTrainCommand() {
        super("delete train");
    }

    @Override
    public cli_interpreter.Command getInterpreterCommand() {
        cli_interpreter.Command command;
        command = new cli_interpreter.Command("delete train");
        command.setRequiredValue(true);

        return command;
    }

    @Override
    public String execute(CommandParser parser) throws Exception {
        String trainName = parser.getRequiredArgument();
        Train train = richRail.getTrain(trainName);

        if (null != train) {
            richRail.removeTrain(train);

            return "Train '" + trainName + "' deleted";
        }

        return  "Train '" + trainName + "' does not exist";
    }
}

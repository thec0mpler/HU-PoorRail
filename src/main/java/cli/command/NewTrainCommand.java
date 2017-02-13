package cli.command;

import command_line_parser.CommandParser;
import model.Train;

public class NewTrainCommand extends Command {
    public NewTrainCommand() {
        super("new train");
    }

    @Override
    public command_line_parser.Command getParserCommand() {
        return parserFacade.newCommand()
                .setRequiredValue(true);
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

package cli_interpreter;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private String name;
    private boolean requiredValue = false;
    private List<Argument> argumentList = new ArrayList<>();

    public Command(String name) {
        this.name =  name;
    }

    public String getName() {
        return name;
    }

    boolean hasRequiredArgument() {
        return requiredValue;
    }

    public void setRequiredValue(boolean required) {
        this.requiredValue = required;
    }

    List<Argument> getArguments() {
        return argumentList;
    }

    public void addArgument(Argument argument) {
        this.argumentList.add(argument);
    }

    public CommandParser parse(Context context) {
        return new CommandParser(this, context);
    }
}

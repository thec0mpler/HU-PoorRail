package cli_interpreter;

public class Argument {
    private String name;
    private boolean required = false;

    public Argument(String name) {
        this(name, false);
    }

    public Argument(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }
}

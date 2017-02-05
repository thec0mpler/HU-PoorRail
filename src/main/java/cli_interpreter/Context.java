package cli_interpreter;

public class Context {
    private String input;

    public Context(String input) {
        this.input = input;
    }

    String getString() {
        return input;
    }
}

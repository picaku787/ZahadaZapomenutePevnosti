import java.util.Map;

public class Pomoc implements Command {
    private Map<String, Command> commands;

    public Pomoc(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute() {
        String result = "Dostupné příkazy:\n";
        for (String command : commands.keySet()) {
            result += "- " + command + "\n";
        }
        return result;
    }

    @Override
    public boolean exit() {
        return false;
    }
}

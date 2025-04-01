import java.util.Map;
/**
 * Třída pro příkaz "Pomoc" ve hře.
 * Tento příkaz vypíše seznam všech dostupných příkazů, které hráč může použít.
 *
 * @autor Dominik Svoboda
 */
public class Pomoc implements Command {
    private Map<String, Command> commands;

    public Pomoc(Map<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * Provede akci příkazu "Pomoc".
     * Tento příkaz vypíše seznam všech dostupných příkazů, které jsou uloženy v mapě příkazů.
     *
     * @return Textová zpráva, která obsahuje seznam všech dostupných příkazů.
     */
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

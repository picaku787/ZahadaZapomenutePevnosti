public class Konec implements Command {
    private Console console;

    public Konec(Console console) {
        this.console = console;
    }

    @Override
    public String execute() {
        return "Hra se ukončuje....";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
public class Vezmi implements  Command {
    private Inventar inventar;
    private Location location;

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

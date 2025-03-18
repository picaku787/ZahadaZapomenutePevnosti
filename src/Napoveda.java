public class Napoveda implements Command {
    @Override
    public String execute() {
        return "Nápověda: Prozkoumávej místnosti a sbírej předměty, abys vyřešil hádanky pevnosti.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

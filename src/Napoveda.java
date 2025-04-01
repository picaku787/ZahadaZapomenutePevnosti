/**
 * Třída pro příkaz "Nápověda" ve hře.
 * Tento příkaz hráči poskytuje nápovědu o cíli hry.
 */
public class Napoveda implements Command {
    /**
     * @return Textová nápověda, která hráči říká, jak postupovat ve hře.
     */
    @Override
    public String execute() {
        return "Nápověda: Prozkoumávej místnosti a sbírej předměty, abys vyřešil hádanky pevnosti.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

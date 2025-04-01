/**
 * Třída pro ukončení hry.
 *
 * @autor Dominik Svoboda
 */
public class Konec implements Command {
    private Console console;

    /**
     * Konstruktor pro příkaz "Konec", který ukončuje hru.
     *
     * @param console Objekt konzole
     */
    public Konec(Console console) {
        this.console = console;
    }
    /**
     * @return Text o ukončení hry
     */
    @Override
    public String execute() {
        return "Hra se ukončuje....";
    }

    /**
     * Určuje, že tento příkaz ukončí aplikaci.
     *
     * @return true
     */
    @Override
    public boolean exit() {
        return true;
    }
}
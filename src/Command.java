/**
 * Rozhraní pro implementaci příkazů.
 *
 * @autor Dominik Svoboda
 */
public interface Command {
    /**
     * Provede příkaz.
     *
     * @return Výsledek provedení příkazu jako text
     */
    String execute();
    /**
     * Určuje, zda příkaz ukončí aplikaci.
     *
     * @return true pokud příkaz ukončí aplikaci, jinak false
     */
    boolean exit();
}
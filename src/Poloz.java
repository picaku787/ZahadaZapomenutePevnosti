import java.util.ArrayList;
import java.util.Scanner;
/**
 * Třída pro příkaz "Polož" ve hře.
 * Tento příkaz umožňuje hráči položit předmět z jeho inventáře.
 * Pokud předmět není v inventáři, hráč dostane odpověď, že tento předmět neexistuje.
 *
 * @autor Dominik Svoboda
 */
public class Poloz implements Command {
    private Inventar inventar;

    public Poloz(Inventar inventar) {
        this.inventar = inventar;
    }

    /**
     * Provede akci položení předmětu z inventáře.
     * Hráč zadá název předmětu, který chce položit. Pokud je tento předmět nalezen v inventáři,
     * je odstraněn a hráč dostane potvrzení o položení.
     *
     * @return Textová zpráva, která informuje o výsledku akce.
     *         Buď potvrzení o úspěšném položení předmětu, nebo informace, že předmět není v inventáři.
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadejte jméno předmětu k položení: ");
        String itemName = sc.nextLine().trim().toLowerCase();

        for (Item item : new ArrayList<>(inventar.items)) {
            if (item.getName().toLowerCase().equals(itemName)) {
                inventar.removeItem(item);
                return "Položil jsi " + item.getName() + ".";
            }
        }
        return "Tento předmět není v inventáři.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

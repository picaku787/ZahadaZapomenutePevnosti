/**
 * Třída pro sebrání předmětu.
 *
 * @autor Dominik Svoboda
 */
import java.util.HashMap;
import java.util.Scanner;

public class Vezmi implements Command {
    private Inventar inventar;
    private HashMap<Integer, Item> items;
    private Map map;

    /**
     * Konstruktor pro příkaz "Vezmi", který přidá předmět do inventáře.
     *
     * @param inventar Inventář hráče
     * @param items Seznam předmětů
     * @param map Mapa, která definuje herní prostředí
     */
    public Vezmi(Inventar inventar, HashMap<Integer, Item> items, Map map) {
        this.inventar = inventar;
        this.items = items;
        this.map = map;
    }

    /**
     * Provádí sebrání předmětu.
     *
     * @return Výsledek sebrání předmětu
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadejte jméno předmětu: ");
        String itemName = sc.nextLine().trim().toLowerCase();
        int currentLocation = map.getPosition();

        for (Item item : items.values()) {
            if (item.getName().toLowerCase().equals(itemName) && item.getLocation() == currentLocation) {
                if (item.isCanTake()) {
                    inventar.addItem(item);
                    item.setLocation(-1);
                    return "Sebral jsi " + item.getName() + ".";
                } else {
                    return "Tento předmět nelze vzít.";
                }
            }
        }
        return "Tento předmět zde není.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

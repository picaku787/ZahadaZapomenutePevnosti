import java.util.HashMap;
import java.util.Scanner;


/**
 * Třída pro příkaz "Použít" ve hře.
 * Tento příkaz umožňuje hráči použít předměty z inventáře v závislosti na jejich umístění a aktuálních podmínkách.
 *
 * @autor Dominik Svoboda
 */
public class Pouzij implements Command {
    private Inventar inventar;
    private HashMap<Integer, Item> items;
    private Map map;
    private boolean leverUsed = false;
    private boolean potionUsed = false;

    public Pouzij(Inventar inventar, HashMap<Integer, Item> items, Map map) {
        this.inventar = inventar;
        this.items = items;
        this.map = map;
    }
    /**
     * Provede akci příkazu "Použít".
     * Umožňuje hráči použít předmět, pokud je v jeho inventáři a je ve správné lokaci.
     *
     * @return Textová zpráva, která informuje hráče o použití předmětu a jeho účincích.
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadejte jméno předmětu k použití: ");
        String itemName = sc.nextLine().trim().toLowerCase();
        int currentLocation = map.getPosition();

        for (Item item : items.values()) {
            if (!item.getName().toLowerCase().equals(itemName)) {
                continue;
            }
            if (item.getUseLocation() != currentLocation) {
                return "Tento předmět zde nemůžeš použít.";
            }
            if (inventar.items.contains(item)) {
                inventar.removeItem(item);
            }

            switch (item.getName().toLowerCase()) {
                case "pochodeň":
                    if (map.getMap().containsKey(3)) {
                        map.getMap().get(3).setLocked(false);
                        return "Použil jsi "+item.getName()+" a místnost 3 je nyní odemčena!";
                    }
                    break;
                case "páka":
                    leverUsed = true;
                    return "Použil jsi "+item.getName()+ ". Nyní musíš ještě použít Klíč k odemčení místnosti 7.";
                case "lektvar":
                    potionUsed = true;
                    return "Použil jsi "+item.getName()+ ". Nyní musíš ještě použít Klíč k odemčení místnosti 7.";
                case "klíč":
                    if (map.getMap().containsKey(7) && leverUsed && potionUsed) {
                        map.getMap().get(7).setLocked(false);
                        return "Použil jsi "+ item.getName() +" a protože jsi již použil Páku a Lektvar, místnost 7 je nyní odemčena!";
                    }
                    return "Nejdříve musíš použít Páku a Lektvar, než můžeš odemknout místnost 7 Klíčem.";
                default:
                    return "Použil jsi " + item.getName() + ".";
            }
        }
        return "Tento předmět neexistuje.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
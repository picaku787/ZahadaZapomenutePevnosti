import java.util.HashMap;
import java.util.Scanner;

public class Pouzij implements Command {
    private Inventar inventar;
    private HashMap<Integer, Item> items;
    private int currentLocation;

    public Pouzij(Inventar inventar, HashMap<Integer, Item> items, int currentLocation) {
        this.inventar = inventar;
        this.items = items;
        this.currentLocation = currentLocation;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadejte jméno předmětu k použití: ");
        String itemName = sc.nextLine().trim().toLowerCase();

        for (Item item : inventar.items) {
            if (item.getName().toLowerCase().equals(itemName)) {
                if (item.getUseLocation() == currentLocation) {
                    inventar.removeItem(item);
                    return "Použil jsi " + item.getName() + ".";
                } else {
                    return "Tento předmět zde nemůžeš použít.";
                }
            }
        }
        return "Tento předmět není v inventáři.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

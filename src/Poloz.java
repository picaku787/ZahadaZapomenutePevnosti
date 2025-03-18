import java.util.ArrayList;
import java.util.Scanner;

public class Poloz implements Command {
    private Inventar inventar;

    public Poloz(Inventar inventar) {
        this.inventar = inventar;
    }

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

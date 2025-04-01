
import java.util.ArrayList;

/**
 * Třída pro správu inventáře hráče.
 *
 * @autor Dominik Svoboda
 */
public class Inventar implements Command {
    public ArrayList<Item> items = new ArrayList<>();

    /**
     * Provádí zobrazení inventáře.
     *
     * @return Výpis obsahu inventáře
     */
    @Override
    public String execute() {
        if (items.isEmpty()) {
            return "Inventář je prázdný.";
        }
        String result = "Obsah inventáře: ";
        for (int i = 0; i < items.size(); i++) {
            result += items.get(i).getName();
            if (i < items.size() - 1) {
                result += ", ";
            }
        }
        return result;
    }

    @Override
    public boolean exit() {
        return false;
    }
    /**
     * Přidá předmět do inventáře, pokud je možné ho sebrat.
     *
     * @param item Předmět, který se přidá
     */
    public void addItem(Item item) {
        if (item.isCanTake()) {
            items.add(item);
        }
    }
    /**
     * Odebere předmět z inventáře.
     *
     * @param item Předmět, který se odstraní
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
}
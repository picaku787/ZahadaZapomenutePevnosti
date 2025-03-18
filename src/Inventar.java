import java.util.ArrayList;

public class Inventar implements Command {
    public ArrayList<Item> items = new ArrayList<>();

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

    public void addItem(Item item) {
        if (item.isCanTake()) {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
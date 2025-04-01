import java.util.HashMap;
import java.util.Scanner;
/**
 * Třída pro příkaz "Prozkoumej" ve hře.
 * Tento příkaz umožňuje hráči prozkoumávat místnosti a předměty v aktuálním místě.
 *
 * @autor Dominik Svoboda
 */
public class Prozkoumej implements Command {
    private Map map;
    private HashMap<Integer, Item> items;
    private HashMap<String, Character> characters;

    public Prozkoumej(Map map, HashMap<Integer, Item> items, HashMap<String, Character> characters) {
        this.map = map;
        this.items = items;
        this.characters = characters;
    }

    /**
     * Provede akci příkazu "Prozkoumej".
     * Umožňuje hráči prozkoumat místnost nebo předměty v aktuálním místě.
     * Pokud hráč zvolí "místnost", zobrazí se informace o předmětech a postavách v místnosti.
     * Pokud hráč zadá název předmětu, získá informace o jeho umístění.
     *
     * @return Textová zpráva o prozkoumané místnosti nebo předmětu.
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Co chceš prozkoumat? (místnost/předmět): ");
        String input = sc.nextLine().trim().toLowerCase();

        int currentLocation = map.getPosition();

        if (input.equals("místnost")) {
            String result = "Nacházíš se v: " + map.getCurrentLocation(currentLocation).getName() + "\n";
            result += "Předměty zde: ";
            boolean hasItems = false;
            for (Item item : items.values()) {
                if (item.getLocation() == currentLocation) {
                    result += item.getName() + ", ";
                    hasItems = true;
                }
            }
            if (!hasItems) result += "žádné";
            result += "\nPostavy zde: ";
            boolean hasCharacters = false;
            for (Character character : characters.values()) {
                if (character.getLocation() == currentLocation) {
                    result += character.getName() + ", ";
                    hasCharacters = true;
                }
            }
            if (!hasCharacters) result += "žádné";
            return result;
        } else {
            for (Item item : items.values()) {
                if (item.getName().toLowerCase().equals(input)) {
                    return "Předmět: " + item.getName() + " - umístění: " + item.getLocation();
                }
            }
            return "Tento předmět zde není.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
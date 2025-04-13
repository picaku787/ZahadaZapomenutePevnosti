import java.util.HashMap;
import java.util.Scanner;

/**
 * Třída pro příkaz "Mluvit" ve hře.
 *
 * Tento příkaz umožňuje hráči mluvit s postavami, které se nacházejí v jeho aktuální lokaci.
 *
 * @autor Dominik Svoboda
 */
public class Mluv implements Command {
    private HashMap<String, Character> characters;
    private Map map;
    private Inventar inventar;
    private HashMap<Integer, Item> items;
    private Pouzij pouzij;


    public Mluv(HashMap<String, Character> characters, Map map, Inventar inventar, HashMap<Integer, Item> items, Pouzij pouzij) {
        this.characters = characters;
        this.map = map;
        this.inventar = inventar;
        this.items = items;
        this.pouzij = pouzij;
    }

    /**
     * Provede příkaz "mluvit" – pokusí se navázat rozhovor s postavou.
     * <p>
     * Ověří, jestli se zadaná postava nachází v aktuální lokaci hráče
     * a provede interakci.
     *
     * @return Výsledek pokusu o rozhovor s postavou.
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("S kým chceš mluvit?: ");
        String characterName = sc.nextLine().trim().toLowerCase();

        if (characters.containsKey(characterName)) {
            Character character = characters.get(characterName);
            int currentLocation = map.getPosition();

            if (character.getLocation() == currentLocation) {
                boolean result = character.interactWithPlayer(inventar, items, pouzij);
                if (result) {
                    return "Interakce proběhla úspěšně.";
                } else {
                    int wantedItemId = character.getWantedItem();
                    if (items.containsKey(wantedItemId)) {
                        String itemName = items.get(wantedItemId).getName();
                        return "Postava chce: " + itemName;
                    }}
                } else{
                    return "Tato postava zde není.";
                }
            }
            return "Tuto postavu neznáš.";
        }

        @Override
        public boolean exit () {
            return false;
        }
    }


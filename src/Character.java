import java.util.ArrayList;
import java.util.HashMap;

/**
 * Třída představující postavu ve hře.
 *
 * @autor Dominik Svoboda
 */
public class Character {
    private String name;
    private int location;
    private int wantedItem;
    private int givenItem;
    /**
     * Konstruktor třídy Character.
     *
     * @param name Jméno postavy
     * @param location Lokace postavy
     * @param wantedItem Předmět, který postava chce
     * @param givenItem Předmět, který postava dává
     */
    public Character(String name, int location, int wantedItem, int givenItem) {
        this.name = name;
        this.location = location;
        this.wantedItem = wantedItem;
        this.givenItem = givenItem;
    }

    /**
     * Provede interakci hráče s postavou.
     *
     * Pokud má hráč požadovaný předmět, odebere ho a případně přidá nový.
     *
     * @return true, pokud interakce proběhla úspěšně, jinak false.
     */
    public boolean interactWithPlayer(Inventar inventar, HashMap<Integer, Item> items ,Pouzij pouzij) {
        for (Item item : new ArrayList<>(inventar.items)) {
            if (item.getId() == wantedItem) {
                inventar.removeItem(item);


                if (name.equalsIgnoreCase("Tajemný mnich")) {
                    pouzij.setMnichSatisfied(true);
                    System.out.println("Tajemný mnich přijal předmět a vypadá spokojeně. Udělal jsi další krok k odemčení místnosti 7.");
                }


                if (givenItem != 0 && items.containsKey(givenItem)) {
                    Item newItem = items.get(givenItem);
                    inventar.addItem(newItem);
                    System.out.println("Vyměnil jsi " + item.getName() + " za " + newItem.getName() + ".");
                }

                return true;
            }
        }
        return false;
    }

    public String getName() { return name; }
    public int getLocation() { return location; }
    public int getWantedItem() { return wantedItem; }
}

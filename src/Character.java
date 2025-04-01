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

    public String getName() { return name; }
    public int getLocation() { return location; }
    public int getWantedItem() { return wantedItem; }
    public int getGivenItem() { return givenItem; }
}

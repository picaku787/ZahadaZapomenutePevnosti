/**
 * Třída reprezentující předmět ve hře.
 *
 * @autor Dominik Svoboda
 */
public class Item {
    private int id;
    private String name;
    private int location;
    private int useLocation;
    private boolean canTake;

    /**
     * Konstruktor třídy Item.
     *
     * @param id ID předmětu
     * @param name Název předmětu
     * @param location Místo, kde se předmět nachází
     * @param useLocation Místo, kde může být předmět použit
     * @param canTake Určuje, zda lze předmět sebrat
     */
    public Item(int id, String name, int location, int useLocation, boolean canTake) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.useLocation = useLocation;
        this.canTake = canTake;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getLocation() { return location; }
    public int getUseLocation() { return useLocation; }
    public boolean isCanTake() { return canTake; }

    public void setLocation(int location) {
        this.location = location;
    }
}
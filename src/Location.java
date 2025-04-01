import java.util.ArrayList;

/**
 * Třída pro reprezentaci lokace ve hře .
 *
 * Tato třída obsahuje informace o lokaci, jako je její ID, název, seznam připojených lokalit
 * a zda je tato lokace zamčená.
 *
 * @autor Dominik Svoboda
 */
public class Location {
    private int id;
    private String name;
    private ArrayList<Integer> locations;
    private boolean locked;

    /**
     * Konstruktor pro vytvoření lokace.
     *
     * @param id ID lokace
     * @param name Název lokace
     * @param locations Seznam dalších lokalit, které jsou připojené k této lokaci
     * @param locked Určuje, zda je lokace zamčená
     */
    public Location(int id, String name, ArrayList<Integer> locations, boolean locked) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.locked = locked;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Integer> locations) {
        this.locations = locations;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

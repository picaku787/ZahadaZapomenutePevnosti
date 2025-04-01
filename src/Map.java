import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Třída pro správu mapy ve hře.
 *
 * Tato třída umožňuje načítat data o lokacích z textového souboru, sledovat aktuální pozici
 * hráče a poskytovat informace o dostupných lokacích.
 *
 * @autor Dominik Svoboda
 */
public class Map {
    private HashMap<Integer, Location> map = new HashMap<>();
    private int startingPosition = 1;
    private int currentPosition = startingPosition;

    /**
     * Načítá mapu z textového souboru a vytváří objekty typu Location.
     *
     * Soubor "mista.txt" by měl obsahovat data v následujícím formátu:
     * ID_lokace,Název_lokace,Seznam_ID_dostupných_propojených_lokalit,Stav_zamčení_lokace
     */
    public void loadMap() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("mista.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(",");
                int locationId = Integer.parseInt(lines[0]);
                String locationName = lines[1];
                ArrayList<Integer> availableLocations = new ArrayList<>();
                boolean isLocked = Boolean.parseBoolean(lines[lines.length - 1]);

                for (int i = 2; i < lines.length - 1; i++) {
                    availableLocations.add(Integer.parseInt(lines[i]));
                }

                Location location = new Location(locationId, locationName, availableLocations, isLocked);
                map.put(locationId, location);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPosition() {
        return currentPosition;
    }

    public void setPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Location getCurrentLocation(int id) {
        return map.get(id);
    }

    public HashMap<Integer, Location> getMap() {
        return map;
    }
}

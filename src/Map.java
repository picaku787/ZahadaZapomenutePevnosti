import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private HashMap<Integer, Location> map = new HashMap<>();
    private int startingPosition = 1;
    private int currentPosition = startingPosition;

    public boolean loadMap() {
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
            return true;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private HashMap<Integer, Location> map = new HashMap<>();

    public Map() {
    }

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("mista.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                boolean locked = Boolean.parseBoolean(parts[parts.length - 1]);

                ArrayList<Integer> connections = new ArrayList<>();
                for (int i = 2; i < parts.length - 1; i++) {
                    connections.add(Integer.parseInt(parts[i]));
                }

                Location location = new Location(id, name, connections, locked);
                map.put(id, location);
            }
            return true;
        }  catch (IOException e) {
            return false;
        }
    }

    public Location getLocation(int id) {
        return map.get(id);
    }
}
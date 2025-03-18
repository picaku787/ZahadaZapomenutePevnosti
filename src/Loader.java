import java.io.*;
import java.util.*;


public class Loader {
    private HashMap<Integer, Item> items = new HashMap<>();
    private HashMap<String, Character> characters = new HashMap<>();

    public void loadItems(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int location = Integer.parseInt(data[2]);
                int useLocation = Integer.parseInt(data[3]);
                boolean canTake = Boolean.parseBoolean(data[4]);

                items.put(id, new Item(id, name, location, useLocation, canTake));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCharacters(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader("characters.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int location = Integer.parseInt(data[1]);
                int wantedItem = Integer.parseInt(data[2]);
                int givenItem = Integer.parseInt(data[3]);

                characters.put(name.toLowerCase(), new Character(name, location, wantedItem, givenItem));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Item> getItems() {
        return items;
    }

    public HashMap<String, Character> getCharacters() {
        return characters;
    }
}

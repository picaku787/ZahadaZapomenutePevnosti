import java.io.*;
import java.util.*;

/**
 * Třída pro načítání položek a postav z textových souborů.
 *
 * Tato třída obsahuje metody pro načítání informací o předmětech a postavách ze souborů,
 * které jsou uloženy do hash map pro pozdější použití.
 *
 * @autor Dominik Svoboda
 */
public class Loader {
    private HashMap<Integer, Item> items = new HashMap<>();
    private HashMap<String, Character> characters = new HashMap<>();

    /**
     * Načítá položky ze souboru "items.txt" a ukládá je do mapy položek.
     *
     * Soubor "items.txt" by měl obsahovat data v následujícím formátu:
     * ID_předmětu,Název_předmět,Umístění_předmětu,Umístění_pro_použití_předmětu,Možnost_sebrání
     */
    public void loadItems() {
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

    /**
     * Načítá postavy ze souboru "characters.txt" a ukládá je do mapy postav.
     *
     * Soubor "characters.txt" by měl obsahovat data v následujícím formátu:
     * Jméno_postavy,Umístění_postavy,Požadovaný_předmět,Poskytnutý_předmět
     */
    public void loadCharacters() {
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

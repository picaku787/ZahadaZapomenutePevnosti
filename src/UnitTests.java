import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
/**
 * Třída pro unit testy herního systému.
 * Testuje různé komponenty, jako je načítání mapy, předmětů a postav, běh příkazů a manipulaci s inventářem.
 *
 * @autor Dominik Svoboda , ChatGPT
 */
public class UnitTests {
    private Console console;
    private Map map;
    private Loader loader;
    private Inventar inventar;

    @BeforeEach
    public void setup() {
        console = new Console();
        map = new Map();
        loader = new Loader();
        inventar = new Inventar();

        map.loadMap();
        loader.loadCharacters();
        loader.loadItems();

        console.initialization();
    }
    /**
     * Testuje načítání mapy.
     * Ověřuje, že mapa není prázdná po jejím načtení.
     */
    @Test
    public void testLoadMap() {
        assertFalse(map.getMap().isEmpty(), "Mapa by měla být úspěšně načtena.");
    }
    /**
     * Testuje načítání předmětů.
     * Ověřuje, že předměty jsou úspěšně načteny.
     */
    @Test
    public void testLoadItems() {
        System.out.println("Počet načtených položek: " + loader.getItems().size());
        assertFalse(loader.getItems().isEmpty(), "Předměty by měly být úspěšně načteny.");
    }
    /**
     * Testuje načítání postav.
     * Ověřuje, že postavy jsou úspěšně načteny.
     */
    @Test
    public void testLoadCharacters() {
        System.out.println("Počet načtených postav: " + loader.getCharacters().size());
        assertFalse(loader.getCharacters().isEmpty(), "Postavy by měly být úspěšně načteny.");
    }
    /**
     * Testuje běh platného příkazu.
     * Ověřuje, že příkaz "inventar" správně vrátí informaci o prázdném inventáři.
     */
    @Test
    public void testRunValidCommand() {
        Command inventarCommand = console.commands.get("inventar");
        assertNotNull(inventarCommand, "Příkaz 'inventar' by měl existovat.");
        assertEquals("Inventář je prázdný.", inventarCommand.execute(), "Inventář by měl být prázdný.");
    }
    /**
     * Testuje běh neplatného příkazu.
     * Ověřuje, že neexistující příkaz vrátí hodnotu null.
     */
    @Test
    public void testRunInvalidCommand() {
        assertNull(console.commands.get("neexistuje"), "Neznámý příkaz by neměl existovat.");
    }
    /**
     * Testuje příkaz pro ukončení hry.
     * Ověřuje, že příkaz "konec" správně vrací hodnotu pro ukončení hry.
     */
    @Test
    public void testExitCommand() {
        Command exitCommand = console.commands.get("konec");
        assertNotNull(exitCommand, "Příkaz 'konec' by měl existovat.");
        assertTrue(exitCommand.exit(), "Příkaz 'konec' by měl ukončit hru.");
    }
    /**
     * Testuje akci sebrání předmětu.
     * Ověřuje, že předmět je úspěšně sebrán a přidán do inventáře.
     */
    @Test
    public void testTakeItem() {
        HashMap<Integer, Item> items = loader.getItems();
        Item testItem = new Item(99, "Testovací předmět", map.getPosition(), -1, true);
        items.put(testItem.getId(), testItem);


        String simulatedInput = "Testovací předmět\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            Vezmi vezmi = new Vezmi(inventar, items, map);
            assertEquals("Sebral jsi Testovací předmět.", vezmi.execute(), "Předmět by měl být úspěšně sebrán.");
            assertTrue(inventar.items.contains(testItem), "Inventář by měl obsahovat sebraný předmět.");
        } finally {
            System.setIn(originalSystemIn);
        }
    }
    /**
     * Testuje akci položení předmětu.
     * Ověřuje, že předmět je úspěšně položen a odstraněn z inventáře.
     */
    @Test
    public void testDropItem() {
        Item testItem = new Item(99, "Testovací předmět", -1, -1, true);
        inventar.addItem(testItem);


        String simulatedInput = "Testovací předmět\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            Poloz poloz = new Poloz(inventar);
            assertEquals("Položil jsi Testovací předmět.", poloz.execute(), "Předmět by měl být úspěšně položen.");
            assertFalse(inventar.items.contains(testItem), "Inventář by neměl obsahovat položený předmět.");
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
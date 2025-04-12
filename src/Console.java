/**
 * Třída reprezentující herní konzoli, která spravuje interakce s uživatelem.
 *
 * @autor Dominik Svoboda
 */
import java.util.*;

/**
 * Třída reprezentující herní konzoli, která spravuje interakce s uživatelem.
 *
 * @autor Dominik Svoboda
 */
public class Console {
    private boolean exit = false;
    public HashMap<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Map map = new Map();
    private Loader loader = new Loader();
    private Inventar inventar = new Inventar();
    /**
     * Inicializace herní konzole, načtení itemů, postav a mapy.
     */
    public void initialization() {
        loader.loadItems();
        loader.loadCharacters();
        map.loadMap();

        commands.put("jdi", new Jdi(map,inventar));
        commands.put("konec", new Konec(this));
        commands.put("vezmi", new Vezmi(inventar, loader.getItems(), map));
        commands.put("poloz", new Poloz(inventar));
        Pouzij pouzij = new Pouzij(inventar, loader.getItems(), map);
        commands.put("pouzij", pouzij);
        commands.put("mluv", new Mluv(loader.getCharacters(), map, inventar, loader.getItems(),pouzij));
        commands.put("prozkoumej", new Prozkoumej(map, loader.getItems(), loader.getCharacters()));
        commands.put("inventar", inventar);
        commands.put("pomoc", new Pomoc(commands));
        commands.put("napoveda", new Napoveda());
    }
    /**
     * Provádí zpracování a vykonání příkazu na základě uživatelského vstupu.
     */
    public void run() {
        System.out.print(">> ");
        String input = sc.next().toLowerCase().trim();

        if (commands.containsKey(input)) {
            String result = commands.get(input).execute();
            System.out.println(">> " + result);

            if (commands.get(input).exit()) {
                exit = true;
            }
        } else {
            System.out.println(">> Neznámý příkaz");
        }
    }
    /**
     * Spustí hlavní smyčku hry.
     */
    public void start() {
        initialization();
        try {
            do {
                run();
            } while (!exit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.util.HashMap;
import java.util.Scanner;

/**
 * Třída pro příkaz "Mluvit" ve hře.
 *
 * Tento příkaz umožňuje hráči mluvit s postavami, které se nacházejí v jeho aktuální lokaci.
 *
 * @autor Dominik Svoboda
 */
public class Mluv implements Command {
    private HashMap<String, Character> characters;
    private Map map;

    /**
     * Konstruktor třídy Mluv.
     *
     * @param characters Mapa všech postav ve hře.
     * @param map Mapa, která obsahuje aktuální pozici hráče.
     */
    public Mluv(HashMap<String, Character> characters, Map map) {
        this.characters = characters;
        this.map = map;
    }

    /**
     * Metoda pro provedení příkazu mluvit.
     *
     * Umožňuje hráči zadat jméno postavy, se kterou chce mluvit, a ověřuje,
     * zda je postava v aktuální lokaci hráče.
     *
     * @return Textová zpráva, která popisuje výsledek pokusu o mluvení s postavou.
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("S kým chceš mluvit?: ");
        String characterName = sc.nextLine().trim().toLowerCase();

        if (characters.containsKey(characterName)) {
            Character character = characters.get(characterName);
            int currentLocation = map.getPosition();

            if (character.getLocation() == currentLocation) {
                return "Mluvíš s " + character.getName() + ".";
            } else {
                return "Tato postava zde není.";
            }
        }
        return "Tuto postavu neznáš.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

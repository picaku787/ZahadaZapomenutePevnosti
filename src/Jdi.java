
import java.util.Scanner;

/**
 * Třída pro pohyb hráče mezi místnostmi.
 *
 * @autor Dominik Svoboda
 */
public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();
    private Inventar inventar;

    /**
     * Konstruktor pro příkaz "Jdi", který nastavuje mapu a inventář.
     *
     * @param map Mapa, která definuje herní prostředí
     * @param inventar Inventář hráče
     */
    public Jdi(Map map, Inventar inventar) {
        this.map = map;
        this.inventar = inventar;
    }

    /**
     * Provádí příkaz pro pohyb hráče mezi místnostmi.
     *
     * @return Výsledek pohybu
     */
    @Override
    public String execute() {
        int currentID = map.getPosition();
        currentLocation = map.getCurrentLocation(currentID);
        System.out.println("Jste na místě: " + currentLocation);
        System.out.println("Dostupná místa: " + currentLocation.getLocations());
        System.out.println("Zadejte ID cílového místa:");
        System.out.println(">>");
        try {
            int input = sc.nextInt();
            int targetID = input;

            if (!map.getMap().containsKey(targetID)) {
                return "Místo neexistuje.";
            }

            targetLocation = map.getMap().get(targetID);

            if (targetLocation.isLocked()) {
                return "Místo je zamčeno.";
            }

            if (currentLocation.getLocations().contains(targetID)) {
                map.setPosition(targetID);

                if (targetID == 8) {
                    for (Item item : inventar.items) {
                        if (item.getName().equalsIgnoreCase("Srdce Draka")) {
                            System.out.println("Vyhrál jsi! Hra končí...");
                            System.exit(0);
                        }
                    }
                    return "Nemůžeš zde vyhrát, chybí ti předmět 'Srdce Draka'.";
                }

                return "Přesunuto na " + targetLocation.getName();
            } else {
                return "Tam se nemůžete přesunout.";
            }
        } catch (Exception e) {
            System.out.println("Neplatný vstup.");
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
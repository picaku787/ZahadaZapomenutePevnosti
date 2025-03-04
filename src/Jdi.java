import java.util.Scanner;

public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();

    public Jdi(Map map) {
        this.map = map;
    }

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

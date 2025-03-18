import java.util.HashMap;
import java.util.Scanner;

public class Mluv implements Command {
    private HashMap<String, Character> characters;
    private int currentLocation;

    public Mluv(HashMap<String, Character> characters, int currentLocation) {
        this.characters = characters;
        this.currentLocation = currentLocation;
    }

    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("S kým chceš mluvit?: ");
        String characterName = sc.nextLine().trim().toLowerCase();

        if (characters.containsKey(characterName)) {
            Character character = characters.get(characterName);
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

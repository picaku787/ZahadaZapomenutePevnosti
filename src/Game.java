import java.util.*;

public class Game {
    private Map gameMap;
    private int currentLocation;
    private Scanner scanner;

    public Game() {
        gameMap = new Map();
        gameMap.loadMap();
        currentLocation = 1;
        scanner = new Scanner(System.in);
    }

    public void play() {
        while (true) {
            Location location = gameMap.getLocation(currentLocation);
            System.out.println("You are in: " + location.getName());
            System.out.println("Connected locations: " + location.getConnections());

            System.out.print("Enter the ID of the location you want to move to ");
            int choice = scanner.nextInt();
            if (location.getConnections().contains(choice)) {
                Location nextLocation = gameMap.getLocation(choice);
                if (nextLocation.isLocked()) {
                    System.out.println("The location is locked! You cannot enter.");
                } else {
                    currentLocation = choice;
                }
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
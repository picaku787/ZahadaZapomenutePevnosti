import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Map map = new Map();

    public void initialization() {
        commands.put("jdi", new Jdi(map));
        commands.put("konec", new Konec(this));
    }

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

    public void start() {
        initialization();
        map.loadMap();
        try {
            do {
                run();
            } while (!exit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
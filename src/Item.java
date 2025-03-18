public class Item {
    private int id;
    private String name;
    private int location;
    private int useLocation;
    private boolean canTake;

    public Item(int id, String name, int location, int useLocation, boolean canTake) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.useLocation = useLocation;
        this.canTake = canTake;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getLocation() { return location; }
    public int getUseLocation() { return useLocation; }
    public boolean isCanTake() { return canTake; }

    public void setLocation(int location) {
        this.location = location;
    }
}
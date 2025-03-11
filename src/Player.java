public class Player {
    public String name;
    private Inventar inventar;
    private Location location;

    public Inventar getInventar() {
        return inventar;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

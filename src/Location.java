import java.util.ArrayList;

class Location {
    private int id;
    private String name;
    private ArrayList<Integer> connections;
    private boolean locked;

    public Location(int id, String name, ArrayList<Integer> connections, boolean locked) {
        this.id = id;
        this.name = name;
        this.connections = connections;
        this.locked = locked;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", connections=" + connections +
                ", locked=" + locked +
                '}';
    }
}
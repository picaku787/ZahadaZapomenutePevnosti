public class Character {
    private String name;
    private int location;
    private int wantedItem;
    private int givenItem;

    public Character(String name, int location, int wantedItem, int givenItem) {
        this.name = name;
        this.location = location;
        this.wantedItem = wantedItem;
        this.givenItem = givenItem;
    }

    public String getName() { return name; }
    public int getLocation() { return location; }
    public int getWantedItem() { return wantedItem; }
    public int getGivenItem() { return givenItem; }
}

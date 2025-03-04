public class Main {
    public static void main(String[] args) {
        Map m=new Map();
        System.out.println(m.loadMap());
        System.out.println(m.getLocation(2));
        System.out.println(m.getLocation(8));
        Game g=new Game();
        g.play();

    }
}
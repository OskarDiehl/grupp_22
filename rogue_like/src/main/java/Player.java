public class Player extends Character {

    // INSTANCE VARIABLES
    private String role;

    // CONSTRUCTOR
    public Player(String name, Element element, String role) {
        super(name, element);
        this.role = role;
        super.stats = new Stats();
    }

    // GET-METHODS
    public String getRole() {
        return role;
    }
}

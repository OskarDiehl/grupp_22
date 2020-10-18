public class Player extends Character {

    // INSTANCE VARIABLES
    private String role;

    // CONSTRUCTOR
    public Player(String name, Element element, String role) {
        super(name, element);
        //stats = new Stats();
        this.role = role;
    }

    // GET-METHODS
    public String getRole() {
        return role;
    }
}

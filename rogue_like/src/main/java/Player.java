public class Player extends Character {

    // datasamling med element

    // INSTANCE VARIABLES ---------------------------------------------------
    private String role;
    //selected element TODO fixa selected element /Malin


    // CONSTRUCTOR ----------------------------------------------------------
    public Player(String name, Element element, String role) {
        super(name, element);
        //stats = new Stats();
        this.role = role;
    }

    // OTHER METHODS
    public void levelUp() {
        if (level < 3){
            level++;
            levelUpChangeStats();
        } else {
            throw new IllegalStateException("Level 3 is the highest level that you can reach.");
        }
    }

    public void levelUpChangeStats(){

    }

    // GET-METHODS ----------------------------------------------------------
    public String getRole() {
        return role;
    }


}

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

    // GET-METHODS ----------------------------------------------------------
    public String getRole() {
        return role;
    }

    @Override
    public void levelUpChangeStats(){
        //TODO skapa metoden /Malin
    }

}

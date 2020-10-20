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




    //Oskar här! Tänker att det kan vara bra att ha en metod som samlar stats från de olika items som spelaren har.
    //Kommenterar bort metoden nu i alla fall så att den inte stör med det du gör.
    /*public int getItemPower() {
        int itemPower = 7; //7 är en placeholder tills vi kan hämta power från items.
        return itemPower;
    }*/

}

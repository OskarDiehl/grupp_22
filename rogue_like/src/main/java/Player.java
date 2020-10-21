
public class Player extends Character {

    // DATASAMLING/-AR -----------------------------------------------------
    // datasamling med element  -> Array
    // datasamling för items    -> Array

    //Alla elementen har olika index. ArrayLocation? Om det finns lägg in vatten element
    //Tar man ett Item börjar det verka direkt  /Vapen, rustning, skor

    // INSTANCE VARIABLES ---------------------------------------------------
    private int currentLevel = 1;
    private Role role;
    //selected element TODO fixa selected element /Malin


    // CONSTRUCTOR ----------------------------------------------------------
    public Player(String name, Element element, Role role) {
        super(name, element);
       // this.level = getCurrentLevel();   TODO Fråga Sabina /Malin
        this.role = role;
        stats = new Stats(role.getLife(),role.getPower(),role.getSpeed());
    }

    // OTHER METHODS --------------------------------------------------------
    public void levelUp() {
        if (currentLevel < 3){
            currentLevel++;
            levelUpChangeStats();
        } else {
            throw new IllegalStateException("Level 3 is the highest level that you can reach.");
        }
    }

    public void levelUpChangeStats(){ //TODO Fixa metod som förändrar stats när man levlar upp.

    }

    //metod som ger elementen

    private Stats getCurrentLevelStats() {  //TODO Ta en till titt här Malin. Hur hämtar man stats:en? /Malin
        return stats;
    }

    // GET-METHODS ----------------------------------------------------------
    public Role getRole() {
        return role;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    //get-metoder för stats:en

}




//Oskar här! Tänker att det kan vara bra att ha en metod som samlar stats från de olika items som spelaren har.
    //Kommenterar bort metoderna nu i alla fall så att den inte stör med det du gör.
    /*public int getItemPower() {
        int itemPower = 7; //7 är en placeholder tills vi kan hämta power från items.
        return itemPower;
    }

    public int getItemSpeed() {
        int itemSpeed = 5; //Placeholder
        return itemSpeed;
    }

    public int getItemHP() {
        int itemHP = 3;
        return itemHP;
    }*/


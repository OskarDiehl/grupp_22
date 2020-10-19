public class Player extends Character {

    // DATASAMLING/-AR -----------------------------------------------------
    // datasamling med element

    // INSTANCE VARIABLES ---------------------------------------------------
    private int currentLevel = 1;
    private Role role;
    //selected element TODO fixa selected element /Malin


    // CONSTRUCTOR ----------------------------------------------------------
    public Player(String name, Element element, Role role) {
        super(name, element);
        super.level = getCurrentLevel();
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
}

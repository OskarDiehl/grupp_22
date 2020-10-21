public class Stats {

    //VARIABLES  ------------------------------------------------------------------------
    private static final int MAX_STAT = 10;                 //Stats can have a maximum value of 10
    private static final int MIN_STAT = 0;                  //Stats can have a minimum value of 0
    private int maxHP; //TODO är det här bra? /Sabina
    private int currentHP;
    private final int power;
    private final int speed;

    // CONSTRUCTOR  ------------------------------------------------------------------------

    public Stats(int HP, int power, int speed) {
        if (isWithinStatRange(HP) && isWithinStatRange(power) && isWithinStatRange(speed)) {
            this.maxHP = HP;
            this.currentHP = HP;
            this.power = power;
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Error: Parameters out of range");
        }
    }


    // OTHER METHODS  ------------------------------------------------------------------------

    private boolean isWithinStatRange(int number) {
        return number >= MIN_STAT && number <= MAX_STAT;
    }

    public void loseLives(int lostLives) {
        if ((currentHP - lostLives) < 0)  //TODO ska vi ersätta med Math.max? /Malin
            currentHP = 0; //TODO -> Spelet startas om? -> PlayerStats? /Malin
        else
            currentHP = currentHP - lostLives;
    }

    public void gainLives(int gainedLives) {
        if ((currentHP + gainedLives) <= maxHP) //TODO ändra så att maxgränsen stämmer överens /Malin
            currentHP = currentHP + gainedLives;
    }

    public void attackedByAnEnemy(int lostLives) {
        loseLives(lostLives); //TODO Nu kan man göra loseLives till en privat metod. Men då kommer inte testen åt dem.. /Malin
    }


    // GET-METHODS ------------------------------------------------------------------------
    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }


    // TO-STRING-METHOD ------------------------------------------------------------------------
    @Override
    public String toString() {
        return "HP: " + getCurrentHP() + "\nPower: " + getPower() + "\nSpeed: " + getSpeed();
    }


}

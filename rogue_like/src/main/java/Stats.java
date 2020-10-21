public class Stats {

    //VARIABLES  ------------------------------------------------------------------------
    private static final int MAX_STAT = 10;                 //Stats can have a maximum value of 10
    private static final int MIN_STAT = 0;                  //Stats can have a minimum value of 0
    private int defaultHP; //TODO är det här bra? /Sabina
    private int currentHP;
    private final int defaultPower;
    private final int defaultSpeed;

    // CONSTRUCTOR  ------------------------------------------------------------------------

    public Stats(int defaultHP, int defaultPower, int defaultSpeed) {
        if (isWithinStatRange(defaultHP) && isWithinStatRange(defaultPower) && isWithinStatRange(defaultSpeed)) {
            this.defaultHP = defaultHP;
            this.currentHP = defaultHP;
            this.defaultPower = defaultPower;
            this.defaultSpeed = defaultSpeed;
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
        if ((currentHP + gainedLives) <= defaultHP) //TODO ändra så att maxgränsen stämmer överens /Malin
            currentHP = currentHP + gainedLives;
    }

    public void attackedByAnEnemy(int lostLives) {
        loseLives(lostLives); //TODO Nu kan man göra loseLives till en privat metod. Men då kommer inte testen åt dem.. /Malin
    }


    // GET-METHODS ------------------------------------------------------------------------
    public int getDefaultHP() {
        return defaultHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getDefaultPower() {
        return defaultPower;
    }

    public int getDefaultSpeed() {
        return defaultSpeed;
    }

    public static int getMaxStat() {
        return MAX_STAT;
    }

    public static int getMinStat() {
        return MIN_STAT;
    }

    // TO-STRING-METHOD ------------------------------------------------------------------------
    @Override
    public String toString() {
        return "HP: " + getCurrentHP() + "\nPower: " + getDefaultPower() + "\nSpeed: " + getDefaultSpeed();
    }


}

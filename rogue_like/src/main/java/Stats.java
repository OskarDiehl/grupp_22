public class Stats {

    //VARIABLES  ------------------------------------------------------------------------
    private static final int MAX_STAT = 10;                 //Stats can have a maximum value of 10
    private static final int MIN_STAT = 0;                  //Stats can have a minimum value of 0
    private int defaultHP; //TODO är det här bra? /Sabina
    private int currentHP;
    private int defaultPower;   // TODO Jag gjorde defaultPower och -Speed till icke-final för att kunna levla upp dem i metoden "levelUp". Om det är okej med dig Sabina kan du ta bort den här metoden <3<3 /Malin
    private int defaultSpeed;

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

    public void loseHP(int lostHP) {
        if ((currentHP - lostHP) >= 0)               //TODO ska vi ersätta med Math.max? /Malin
            currentHP = currentHP - lostHP;          //TODO -> Spelet startas om? -> PlayerStats? /Malin
        else
            currentHP = MIN_STAT;
    }

    public void gainHP(int gainedHP) {
        int max = defaultHP;
        if ((currentHP + gainedHP) <= max)     //TODO ändra så att maxgränsen stämmer överens /Malin
            currentHP = currentHP + gainedHP;
        else
            currentHP = defaultHP;
    }

    public void attackedByAnEnemy(int lostLives) { //TODO flytta denna till Player alt. ta bort? /Sabina
        loseHP(lostLives);                           //TODO Nu kan man göra loseLives till en privat metod. Men då kommer inte testen åt dem.. /Malin
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


    public void levelUp(int amount) {
        levelUpDefaultHP(amount);
        levelUpDefaultPower(amount);
        levelUpDefaultSpeed(amount);
    }

    private void levelUpDefaultHP(int amount){
        if ((defaultHP + amount) <= MAX_STAT)
            defaultHP = defaultHP + amount;
        else
            defaultHP = MAX_STAT;
    }

    private void levelUpDefaultPower(int amount){
        if((defaultPower + amount) <= MAX_STAT)
            defaultPower = defaultPower + amount;
        else
            defaultPower = MAX_STAT;
    }

    private void levelUpDefaultSpeed(int amount){
        if ((defaultSpeed + amount) <= MAX_STAT)
            defaultSpeed = defaultSpeed + amount;
        else
            defaultSpeed = MAX_STAT;
    }

}

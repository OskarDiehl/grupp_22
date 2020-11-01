public class Stats {

    //VARIABLES  -------------------------------------------------------------------------------------------------------
    private static final int MAX_STAT = 10;                 //Stats can have a maximum value of 10
    private static final int MIN_STAT = 0;                  //Stats can have a minimum value of 0
    private int defaultHP;
    private int currentHP;
    private int defaultPower;
    private int defaultSpeed;

    // CONSTRUCTOR  ----------------------------------------------------------------------------------------------------

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


    // OTHER METHODS  --------------------------------------------------------------------------------------------------

    private boolean isWithinStatRange(int number) {
        return number >= MIN_STAT && number <= MAX_STAT;
    }

    public void loseHP(int lostHP) {
        if ((currentHP - lostHP) >= MIN_STAT)
            currentHP = currentHP - lostHP;          //TODO -> Spelet startas om? -> PlayerStats? /Malin
        else
            currentHP = MIN_STAT;
    }

    public void gainHP(int gainedHP) {
        if ((currentHP + gainedHP) <= defaultHP)
            currentHP = currentHP + gainedHP;
        else
            currentHP = defaultHP;
    }

    public void changeCurrentHP(int hp) {               //Increases or decreases the HP temporarily
        int totalHP = currentHP + hp;
        if (totalHP > defaultHP)
            currentHP = defaultHP;
        else if (totalHP < MIN_STAT)
            currentHP = MIN_STAT;
        else
            currentHP = currentHP + hp;
    }


    // METHODS THAT INCREASE THE DEFAULT STATS -------------------------------------------------------------------------
    public void levelUpTheDefaultStats(int amount) {                //When the character levels up the default stats increases
        levelUpDefaultHP(amount);
        levelUpDefaultPower(amount);
        levelUpDefaultSpeed(amount);
    }

    private void levelUpDefaultHP(int amount){                      //Increases the default HP
        if ((defaultHP + amount) <= MAX_STAT)
            defaultHP = defaultHP + amount;
        else
            defaultHP = MAX_STAT;
    }

    private void levelUpDefaultPower(int amount){                  //Increases the default power
        if((defaultPower + amount) <= MAX_STAT)
            defaultPower = defaultPower + amount;
        else
            defaultPower = MAX_STAT;
    }

    private void levelUpDefaultSpeed(int amount){                   //Increases the default Speed
        if ((defaultSpeed + amount) <= MAX_STAT)
            defaultSpeed = defaultSpeed + amount;
        else
            defaultSpeed = MAX_STAT;
    }


    // GET-METHODS -----------------------------------------------------------------------------------------------------
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

    // TO-STRING-METHOD ------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "HP: " + getCurrentHP() + "\nPower: " + getDefaultPower() + "\nSpeed: " + getDefaultSpeed();
    }
}

public class Stats {
    //TODO Stats kan vara max 10.

    //VARIABLES  ------------------------------------------------------------------------
    private static final int MAX_STAT = 10;
    private static final int MIN_STAT = 1;
    private int maxLife; //TODO är det här bra? /Sabina
    private int currentLife;
    private int power;
    private int speed;

    // CONSTRUCTORS  ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role. The "standard constructor".
    //TODO Denna konstruktor är ej anpassad för bossar, ska all generering av själva statsen kanske ske i Player- resp Enemy- resp Boss-klassen?
    public Stats(int level){
        int statThing;
        if (level == 1) {               // Depending on the level, the default stats change
            statThing = 3;
        } else if (level == 2){
            statThing = 5;
        } else {
            statThing = 8;
        }
        currentLife = statThing;        // Life, power and speed have the same stat TODO (Up for debate, this can be changed) /Malin & Sabina
        power = statThing;
        speed = statThing;
        maxLife = statThing;
    }

    //Constructor for character WITH a role. The "role constructor".
    public Stats(int life, int power, int speed){
        if (isWithinStatRange(life) && isWithinStatRange(power) && isWithinStatRange(speed)) {
            this.maxLife = life;
            this.currentLife = life;
            this.power = power;
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Error: Parameters out of range");
        }
    }


    // OTHER METHODS  ------------------------------------------------------------------------

    private boolean isWithinStatRange(int number) {
        if (number < MIN_STAT || number > MAX_STAT){
            return false;
        } else {
            return true;
        }
    }
    public void loseLives(int lostLives) {
        if ((currentLife - lostLives) < 0)  //TODO ska vi ersätta med Math.max? /Malin
            currentLife = 0;
        else
            currentLife = currentLife - lostLives;
    }

    public void gainLives(int gainedLives) {
        if ((currentLife + gainedLives) <= maxLife) //TODO ändra så att maxgränsen stämmer överens /Malin
            currentLife = currentLife + gainedLives;
    }

    public void attackedByAnEnemy(int lostLives) {
        loseLives(lostLives); //TODO Nu kan man göra loseLives till en privat metod. Men då kommer inte testen åt dem.. /Malin
    }


    // GET-METHODS ------------------------------------------------------------------------
    public int getMaxLife() {
        return maxLife;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }


    // TO-STRING-METHOD ------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Life: " + getCurrentLife() + "\nPower: " + getPower() + "\nSpeed: " + getSpeed();
    }


}

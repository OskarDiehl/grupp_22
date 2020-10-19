public class Stats {
    //TODO Stats kan vara max 10.

    //VARIABLES  ------------------------------------------------------------------------
    private static final int MAX_STAT = 10;
    private static final int MIN_STAT = 1;
    private int maxLife; //TODO är det här bra? /Sabina
    private int currentLife;
    private int power;
    private int speed;

    // CONSTRUCTOR  ------------------------------------------------------------------------

    public Stats(int life, int power, int speed) {
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
        if (number < MIN_STAT || number > MAX_STAT) {
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
    public String toString() {
        return "Life: " + getCurrentLife() + "\nPower: " + getPower() + "\nSpeed: " + getSpeed();
    }


}

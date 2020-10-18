public class Stats {
    //TODO Stats kan vara max 10.

    //VARIABLES  ------------------------------------------------------------------------
    private static final int MAX_STAT = 10;
    private static final int MIN_STAT = 1;
    private int maxLife; //TODO är det här bra? /Sabina
    private int life;
    private int power;
    private int speed;

    // CONSTRUCTORS  ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role. The "standard constructor".
    public Stats(int level){
        int statThing = 0;
        if (level == 1) {
            statThing = 3;
        } else if (level == 2){
            statThing = 5;
        } else {
            statThing = 7;
        }
        life = statThing;
        power = statThing;
        speed = statThing;
    }

    //Constructor for character WITH a role. The "role constructor".
    public Stats(int life, int power, int speed){
        if (isWithinStatRange(life) && isWithinStatRange(power) && isWithinStatRange(speed)) {
            this.life = life;
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
        if ((life - lostLives) < 0)  //TODO ska vi ersätta med Math.max? /Malin
            life = 0;
        else
            life = life - lostLives;
    }

    public void gainLives(int gainedLives) {
        if ((life + gainedLives) <= MAX_STAT) //TODO ändra så att maxgränsen stämmer överens /Malin
            life = life + gainedLives;
    }

    public void decreasePower(int lostPower) {
        power = power - lostPower;
    }

    public void attackedByAnEnemy(int lostLives) {
        loseLives(lostLives); //TODO Nu kan man göra loseLives till en privat metod. Men då kommer inte testen åt dem.. /Malin
    }


    // GET-METHODS ------------------------------------------------------------------------
    public int getLife() {
        return life;
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
        return "Life: " + getLife() + "\nPower: " + getPower() + "\nSpeed: " + getSpeed();
    }
}

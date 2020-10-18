public class Stats {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private int life;
    private int power;
    private int speed;


    // CONSTRUCTORS  ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role. The "standard constructor".
    public Stats(){
        life = 10;
        power = 10;
        speed = 10;
    }

    //Constructor for character WITH a role. The "role constructor".
    public Stats(int life, int power, int speed){
        this.life = life;
        this.power = power;
        this.speed = speed;
    }


    // OTHER METHODS  ------------------------------------------------------------------------
    public void looseLifes(int lostLifes) {
        if ((life - lostLifes) < 0)  //TODO ska vi ersätta med Math.max? /Malin
            life = 0;
        else
            life = life - lostLifes;
    }

    public void gainLifes(int gainedLifes) {
        if ((life + gainedLifes) <= 10) //TODO ändra så att maxgränsen stämmer överens /Malin
            life = life + gainedLifes;
    }

    public void decreasePower(int lostPower) {
        power = power - lostPower;
    }

    public void attackEnemy(int lostPower) {
        decreasePower(lostPower);
    }

    public void attackedByAnEnemy(int lostLifes, int lostPower) {
        looseLifes(lostLifes);
        decreasePower(lostPower);  //TODO Nu kan man göra looseLifes och decreasePower till privata metoder. Men då kommer inte testen åt dem.. /Malin
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

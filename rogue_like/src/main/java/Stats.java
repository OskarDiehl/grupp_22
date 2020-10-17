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

    public void decreasePower(int lostPower) {
        power = power - lostPower;
    }

    public void gainLifes(int gainedLifes) {
        if ((life + gainedLifes) <= 10)
            life = life + gainedLifes;
    }


    // GET-METHODS  ------------------------------------------------------------------------
    public int getLife() {
        return life;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }



}

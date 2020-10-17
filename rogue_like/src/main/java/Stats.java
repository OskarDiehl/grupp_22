public class Stats {

    // INSTANCE VARIABLES
    private int life;
    private int power;
    private int speed;

    // CONSTRUCTOR
    public Stats(){
        life = 10;
        power = 10;
        speed = 10;
    }

    // OTHER METHODS
    public void looseLives(int lostLives) {
        life = life - lostLives;
    }

    public void decreasePower(int lostPower) {
        power = power - lostPower;
    }

    // GET-METHODS
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

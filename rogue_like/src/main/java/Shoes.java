public class Shoes  extends Item{

    int speed;
    int power;

    public Shoes(String name, int speed, int power) {
        super(name);
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }

}

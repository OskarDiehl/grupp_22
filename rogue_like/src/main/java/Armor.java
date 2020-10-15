public class Armor extends Item {

    private int hp;
    private int speed;

    public Armor(String name, int hp, int speed) {
        super(name);
        this.hp = hp;
        this.speed = speed;
    }

    public int getHP() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }
}

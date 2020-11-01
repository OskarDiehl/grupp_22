public class Weapon extends Item{

    int power;
    int hp;

    public Weapon(String name,int power, int hp) {
        super(name);
        this.power = power;
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public int getHP() {
        return hp;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

}

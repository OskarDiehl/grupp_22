public class Boss extends Enemy{

    public Boss(String name, Element element, int level) {
        super(name, element, level);
        calculateStats(level);
    }

    @Override
    protected void calculateStats(int level) {
        int life;
        int power;
        int speed;
        if (level == 1) {               // Depending on the level, the default stats change
            life = 5;
            power = 4;
            speed = 4;
        } else if (level == 2){
            life = 7;
            power = 6;
            speed = 6;
        } else {
            life = 10;
            power = 9;
            speed = 9;
        }
        generateStats(life, power, speed);
    }
}

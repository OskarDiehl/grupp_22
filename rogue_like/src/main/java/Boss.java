public class Boss extends Enemy {

    public Boss(Element element, int level, Room room) {
        super(element, level, room);
        calculateStats(level);
    }

    private void calculateStats(int level) {
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

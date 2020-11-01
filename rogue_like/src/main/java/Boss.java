public class Boss extends Enemy {
    private final static int LEVEL_1_STAT = 4;
    private final static int LEVEL_2_STAT = 6;
    private final static int LEVEL_3_STAT = 9;

    public Boss(Element element, int level, Room room) {
        super(element, level, room);
        calculateStats(super.getLevel());
    }

    private void calculateStats(int level) {
        int life;
        int power;
        int speed; // Depending on the level, the default stats change
        switch (level) {
            case 1:
                life = 5;
                power = 4;
                speed = 4;
            break;
            case 2:
                life = 7;
                power = 6;
                speed = 6;
            break;
            case 3:
                life = 10;
                power = 9;
                speed = 9;
                break;
            default:
                return;
        }
        generateStats(life, power, speed);
    }
}

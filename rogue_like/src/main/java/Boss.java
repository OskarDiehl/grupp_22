public class Boss extends Enemy {
    private final static int LEVEL_1_STAT = 4;
    private final static int LEVEL_2_STAT = 6;
    private final static int LEVEL_3_STAT = 9;

    public Boss(Element element, int level, Room room) { //The Boss constructor is the same as the Enemy constructor
        super(element, level, room);
        calculateStats(super.getLevel());
    }

    private void calculateStats(int level) { // Depending on the level, the default stats change
        int statForLevel;
        if (level == 1)
            statForLevel = LEVEL_1_STAT;
        else if (level == 2)
            statForLevel = LEVEL_2_STAT;
        else
            statForLevel = LEVEL_3_STAT;
        generateStats(statForLevel);
    }
}

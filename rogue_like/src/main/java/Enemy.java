public class Enemy extends Character {
    private final static int LEVEL_1_STAT = 3;
    private final static int LEVEL_2_STAT = 5;
    private final static int LEVEL_3_STAT = 8;

    public Enemy(String name, Element element, int level) {
        super(name, element);
        this.level = level;
        generateStats(level);
    }

    protected void generateStats(int level) {
        int statForLevel;
        if (level == 1) {               // Depending on the level, the default stats change
            statForLevel = LEVEL_1_STAT;
        } else if (level == 2){
            statForLevel = LEVEL_2_STAT;
        } else {
            statForLevel = LEVEL_3_STAT;
        }
        stats = new Stats(statForLevel, statForLevel, statForLevel);
    }

}

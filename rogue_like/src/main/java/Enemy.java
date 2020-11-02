public class Enemy extends Character {

    private final static int LEVEL_1_STAT = 3;
    private final static int LEVEL_2_STAT = 5;
    private final static int LEVEL_3_STAT = 8;

    private final Room room;
    private Stats stats;


    public Enemy(Element mainElement, int level, Room room) { //Aside from the Character constructor, this constructor accepts a Room parameter and calculates an enemy's stats
        super(mainElement, level);
        this.room = room;
        calculateStats(super.getLevel());
    }

    private void calculateStats(int level) { // Depending on the level, the default stats change
        int statForLevel;
        if (level == 1) {
            statForLevel = LEVEL_1_STAT;
        } else if (level == 2){
            statForLevel = LEVEL_2_STAT;
        } else {
            statForLevel = LEVEL_3_STAT;
        }
        generateStats(statForLevel);
    }

    protected void generateStats(int stat) { //Bara en parameter?
        stats = new Stats(stat, stat, stat);
    }

    @Override
    public void attack(Character character) {
        if (character instanceof Player) {
            int attackPower = getMainElement().attack(getPower(), character.getMainElement());
            character.getStats().loseHP(attackPower);
        } else {
            throw new ClassCastException();
        }
    }

    public boolean isDead() {
        return getCurrentHP() <= 0;
    }

    public void removeIfDead() {
        if (isDead())
            room.removeEnemy(this);
    }

    @Override
    public Stats getStats() {
        return stats;
    }

    public int getCurrentHP() {
        return stats.getCurrentHP();
    }

    public int getDefaultHP() {
        return stats.getDefaultHP();
    }

    public int getPower() {
        return stats.getDefaultPower();
    }

    public int getSpeed() {
        return stats.getDefaultSpeed();
    }

    public Room getRoom() {
        return room;
    }
}

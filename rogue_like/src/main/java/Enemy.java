public class Enemy extends Character {
    private final static int LEVEL_1_STAT = 3;
    private final static int LEVEL_2_STAT = 5;
    private final static int LEVEL_3_STAT = 8;

    private Stats stats;     //TODO Jag deklarerade stats här för dig istället för att få koden att kompilera /Malin

    public Enemy(Element element, int level) {
        super(element, level);
        calculateStats(level);
    }

    void calculateStats(int level) { // Depending on the level, the default stats change
        int statForLevel;
        if (level == 1) {
            statForLevel = LEVEL_1_STAT;
        } else if (level == 2){
            statForLevel = LEVEL_2_STAT;
        } else {
            statForLevel = LEVEL_3_STAT;
        }
        generateStats(statForLevel, statForLevel, statForLevel);
    }

    void generateStats(int life, int power, int speed) {
        stats = new Stats(life, power, speed);
    }

    public void move() {
        //Jag är lite lost i hur en enemy ska röra sig
    }

    public void attack(Player player) {
        getElement().attack(player.getElement()); //jag är ganska allmänt lost
    }

    public Stats getStats() {
        return stats;
    }
}

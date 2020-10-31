import org.jetbrains.annotations.NotNull;

public class Enemy extends Character {

    private final static int LEVEL_1_STAT = 3;
    private final static int LEVEL_2_STAT = 5;
    private final static int LEVEL_3_STAT = 8;

    private EnemyStats stats;
    private Room room;

    public Enemy(Element mainElement, int level, Room room) {       //TODO Jag döpte om element till mainElement för att hålla reda på vad som är vad. Hoppas att det är okej. Hojta till annars! /Malin
        super(mainElement, level);
        this.room = room;
        calculateStats(level);
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
        generateStats(statForLevel, statForLevel, statForLevel);
    }

    void generateStats(int life, int power, int speed) {
        stats = new EnemyStats(life, power, speed);
    }

    public void attack(Player player) { //TODO gör något åt den höga couplingen vi har, kanske flytta all attackberäkning till Character?
        int attackPower = getMainElement().attack(getPower(), player.getMainElement());
        player.getPlayerStats().loseHP(attackPower);
    }

    public boolean isDead() {
        return getStats().getCurrentHP() <= 0;
    }

    public void removeIfDead() {
        if (isDead())
            room.removeEnemy(this);
    }

    public EnemyStats getStats() {
        return stats;
    }

    public int getHP() {
        return getStats().getCurrentHP();
    }

    public int getPower() {
        return getStats().getDefaultPower();
    }

    public int getSpeed() {
        return getStats().getDefaultSpeed();
    }

    public Room getRoom() {
        return room;
    }
}

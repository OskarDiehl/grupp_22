import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    void getElementFromConstructorArgument() {
        Element element = new FireElement(2);
        Character character = new Enemy(element, 2, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(element, character.getMainElement());
    }

    @Test
    void getLevelFromConstructorArgument() {
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(2, enemy.getLevel());
    }
    
    @Test
    void getIAEFromIllegalLevelConstructorArgument() {
        assertThrows(IllegalArgumentException.class, () -> {new Enemy(new FireElement(2), 4, new Room(new Player("Test", new FireElement(1), Role.Tank))); });
    }

    @Test
    void getRoomFromConstructorArgument() {
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank));
        Enemy enemy = new Enemy(new FireElement(2), 2, room);
        assertEquals(room, enemy.getRoom());
    }

    @Test
    void generateEnemyStatsForLevel1(){
        Stats stats = new Stats(3, 3, 3);
        Enemy enemy = new Enemy(new FireElement(2), 1, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void generateEnemyStatsForLevel2(){
        Stats stats = new Stats(5, 5, 5);
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void generateEnemyStatsForLevel3(){
        Stats stats = new Stats(8, 8, 8);
        Enemy enemy = new Enemy(new FireElement(2), 3, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void getStatPowerThroughEnemy() {
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(5, enemy.getPower());
    }

    @Test
    void getStatHPThroughEnemy() {
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room(new Player("Malin", new FireElement(1), Role.Tank)));
        assertEquals(5, enemy.getHP());
    }

    @Test
    void getStatSpeedThroughEnemy() {
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room(new Player("Malin", new FireElement(1), Role.Tank)));
        assertEquals(5, enemy.getSpeed());
    }

    @Test
    void attackPlayer() {
        Player player = new Player("David", new WaterElement(1), Role.Tank);
        Enemy enemy = new Enemy(new FireElement(1), 2, new Room(player));
        enemy.attack(player);
        assertEquals(3, player.getCurrentHPFromStats());
    }

    @Test
    void throwCCEWhenParameterIsNotOfTypePlayer() {
        Enemy enemy = new Enemy(new FireElement(2), 2,
                new Room(new Player("Malin", new FireElement(1), Role.Tank)));
        Character notPlayer = new Enemy(new EarthElement(1), 1,
                new Room(new Player("Oskar", new WaterElement(1), Role.Warrior)));
        assertThrows(ClassCastException.class, () -> enemy.attack(notPlayer));
    }

    @Test
    void removeIfDeadWhenIsDead() {
        Room room = new Room(new Player("David", new FireElement(1), Role.Tank), "Enemy");
        Enemy enemy = room.getEnemies().get(0);
        int hp = enemy.getHP();
        enemy.getStats().loseHP(hp);
        enemy.removeIfDead();
        assertFalse(room.getEnemies().contains(enemy));
    }
}
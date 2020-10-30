import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    void getLevelFromConstructorArgument() {
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room());
        assertEquals(2, enemy.getLevel());
    }
    
    @Test
    void getIAEFromIllegalLevelConstructorArgument() {
        assertThrows(IllegalArgumentException.class, () -> new Enemy(new FireElement(2), 4, new Room()));
    }

    @Test
    void generateEnemyStatsForLevel1(){
        Stats stats = new Stats(3, 3, 3);
        Enemy enemy = new Enemy(new FireElement(2), 1, new Room());
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void generateEnemyStatsForLevel2(){
        Stats stats = new Stats(5, 5, 5);
        Enemy enemy = new Enemy(new FireElement(2), 2, new Room());
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void generateEnemyStatsForLevel3(){
        Stats stats = new Stats(8, 8, 8);
        Enemy enemy = new Enemy(new FireElement(2), 3, new Room());
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

//    @Test
//    void attackPlayer() { //TODO Implementera detta
//
//    }
}
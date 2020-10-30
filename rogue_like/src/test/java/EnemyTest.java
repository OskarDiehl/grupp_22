import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    void getLevelFromConstructorArgument() {
        Element element = new FireElement(3);
        Enemy enemy = new Enemy(element, 2);
        assertEquals(2, enemy.getLevel());
    }

    @Test
    void generateEnemyStatsForLevel1(){
        Element element = new FireElement(3);
        Stats stats = new Stats(3, 3, 3);
        Enemy enemy = new Enemy(element, 1);
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void generateEnemyStatsForLevel2(){
        Element element = new FireElement(3);
        Stats stats = new Stats(5, 5, 5);
        Enemy enemy = new Enemy(element, 2);
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

    @Test
    void generateEnemyStatsForLevel3(){
        Element element = new FireElement(3);
        Stats stats = new Stats(8, 8, 8);
        Enemy enemy = new Enemy(element, 3);
        assertEquals(stats.toString(), enemy.getStats().toString());
    }

//    @Test
//    void attackPlayer() { //TODO Implementera detta
//
//    }
}
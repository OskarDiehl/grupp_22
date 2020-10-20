import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    @Test
    void getLevelFromConstructorArgument() {
        Element element = new Element();
        Enemy enemy = new Enemy("EttNamn", element, 2);
        assertEquals(2, enemy.getLevel());
    }

    @Test
    void generateEnemyStats(){
        Element element = new Element();
        Stats stats = new Stats(5, 5, 5);
        Enemy enemy = new Enemy("EttNamn", element, 2);
        assertEquals(stats.toString(), enemy.getStats().toString());
    }



}
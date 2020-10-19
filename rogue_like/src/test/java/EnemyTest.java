import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    @Test
    void getLevelFromConstructorArgument() {
        Element element = new Element();
        Enemy enemy = new Enemy("EttNamn", element, 2);
        assertEquals(2, enemy.getLevel());
    }



}
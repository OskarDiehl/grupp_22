import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void getNameFromConstructorArgument() {
        Element element = new Element();
        Enemy character = new Enemy("Malin", element, 1);
        assertEquals("Malin", character.getName());
    }

    @Test
    void getElementFromConstructorArgument() {
        Element e = new Element();
        Enemy character = new Enemy("Malin", e, 1);
        assertEquals(e, character.getElement());
    }

    @Test
    void getLevelFromConstructorArgument() {
        Element element = new Element();
        Enemy enemy = new Enemy("EttNamn", element, 2);
        assertEquals(2, enemy.getLevel());
    }

    @Test
    void generateEnemyStats(){
        Element element = new Element();
        Stats stats = new Stats(2);
        Enemy enemy = new Enemy("EttNamn", element, 2);
        assertEquals(stats.toString(), enemy.getStats().toString());
    }



}
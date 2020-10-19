import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    @Test
    void generateBossStats() { //Själva statsen ska ändras
        Element element = new Element();
        Boss boss = new Boss("Boss", element, 3);
        assertEquals(new Stats(3).toString(), boss.getStats().toString());
    }

}
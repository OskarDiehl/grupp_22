import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    @Test
    void generateBossStats() { //Själva statsen ska ändras
        Element element = new FireElement(3);
        Boss boss = new Boss(element, 3);
        assertEquals(new Stats(10, 9, 9).toString(), boss.getStats().toString());
    }

}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    @Test
    void generateBossStats() { //Själva statsen ska ändras
        Boss boss = new Boss(new FireElement(3), 3, new Room());
        assertEquals(new Stats(10, 9, 9).toString(), boss.getStats().toString());
    }

}
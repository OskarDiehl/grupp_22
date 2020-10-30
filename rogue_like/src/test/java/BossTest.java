import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void generateBossStatsForLevelOne() { //Själva statsen ska ändras
        Boss boss = new Boss(new FireElement(3), 1, new Room());
        assertEquals(new Stats(5, 4, 4).toString(), boss.getStats().toString());
    }

    @Test
    void generateBossStatsForLevelTwo() { //Själva statsen ska ändras
        Boss boss = new Boss(new FireElement(3), 2, new Room());
        assertEquals(new Stats(7, 6, 6).toString(), boss.getStats().toString());
    }

    @Test
    void generateBossStatsForLevelThree() { //Själva statsen ska ändras
        Boss boss = new Boss(new FireElement(3), 3, new Room());
        assertEquals(new Stats(10, 9, 9).toString(), boss.getStats().toString());
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void generateBossStatsForLevelOne() {
        Boss boss = new Boss(new FireElement(3), 1, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(new Stats(5, 4, 4).toString(), boss.getStats().toString());
    }

    @Test
    void generateBossStatsForLevelTwo() {
        Boss boss = new Boss(new FireElement(3), 2, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(new Stats(7, 6, 6).toString(), boss.getStats().toString());
    }

    @Test
    void generateBossStatsForLevelThree() {
        Boss boss = new Boss(new FireElement(3), 3, new Room(new Player("Test", new FireElement(1), Role.Tank)));
        assertEquals(new Stats(10, 9, 9).toString(), boss.getStats().toString());
    }
}
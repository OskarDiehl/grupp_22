import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerStatsTest {

    @Test
    void getCurrentLevelFromConstructorArgument() {
        PlayerStats stats = new PlayerStats(2,3,4);
        assertEquals(1, stats.getCurrentLevel());
    }

    @Test
    void levelCurrentLevelUpToLevleTwo(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.levelStatsUp();
        assertEquals(2, stats.getCurrentLevel());
    }

    @Test
    void canNotLevelUpAfterLevelThree(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.levelStatsUp();
        stats.levelStatsUp();
        stats.levelStatsUp();
        assertEquals(3, stats.getCurrentLevel());
    }

}

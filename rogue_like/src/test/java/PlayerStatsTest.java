import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerStatsTest {

    //TEST CONSTRUCTOR ------------------------------------------------------------------------
    @Test
    void getCurrentLevelFromConstructorArgument() {
        PlayerStats stats = new PlayerStats(2,3,4);
        assertEquals(1, stats.getCurrentLevel());
    }


    //TEST LEVELING ---------------------------------------------------------------------------
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


    //TEST CHANGE POWER AND SPEED ------------------------------------------------------------------------
    @Test
    void increasePowerWithTwo(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.increasePowerTemporary(2);
        assertEquals(5, stats.getCurrentPower());
    }

    @Test
    void decreasePowerWithTwo(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.decreasePowerTemporary(2);
        assertEquals(1, stats.getCurrentPower());
    }

    @Test
    void increasePowerFromEightWithFour(){
        PlayerStats stats = new PlayerStats(2,8,4);
        stats.increasePowerTemporary(4);
        assertEquals(10, stats.getCurrentPower());
    }

    @Test
    void decreasePowerFromTwoWithFive(){
        PlayerStats stats = new PlayerStats(2,2,4);
        stats.decreasePowerTemporary(5);
        assertEquals(0, stats.getCurrentPower());
    }

    @Test
    void increaseSpeedWithTwo(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.increaseSpeedTemporary(2);
        assertEquals(6, stats.getCurrentSpeed());
    }

    @Test
    void decreaseSpeedWithTwo(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.decreaseSpeedTemporary(2);
        assertEquals(2, stats.getCurrentSpeed());
    }

    @Test
    void resetSpeedAndPower(){
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.decreaseSpeedTemporary(2);
        stats.increasePowerTemporary(2);
        stats.resetPowerAndSpeedToDefaultValues();
        assertEquals(4, stats.getCurrentSpeed() + 3, stats.getCurrentPower());
    }

    @Test
    void increaseSpeedFromSevenWithFive(){
        PlayerStats stats = new PlayerStats(2,3,7);
        stats.increaseSpeedTemporary(5);
        assertEquals(10, stats.getCurrentSpeed());
    }

    @Test
    void decreaseSpeedFromTwoWithSix(){
        PlayerStats stats = new PlayerStats(2,3,2);
        stats.decreaseSpeedTemporary(6);
        assertEquals(0, stats.getCurrentSpeed());
    }


    @Test
    void tryGetTemporaryPowerMethod(){
        PlayerStats stats = new PlayerStats(2,3,4);
        assertEquals(3, stats.getCurrentPower());
    }



}

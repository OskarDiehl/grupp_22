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
    //POWER
    @Test
    void increasePowerWith2 (){                                                 // Checks if currentPower can increase
        PlayerStats stats = new PlayerStats(2,3,5);
        stats.changePowerTemporary(2);
        assertEquals(5, stats.getCurrentPower());
    }

    @Test
    void decreasePowerWith2 (){                                                 // Checks if currentPower can decrease
        PlayerStats stats = new PlayerStats(2,3,5);
        stats.changePowerTemporary(-2);
        assertEquals(1, stats.getCurrentPower());
    }

    @Test
    void increasePowerFrom8With4(){                                             // Checks if currentPower has 10 as maxvalue
        PlayerStats stats = new PlayerStats(2,8,4);
        stats.changePowerTemporary(4);
        assertEquals(10, stats.getCurrentPower());
    }

    @Test
    void decreasePowerFrom2With5(){                                             // Checks if currentPower has 0 as minvalue
        PlayerStats stats = new PlayerStats(2,2,4);
        stats.changePowerTemporary(-5);
        assertEquals(0, stats.getCurrentPower());
    }

    //SPEED
    @Test
    void increaseSpeedWith2(){                                                  // Checks if currentSpeed can increase
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changeSpeedTemporary(2);
        assertEquals(6, stats.getCurrentSpeed());
    }

    @Test
    void decreaseSpeedWith2(){                                                  // Checks if currentSpeed can decrease
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changeSpeedTemporary(-2);
        assertEquals(2, stats.getCurrentSpeed());
    }

    @Test
    void increaseSpeedFrom7With5(){                                             // Checks if currentSpeed has 10 as maxvalue
        PlayerStats stats = new PlayerStats(2,3,7);
        stats.changeSpeedTemporary(5);
        assertEquals(10, stats.getCurrentSpeed());
    }

    @Test
    void decreaseSpeedFrom2With6(){                                             // Checks if currentSpeed has 0 as minvalue
        PlayerStats stats = new PlayerStats(2,3,2);
        stats.changeSpeedTemporary(-6);
        assertEquals(0, stats.getCurrentSpeed());
    }

    @Test
    void resetPowerAndSpeed(){                                                  // Checks if it is possible to reset currentPower and currentSpeed to  their default values
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changePowerTemporary(2);
        stats.changeSpeedTemporary(2);
        stats.resetPowerAndSpeedToDefaultValues();
        assertEquals(4, stats.getCurrentSpeed() + 3, stats.getCurrentPower());
    }
}

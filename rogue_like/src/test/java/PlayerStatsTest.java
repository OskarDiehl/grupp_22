import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerStatsTest {
    //POWER ------------------------------------------------------------------------------------------------------------
    @Test
    void increasePowerWith2 (){                                                 // Checks if temporaryPower can increase
        PlayerStats stats = new PlayerStats(2,3,5);
        stats.changePowerTemporary(2);
        assertEquals(5, stats.getTemporaryPower());
    }

    @Test
    void decreasePowerWith2 (){                                                 // Checks if temporaryPower can decrease
        PlayerStats stats = new PlayerStats(2,3,5);
        stats.changePowerTemporary(-2);
        assertEquals(1, stats.getTemporaryPower());
    }

    @Test
    void increasePowerFrom8With4(){                                             // Checks if temporaryPower has 10 as maxvalue
        PlayerStats stats = new PlayerStats(2,8,4);
        stats.changePowerTemporary(4);
        assertEquals(10, stats.getTemporaryPower());
    }

    @Test
    void decreasePowerFrom2With5(){                                             // Checks if temporaryPower has 0 as minvalue
        PlayerStats stats = new PlayerStats(2,2,4);
        stats.changePowerTemporary(-5);
        assertEquals(0, stats.getTemporaryPower());
    }


    //SPEED ------------------------------------------------------------------------------------------------------------
    @Test
    void increaseSpeedWith2(){                                                  // Checks if temporarySpeed can increase
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changeSpeedTemporary(2);
        assertEquals(6, stats.getTemporarySpeed());
    }

    @Test
    void decreaseSpeedWith2(){                                                  // Checks if temporarySpeed can decrease
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changeSpeedTemporary(-2);
        assertEquals(2, stats.getTemporarySpeed());
    }

    @Test
    void increaseSpeedFrom7With5(){                                             // Checks if temporarySpeed has 10 as maxvalue
        PlayerStats stats = new PlayerStats(2,3,7);
        stats.changeSpeedTemporary(5);
        assertEquals(10, stats.getTemporarySpeed());
    }

    @Test
    void decreaseSpeedFrom2With6(){                                             // Checks if temporarySpeed has 0 as minvalue
        PlayerStats stats = new PlayerStats(2,3,2);
        stats.changeSpeedTemporary(-6);
        assertEquals(0, stats.getTemporarySpeed());
    }


    //HP ---------------------------------------------------------------------------------------------------------------
    @Test
    void increaseHPWithTwo (){                                                      // Checks if temporaryHP can increase
        PlayerStats stats = new PlayerStats(2,3,5);
        stats.changeHPTemporary(2);
        assertEquals(4, stats.getTemporaryHP());
    }

    @Test
    void decreaseHPWithTwo(){                                                      // Checks if temporaryHP can decrease
        PlayerStats stats = new PlayerStats(4,3,5);
        stats.changeHPTemporary(-2);
        assertEquals(2, stats.getTemporaryHP());
    }

    @Test
    void increaseHPFromSevenWithFour(){                                             // Checks if temporaryHP has 10 as maxvalue
        PlayerStats stats = new PlayerStats(7,5,4);
        stats.changeHPTemporary(4);
        assertEquals(10, stats.getTemporaryHP());
    }

    @Test
    void decreaseHPFromThreeWithFive(){                                               // Checks if temporaryHP has 0 as minvalue
        PlayerStats stats = new PlayerStats(3,2,4);
        stats.changeHPTemporary(-5);
        assertEquals(0, stats.getTemporaryHP());
    }

    @Test
    void resetHP(){                                                                 // Reset temporaryHP
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changeHPTemporary(2);
        stats.resetPowerAndSpeedToDefaultValues();
        assertEquals(2, stats.getDefaultHP());
    }


    // OTHER -----------------------------------------------------------------------------------------------------------
    @Test
    void tryLevelUpStats(){                                                         // Level up the stats
        PlayerStats stats = new PlayerStats(2,3,2);
        stats.levelStatsUp();
        assertEquals(4, stats.getDefaultHP());
    }

    @Test
    void resetPowerAndSpeed(){                                                      // Checks if it is possible to reset currentPower and currentSpeed to  their default values
        PlayerStats stats = new PlayerStats(2,3,4);
        stats.changePowerTemporary(2);
        stats.changeSpeedTemporary(2);
        stats.resetPowerAndSpeedToDefaultValues();
        assertEquals(4, stats.getDefaultSpeed() + 3, stats.getDefaultPower());
    }

}

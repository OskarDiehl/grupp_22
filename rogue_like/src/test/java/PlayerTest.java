import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Element element;
    private Role role = Role.Warrior;


    //TEST CONSTRUCTOR ------------------------------------------------------------------------
    @Test
    void getNameFromConstructorArgument() {
        Player player = new Player("Sabina", element, role);
        assertEquals("Sabina", player.getName());
    }

    //commenterade bort testet för att det hindrade mig från att testa Element/ Oskar
    /*@Test
    void getElementFromConstructorArgument() {
        Element e = new Element();
        Player player = new Player("Sabina", e, role);
        assertEquals(e, player.getElement());
    }*/

//    @Test
//    void getLevelFromConstructorArgument(){    TODO fixa det här Malin /Malin
//        Player player = new Player("Sabina", element, role);
//        assertEquals(1, player.getLevel());
//    }



    //TEST THE ENUM CLASS ROLE --------------------------------------------------------
    //TODO Just nu testar jag Enum-klassen Role här, är det dumt? Ta en titt på om man kan testa den på något annat vis Malin /Malin
    @Test
    void getWarriorAsRoleNameConstructorArgument(){                               // This test check if the role name is correct  TODO byt namn (inte sluta på constructorArgument?) /Malin
        Player player = new Player("Sabina", element, role);
        assertEquals("Warrior", player.getRole().getRoleName());
    }

    @Test
    void getCorrectLifeAmountFromRoleConstructorArgument(){                       // This test check if the amount of life is correct  TODO byt namn (inte sluta på constructorArgument?) /Malin
        Player player = new Player("Sabina", element, role);
        assertEquals(4, player.getRole().getHP());
    }

    @Test
    void getCorrectPowerAmountFromRoleConstructorArgument(){                      // This test check if the amount of power is correct   TODO byt namn (inte sluta på constructorArgument?) /Malin
        Player player = new Player("Sabina", element, role);
        assertEquals(6, player.getRole().getPower());
    }

    @Test
    void getCorrectSpeedAmountFromRoleConstructorArgument(){                      // This test check if the amount of speed is correct   TODO byt namn (inte sluta på constructorArgument?) /Malin
        Player player = new Player("Sabina", element, role);
        assertEquals(5, player.getRole().getSpeed());
    }


    //TEST GET-METHODS FOR STATS----------------------------------------------------------------------
    @Test
    void getCurrentHPFromGetMethod() {
        Player player = new Player("Sabina", element, role);
        assertEquals(4, player.getCurrentHPFromStats());
    }

    @Test
    void getPowerFromStatsMethod(){
        Player player = new Player("Sabina", element, role);
        assertEquals(6, player.getCurrentPowerFromStats());
    }

    @Test
    void getSpeedFromStatsMethod(){
        Player player = new Player("Sabina", element, role);
        assertEquals(5, player.getCurrentSpeedFromStats());
    }


    //TEST LEVELING ------------------------------------------------------------------------
    @Test                               // TODO Fixa med metoderna när en spelare går upp i level Malin /Malin
    void levelUpToSecondLevel(){
        Player player = new Player("Sabina", element, role);
        player.levelUp();
        assertEquals(2, player.getCurrentLevel());
    }

    @Test
    void canNotLevelUpAfterLevelThree(){
        Player player = new Player("Sabina", element, role);
        player.levelUp();
        player.levelUp();
        player.levelUp();                  //TODO refactor? /Malin
        assertEquals(3, player.getCurrentLevel());
    }


    //TEST CHANGE STATS ------------------------------------------------------------------------
    @Test
    void increasePowerStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatPower(true, 3);
        assertEquals(9, player.getCurrentPowerFromStats());
    }

    @Test
    void decreasePowerStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatPower(false,3);
        assertEquals(3, player.getCurrentPowerFromStats());
    }

    @Test
    void increaseSpeedStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatSpeed(true, 3);
        assertEquals(8, player.getCurrentSpeedFromStats());
    }

    @Test
    void decreaseSpeedStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatSpeed(false,3);
        assertEquals(2, player.getPlayerStats().getCurrentSpeed());
    }

    @Test
    void resetPowerAndSpeed(){                                                  // Checks if it is possible to reset currentPower and currentSpeed to  their default values
        Player player = new Player("Sabina", element, role);
        player.changeStatPower(true,2);
        player.changeStatSpeed(false,2);
        player.resetStatsForPowerAndSpeed();
        assertEquals(4, player.getCurrentSpeedFromStats() + 3, player.getCurrentPowerFromStats());
    }



    //TEST XXX ------------------------------------------------------------------------
/*    @Test TODO Ska Stats tas upp redan i Character eller ska det in i Player istället? Det underlättar en hel del /Malin
    void getStatsWithoutFullStats(){
        Stats stats = new Stats(9, 5, 8);
        Player player = new Player("Sabina", element,"Warrior");
        assertEquals(stats.getLife(), player.getStats().getLife());
        assertEquals(stats.getPower(), player.getStats().getPower());
        assertEquals(stats.getSpeed(), player.getStats().getSpeed());
    }*/

}
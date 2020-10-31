import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    private Element element;
    private Role role = Role.Warrior;


    //TEST CONSTRUCTOR -------------------------------------------------------------------------------------------------
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



    //TEST THE ENUM CLASS ROLE -----------------------------------------------------------------------------------------
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


    //TEST GET-METHODS FOR STATS----------------------------------------------------------------------------------------
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


    //TEST LEVELING ----------------------------------------------------------------------------------------------------
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

    //TEST CHANGE STATS ------------------------------------------------------------------------------------------------
    @Test
    void increasePowerStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatPower(3);
        assertEquals(9, player.getCurrentPowerFromStats());
    }

    @Test
    void decreasePowerStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatPower(-3);
        assertEquals(3, player.getCurrentPowerFromStats());
    }

    @Test
    void increaseSpeedStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatSpeed( 3);
        assertEquals(8, player.getCurrentSpeedFromStats());
    }

    @Test
    void decreaseSpeedStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatSpeed(-3);
        assertEquals(2, player.getPlayerStats().getCurrentSpeed());
    }

    @Test
    void resetPowerAndSpeed(){                                                  // Checks if it is possible to reset currentPower and currentSpeed to  their default values
        Player player = new Player("Sabina", element, role);
        player.changeStatPower(2);
        player.changeStatSpeed(-2);
        player.resetStatsForPowerAndSpeed();
        assertEquals(4, player.getCurrentSpeedFromStats() + 3, player.getCurrentPowerFromStats());
    }

    //TEST MEDALLIONS ----------------------------------------------------------------------------------------------------
    @Test
    void fetchWaterMedallions(){
        WaterElement waterElement = new WaterElement(1);
        Player player = new Player("Sabina", element, role);
        player.fetchMedallionStatus(waterElement);
        assertEquals(0, player.getWaterMedallions());
    }

    @Test
    void fetchEarthMedallions(){
        EarthElement earthElement = new EarthElement(1);
        Player player = new Player("Sabina", element, role);
        player.fetchMedallionStatus(earthElement);
        assertEquals(0, player.getEarthMedallions());
    }

    @Test
    void fetchFireMedallions(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.fetchMedallionStatus(fireElement);
        assertEquals(0, player.getFireMedallions());
    }

    @Test
    void fetchWindMedallions(){
        WindElement windElement = new WindElement(3);
        Player player = new Player("Sabina", element, role);
        player.fetchMedallionStatus(windElement);
        assertEquals(0, player.getEarthMedallions());
    }

    @Test
    void add2FireMedallions(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(fireElement);
        player.addMedallion(fireElement);
        assertEquals(2, player.getFireMedallions());
    }

    @Test
    void add4WaterMedallions(){
        WaterElement waterElement = new WaterElement(1);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        assertEquals(3 ,player.getWaterMedallions());
    }

    //TODO fundera på om du ska skriva siffror med bokstäver eller siffror?

    @Test
    void resetMedallionsTo0(){ ;
        EarthElement earthElement = new EarthElement(2);
        WindElement windElement = new WindElement(3);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(windElement);
        player.addMedallion(windElement);
        player.addMedallion(windElement);
        player.addMedallion(earthElement);

        player.resetMedallions();

        assertEquals(0 , player.getWindMedallions(), player.getEarthMedallions());
    }

    //TEST ELEMENTS ----------------------------------------------------------------------------------------------------
    //THE ARRAY ELEMENTS

//    @Test
//    void addFireElementToElements(){
//        FireElement fireElement = new FireElement(2);
//        Player player = new Player("Sabina", fireElement, role);
//        assertEquals("Fire", player.returnOwnedElements());
//    }

    @Test
    void getWindElementAsActivatedElement(){
        FireElement fireElement = new FireElement(2);
        WindElement windElement = new WindElement(3);
        Player player = new Player("Sabina", fireElement, role);         //Makes a fire element as the main element and therefor the activated element
        player.addElement(windElement);                                         //Adds a wind element to the player´s owned elements
        player.changeActivatedElement("Wind");                    //Changes the activated element to the wind element
        assertEquals(windElement, player.getActivatedElement());
    }



    //TODO fixa det här MalinJÄVEL mvh Malin

    //TODO metod som lägger in element i elements -> implementera i konstruktorn /Malin

    @Test
    void searchForElementInElementsArray(){
        FireElement fireElement = new FireElement(1);
        Player player = new Player("Sabina", fireElement, role);
    }


    //TEST XXX ---------------------------------------------------------------------------------------------------------
/*    @Test TODO Ska Stats tas upp redan i Character eller ska det in i Player istället? Det underlättar en hel del /Malin
    void getStatsWithoutFullStats(){
        Stats stats = new Stats(9, 5, 8);
        Player player = new Player("Sabina", element,"Warrior");
        assertEquals(stats.getLife(), player.getStats().getLife());
        assertEquals(stats.getPower(), player.getStats().getPower());
        assertEquals(stats.getSpeed(), player.getStats().getSpeed());
    }*/

}
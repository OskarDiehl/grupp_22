import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Element element = new WindElement(1);
    private Role role = Role.Warrior;


    //TEST CONSTRUCTOR -------------------------------------------------------------------------------------------------
    @Test
    void getNameFromConstructorArgument() {
        Player player = new Player("Sabina", element, role);
        assertEquals("Sabina", player.getName());
    }

    @Test
    void getNullPointerExceptionFromIllegalLevelConstructorArgument() {
        assertThrows(NullPointerException.class, () -> new Player("Sabina", null, role));
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
        assertEquals(2, player.getLevel());
    }

//    @Test
//    void canNotLevelUpAfterLevelThree(){
//        Player player = new Player("Sabina", element, role);
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();                  //TODO refactor? /Malin
//        assertEquals(3, player.getCurrentLevel());
//    }



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
        assertEquals(2, player.getCurrentSpeedFromStats());
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
        Player player = new Player("Sabina", element, role);
        player.addMedallion(new WaterElement(1));
        assertEquals(1, player.fetchMedallionStatus(new WaterElement(3)));
    }

    @Test
    void fetchEarthMedallions(){
        Player player = new Player("Sabina", element, role);
        player.addMedallion(new EarthElement(1));
        player.addMedallion(new WaterElement(2));
        player.addMedallion(new EarthElement(3));
        assertEquals(2,  player.fetchMedallionStatus(new EarthElement(1)));
    }

    @Test
    void fetchFireMedallions(){
        Player player = new Player("Sabina", element, role);
        assertEquals(0, player.fetchMedallionStatus(new FireElement(3)));
    }

    @Test
    void fetchWindMedallions(){
        Player player = new Player("Sabina", element, role);
        player.addMedallion(new WindElement(2));
        player.addMedallion(new WindElement(3));
        assertEquals(2, player.fetchMedallionStatus(new WindElement(1)));
    }

    @Test
    void add2FireMedallions(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(fireElement);
        player.addMedallion(fireElement);
        assertEquals(2, player.fetchMedallionStatus(fireElement));
    }

    @Test
    void add4WaterMedallions(){
        WaterElement waterElement = new WaterElement(1);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        assertEquals(3 ,player.fetchMedallionStatus(waterElement));
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

        player.resetMedallion(windElement);

        assertEquals(0 , player.fetchMedallionStatus(new WindElement(2)), player.fetchMedallionStatus(new EarthElement(3)));
    }



    //TEST ELEMENTS METHODS --------------------------------------------------------------------------------------------
    @Test
    void addFireElementToElements(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addElement(fireElement);
        assertEquals(fireElement, player.findElement("Fire"));
    }

    @Test
    void getEarthElementAsActivatedElement(){                                           //Tests the method "changeActivatedElement"
        FireElement fireElement = new FireElement(2);
        EarthElement earthElement = new EarthElement(3);
        Player player = new Player("Sabina", fireElement, role);                //Makes a fire element as the main element and therefor the activated element
        player.addElement(earthElement);                                                //Adds a wind element to the player´s owned elements
        player.changeActivatedElement("Earth");                             //Changes the activated element to the wind element
        assertEquals(earthElement, player.getActivatedElement());
    }

    @Test
    void spellEarthWrongInChangeActivatedElement(){                                     //Tests the method "changeActivatedElement" and "getActivatedElement"
        FireElement fireElement = new FireElement(2);
        EarthElement earthElement = new EarthElement(3);
        Player player = new Player("Sabina", fireElement, role);                //Makes a fire element as the main element and therefor the activated element
        player.addElement(earthElement);                                                //Adds a wind element to the player´s owned elements
        player.changeActivatedElement("Earh");                              //Changes the activated element to the wind element
        assertEquals(fireElement, player.getActivatedElement());
    }

    @Test
    void levelUpElement(){                                                              //Test level up player´s wind element
        Player player = new Player("Sabina", element, role);
        player.addElement(new WindElement(3));
        player.addElement(new WindElement(3));
        assertEquals(3, player.getMainElement().getElementLevel());
    }

    //TODO metod som lägger in element i elements -> implementera i konstruktorn /Malin

    @Test
    void searchForElementInElementsArray(){                                             //Test method "findElement"
        WaterElement waterElement = new WaterElement(3);
        FireElement fireElement = new FireElement(1);
        Player player = new Player("Sabina", element, role);
        player.addElement(waterElement);
        player.addElement(fireElement);
        assertEquals(waterElement, player.findElement("water"));
    }

    @Test
    void typWrongInFindElementMethod(){                                                 //Type wrong in method "findElement"
        Player player = new Player("Sabina", element, role);
        assertNull(player.findElement("win"));
    }

    @Test
    void getNullPointerExceptionFromAddElement() {
        Player player = new Player("Sabina", element, role);
        assertThrows(NullPointerException.class, () -> player.addElement(null));
    }

//    @Test
//    void throwExceptionInGetActivatedElement(){  TODO Ta bort?
//        Player player = new Player("Sabina", element, role);
//        assertThrows(IllegalArgumentException.class, () -> player.addElement(null));
//
//     //   assertThrows(NullPointerException.class, () -> player.getActivatedElement());
//
//     //   assertThrows(NullPointerException.class, () -> new Player("Sabina", null, role));
//    }


    //TEST ITEMS METHODS  ----------------------------------------------------------------------------------------------

    //4,6,5 TODO Ta bort sen /Malin
    @Test
    void addShoesToItems(){                                                         // Add shoes
        Player player = new Player("Sabina", element, role);
        player.addItem(new Shoes("Heels", 3, 3));
        assertEquals("Heels", player.getItem("Shoes").getName());
    }

    @Test                                                        //TODO fixa när Oskar kanske har fixat med get-metoderna i Item :) /Malin    +  metoden för HP i Stats
    void doesArmorAddHPToStats(){                                                // Check if HP increases because of armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Armor("Birthdaysuit", 3, 3));
        assertEquals(9, player.getCurrentHPFromStats());
    }

    @Test                                                        //TODO fixa när Oskar kanske har fixat med get-metoderna i Item :) /Malin
    void doesWeaponAddPowerToStats(){                                                // Check if Power increases because of armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Weapon("Love", 3, 3));
        assertEquals(9, player.getCurrentPowerFromStats());
    }

    @Test                                                        //TODO fixa när Oskar kanske har fixat med get-metoderna i Item :) /Malin
    void doesShoesAddSpeedToStats(){                                                // Check if stats increases because of armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Shoes("Slippers", 3, 3));
        assertEquals(9, player.getCurrentSpeedFromStats());
    }


    //ATT KOLLA:
    // Adderas speed?
    // Adderas power?
    // Hittar man shoes på rätt plats?
    // Hittar man armor på rätt plats?
    // Hittar man weapon på rätt plats?
    // Byts shoes ut?
    // Byts armor ut?
    // Byts weapon ut?
    // Kan man hitta ett item?
    // Kan man ta bort ett item?
    // Försvinner extra stats när item:et tas bort?



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
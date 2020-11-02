import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private final Element element = new WindElement(2);
    private final Role role = Role.Warrior;


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


    //TEST GET-METHODS FOR STATS----------------------------------------------------------------------------------------
    @Test
    void getCurrentHPFromGetMethod() {
        Player player = new Player("Sabina", element, role);
        assertEquals(4, player.getCurrentHPFromStats());
    }

    @Test
    void getPowerFromStatsMethod(){
        Player player = new Player("Sabina", element, role);
        assertEquals(6, player.getTemporaryPowerFromStats());
    }

    @Test
    void getSpeedFromStatsMethod(){
        Player player = new Player("Sabina", element, role);
        assertEquals(5, player.getTemporarySpeedFromStats());
    }



    //TEST LEVELING ----------------------------------------------------------------------------------------------------
    @Test
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
//        player.levelUp();                  //TODO Kolla med Sabina om det verkligen ska kastas ett undantag /Malin
//        assertEquals(3, player.getLevel());
//    }



    //TEST CHANGE STATS ------------------------------------------------------------------------------------------------
    @Test
    void increasePowerStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatPowerTemporary(3);
        assertEquals(9, player.getTemporaryPowerFromStats());
    }

    @Test
    void decreasePowerStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatPowerTemporary(-3);
        assertEquals(3, player.getTemporaryPowerFromStats());
    }

    @Test
    void increaseSpeedStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatSpeedTemporary( 3);
        assertEquals(8, player.getTemporarySpeedFromStats());
    }

    @Test
    void decreaseSpeedStats(){
        Player player = new Player("Sabina", element, role);
        player.changeStatSpeedTemporary(-3);
        assertEquals(2, player.getTemporarySpeedFromStats());
    }

    @Test
    void resetPowerAndSpeed(){                                                  // Checks if it is possible to reset currentPower and currentSpeed to  their default values
        Player player = new Player("Sabina", element, role);
        player.changeStatPowerTemporary(2);
        player.changeStatSpeedTemporary(-2);
        player.resetStatsForPowerAndSpeed();
        assertEquals(4, player.getTemporarySpeedFromStats() + 3, player.getTemporaryPowerFromStats());
    }

    @Test
    void checkGetStatsMethod(){
        Player player = new Player("Sabina", element, role);
        assertEquals(6, player.getStats().getDefaultPower());
    }

    @Test
    void checkGetRoleMethod(){
        Player player = new Player("Sabina", element, role);
        assertEquals("Warrior", player.getRole().getRoleName());
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
    void addTwoFireMedallions(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(fireElement);
        player.addMedallion(fireElement);
        assertEquals(2, player.fetchMedallionStatus(fireElement));
    }

    @Test
    void addFourWaterMedallions(){
        WaterElement waterElement = new WaterElement(1);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        assertEquals(3 ,player.fetchMedallionStatus(waterElement));
    }

    @Test
    void resetWindMedallionsToZero(){
        EarthElement earthElement = new EarthElement(2);
        WindElement windElement = new WindElement(3);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(windElement);
        player.addMedallion(windElement);
        player.addMedallion(windElement);
        player.addMedallion(earthElement);

        player.resetMedallion(windElement);

        assertEquals(0 , player.fetchMedallionStatus(new WindElement(2)));
    }

    @Test
    void resetEarthMedallionsToZero(){
        EarthElement earthElement = new EarthElement(2);
        Player player = new Player("Sabina", element, role);
        player.addMedallion(earthElement);
        player.resetMedallion(earthElement);

        assertEquals(0 , player.fetchMedallionStatus(new EarthElement(3)));
    }

    @Test
    void resetWaterMedallionsToZero(){
        WaterElement waterElement = new WaterElement(2);
        Player player = new Player("Sabina", waterElement, role);
        player.resetMedallion(new WaterElement(1));
        assertEquals(0 , player.fetchMedallionStatus(new WaterElement(3)));
    }

    @Test
    void resetFireMedallionsToZero(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", fireElement, role);
        player.resetMedallion(new FireElement(2));
        assertEquals(0 , player.fetchMedallionStatus(new FireElement(3)));
    }


    //TEST ELEMENT METHODS --------------------------------------------------------------------------------------------
    @Test
    void addFireElementToElements(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addElement(fireElement);
        assertEquals(fireElement, player.findElement("Fire"));
    }

    @Test
    void switchToEarthElementAsActivatedElement(){                          //Tests the method "changeActivatedElement"
        FireElement fireElement = new FireElement(2);
        EarthElement earthElement = new EarthElement(3);
        Player player = new Player("Sabina", fireElement, role);    //Makes a fire element as the main element and therefor the activated element
        player.addElement(earthElement);                                   //Adds a earth element to the player´s owned elements
        player.changeActivatedElement("Earth");                //Changes the activated element to the earth element
        assertEquals(earthElement, player.getActivatedElement());
    }

    @Test
    void throwIAEInChangeActivatedElement(){                                  // Throw IllegalArgumentException in the method "changeActivatedElement"
        Player player = new Player("Sabina", element, role);
        assertThrows(IllegalArgumentException.class, () -> player.changeActivatedElement("Bad argument"));
    }

    @Test
    void levelUpElement(){                                                              //Test level up player´s wind element
        Player player = new Player("Sabina", element, role);
        player.addElement(new WindElement(3));
        player.addElement(new WindElement(3));
        assertEquals(3, player.getMainElement().getElementLevel());
    }

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
    void searchForWindInElementsArray(){                                               // Try find wind element i elements
        WindElement windElement = new WindElement(2);
        Player player = new Player("Sabina", windElement, role);
        assertEquals(windElement, player.findElement("Wind"));
    }

    @Test
    void throwIAEInFindElement(){                                                                               // Throw IllegalArgumentException i metoden findElement
        Player player = new Player("Sabina", element, role);
        assertThrows(IllegalArgumentException.class, () -> player.findElement("Bad argument"));
    }

    @Test
    void getNullPointerExceptionFromAddElement() {
        Player player = new Player("Sabina", element, role);
        assertThrows(NullPointerException.class, () -> player.addElement(null));  //TODO fick "Probable bugs" -> "Constant conditions & exceptions för null /Malin
    }

    @Test
    void earthAsAnArgumentWithNoSuccessfulSearch(){                                 // Check if the String "Earth" as an argument has a non successful search
        Player player = new Player("Sabina", element, role);
        assertNull(player.findElement("Earth"));
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

    @Test
    void addShoesToItems(){                                                             // Add shoes
        Player player = new Player("Sabina", element, role);
        player.addItem(new Shoes("Heels", 3, 3));
        assertEquals("Heels", player.findItem("Shoes").getName());
    }

    @Test
    void addArmorToItems(){                                                             // Add armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Armor("Birthday suit", 3, 3));
        assertEquals("Birthday suit", player.findItem("Armor").getName());
    }

    @Test
    void addWeaponToItems(){                                                             // Add gun
        Player player = new Player("Sabina", element, role);
        player.addItem(new Weapon("Gun", 3, 3));
        assertEquals("Gun", player.findItem("Weapon").getName());
    }

    @Test
    void doesArmorAddHPToStats(){                                                       // Check if HP increases because of armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Armor("Birthday suit", 3, 3));
        assertEquals(7, player.getTemporaryHPFromStats());
    }

    @Test
    void doesWeaponAddPowerToStats(){                                                   // Check if Power increases because of armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Weapon("Love", 3, 3));
        assertEquals(9, player.getTemporaryPowerFromStats());
    }

    @Test
    void switchShoesChangesSpeed(){                                                    // Check if stats decreases because of shoes
        Player player = new Player("Sabina", element, role);
        player.addItem(new Shoes("Slippers", 3, 3));
        assertEquals(8, player.getTemporarySpeedFromStats());
    }

    @Test
    void switchArmorChangesHP(){                                                       // Check if HP decreases because player switch armor
        Player player = new Player("Sabina", element, role);
        player.addItem(new Armor("Birthday suit", 3, 3));
        player.addItem(new Armor("Spandex", 5, 5));
        assertEquals(9, player.getTemporaryHPFromStats());
    }

    @Test
    void switchWeaponChangesPower(){                                                   // Check if Power decreases because player switch weapon
        Player player = new Player("Sabina", element, role);
        player.addItem(new Weapon("Hate", 3, 3));
        player.addItem(new Weapon("Love", 4, 4));
        assertEquals(10, player.getTemporaryPowerFromStats());
    }

    @Test
    void doesShoesAddSpeedToStats(){                                                   // Check if stats increases because player switch shoes
        Player player = new Player("Sabina", element, role);
        player.addItem(new Shoes("Heals", 3, 3));
        player.addItem(new Shoes("Slippers", 2, 2));
        assertEquals(7, player.getTemporarySpeedFromStats());
    }

    // TEST ATTACK ENEMY METHOD ----------------------------------------------------------------------------------------
    @Test
    void attackEnemy() {
        //TODO HJÄÄÄÄLP /Malin
    }

    @Test
    void throwCCEWhenParameterIsNotOfTypePlayer() {
        Enemy enemy = new Enemy(new FireElement(2), 2,
                new Room(new Player("Malin", new FireElement(1), Role.Tank)));
        Character notPlayer = new Enemy(new EarthElement(1), 1,
                new Room(new Player("Oskar", new WaterElement(1), Role.Warrior)));
        assertThrows(ClassCastException.class, () -> enemy.attack(notPlayer));
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

}
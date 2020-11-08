import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private final Element windElement = new WindElement(2);
    private final Role warriorRole    = Role.Warrior;
    private final Player player       = new Player("Sabina", windElement, warriorRole);
    private final Shoes shoes         = new Shoes("Shoes", 1,1);
    private final Shoes heels         = new Shoes("Heels", 3,3);
    private final Shoes flipFlops     = new Shoes("Flip Flops", 4, 4);
    private final Weapon loveWeapon   = new Weapon("Love", 3, 3);
    private final Armor suitArmor     = new Armor("Suit", 2,2);


    //TEST CONSTRUCTOR -------------------------------------------------------------------------------------------------
    @Test
    void getNameFromConstructorArgument() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals("Sabina", player.getName());
    }

    @Test
    void getNullPointerExceptionFromIllegalLevelConstructorArgument() {
        assertThrows(NullPointerException.class, () -> new Player("Sabina", null, warriorRole));
    }


    //TEST GET-METHODS FOR STATS----------------------------------------------------------------------------------------
    @Test
    void getCurrentHPFromGetMethod() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals(4, player.getCurrentHP());
    }

    @Test
    void getPowerFromStatsMethod() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals(6, player.getTemporaryPower());
    }

    @Test
    void getSpeedFromStatsMethod() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals(5, player.getTemporarySpeed());
    }


    //TEST LEVELING ----------------------------------------------------------------------------------------------------
    @Test
    void levelUpToSecondLevel() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.levelUp();
        assertEquals(2, player.getLevel());
    }

//    @Test
//    void canNotLevelUpAfterLevelThree(){
//        Player player = new Player("Sabina", element, role);
//        player.levelUp();
//        player.levelUp();
//        player.levelUp();
//        assertEquals(3, player.getLevel());
//    }


    //TEST CHANGE STATS ------------------------------------------------------------------------------------------------
    @Test
    void increasePowerStats() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.changeStatPowerTemporary(3);
        assertEquals(9, player.getTemporaryPower());
    }

    @Test
    void decreasePowerStats() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.changeStatPowerTemporary(-3);
        assertEquals(3, player.getTemporaryPower());
    }

    @Test
    void increaseSpeedStats() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.changeStatSpeedTemporary(3);
        assertEquals(8, player.getTemporarySpeed());
    }

    @Test
    void decreaseSpeedStats() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.changeStatSpeedTemporary(-3);
        assertEquals(2, player.getTemporarySpeed());
    }

    @Test
    void resetPowerAndSpeed() {                                                  // Checks if it is possible to reset currentPower and currentSpeed to  their default values
        Player player = new Player("Sabina", windElement, warriorRole);
        player.changeStatPowerTemporary(2);
        player.changeStatSpeedTemporary(-2);
        player.resetStatsToDefault();
        assertEquals(4, player.getTemporarySpeed() + 3, player.getTemporaryPower());
    }

    @Test
    void checkGetStatsMethod() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals(6, player.getStats().getDefaultPower());
    }

    @Test
    void checkGetRoleMethod() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals("Warrior", player.getRole().getRoleName());
    }

    @Test
    void gainHP (){
        player.looseHP(3);
        player.gainHP(1);
        assertEquals(2, player.getCurrentHP());
    }

    //TEST MEDALLIONS ----------------------------------------------------------------------------------------------------
    @Test
    void fetchWaterMedallions() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addMedallion(new WaterElement(1));
        assertEquals(1, player.fetchMedallionStatus(new WaterElement(3)));
    }

    @Test
    void fetchEarthMedallions() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addMedallion(new EarthElement(1));
        player.addMedallion(new WaterElement(2));
        player.addMedallion(new EarthElement(3));
        assertEquals(2, player.fetchMedallionStatus(new EarthElement(1)));
    }

    @Test
    void fetchFireMedallions() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals(0, player.fetchMedallionStatus(new FireElement(3)));
    }

    @Test
    void fetchWindMedallions() {
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addMedallion(new WindElement(2));
        player.addMedallion(new WindElement(3));
        assertEquals(2, player.fetchMedallionStatus(new WindElement(1)));
    }

    @Test
    void addTwoFireMedallions() {
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addMedallion(fireElement);
        player.addMedallion(fireElement);
        assertEquals(2, player.fetchMedallionStatus(fireElement));
    }

    @Test
    void addFourWaterMedallions() {
        WaterElement waterElement = new WaterElement(1);
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        player.addMedallion(waterElement);
        assertEquals(3, player.fetchMedallionStatus(waterElement));
    }

    @Test
    void resetWindMedallionsToZero() {
        EarthElement earthElement = new EarthElement(2);
        WindElement windElement = new WindElement(3);
        Player player = new Player("Sabina", this.windElement, warriorRole);
        player.addMedallion(windElement);
        player.addMedallion(windElement);
        player.addMedallion(windElement);
        player.addMedallion(earthElement);

        player.resetMedallion(windElement);

        assertEquals(0, player.fetchMedallionStatus(new WindElement(2)));
    }

    @Test
    void resetEarthMedallionsToZero() {
        EarthElement earthElement = new EarthElement(2);
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addMedallion(earthElement);
        player.resetMedallion(earthElement);

        assertEquals(0, player.fetchMedallionStatus(new EarthElement(3)));
    }

    @Test
    void resetWaterMedallionsToZero() {
        WaterElement waterElement = new WaterElement(2);
        Player player = new Player("Sabina", waterElement, warriorRole);
        player.resetMedallion(new WaterElement(1));
        assertEquals(0, player.fetchMedallionStatus(new WaterElement(3)));
    }

    @Test
    void resetFireMedallionsToZero() {
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", fireElement, warriorRole);
        player.resetMedallion(new FireElement(2));
        assertEquals(0, player.fetchMedallionStatus(new FireElement(3)));
    }


    //TEST ELEMENT METHODS ---------------------------------------------------------------------------------------------
    @Test
    void addFireElementToElements() {
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addElement(fireElement);
        assertEquals(fireElement, player.findElement("Fire"));
    }

    @Test
    void switchToEarthElementAsActivatedElement() {                          //Tests the method "changeActivatedElement"
        FireElement fireElement = new FireElement(2);
        EarthElement earthElement = new EarthElement(3);
        Player player = new Player("Sabina", fireElement, warriorRole);    //Makes a fire element as the main element and therefor the activated element
        player.addElement(earthElement);                                   //Adds a earth element to the player´s owned elements
        player.changeActivatedElement("Earth");                //Changes the activated element to the earth element
        assertEquals(earthElement, player.getActivatedElement());
    }

    @Test
    void throwIAEInChangeActivatedElement() {                                  // Throw IllegalArgumentException in the method "changeActivatedElement"
        Player player = new Player("Sabina", windElement, warriorRole);
        assertThrows(IllegalArgumentException.class, () -> player.changeActivatedElement("Bad argument"));
    }

    @Test
    void levelUpElement() {                                                              //Test level up player´s wind element
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addElement(new WindElement(3));
        player.addElement(new WindElement(3));
        assertEquals(3, player.getMainElement().getElementLevel());
    }

    @Test
    void searchForElementInElementsArray() {                                             //Test method "findElement"
        WaterElement waterElement = new WaterElement(3);
        FireElement fireElement = new FireElement(1);
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addElement(waterElement);
        player.addElement(fireElement);
        assertEquals(waterElement, player.findElement("water"));
    }

    @Test
    void searchForWindInElementsArray() {                                               // Try find wind element i elements
        WindElement windElement = new WindElement(2);
        Player player = new Player("Sabina", windElement, warriorRole);
        assertEquals(windElement, player.findElement("Wind"));
    }

    @Test
    void throwIAEInFindElement() {                                                                               // Throw IllegalArgumentException i metoden findElement
        Player player = new Player("Sabina", windElement, warriorRole);
        assertThrows(IllegalArgumentException.class, () -> player.findElement("Bad argument"));
    }

    @Test
    void getNullPointerExceptionFromAddElement() {
        Player player = new Player("Sabina", windElement, warriorRole);
        assertThrows(NullPointerException.class, () -> player.addElement(null));  //TODO fick "Probable bugs" -> "Constant conditions & exceptions för null /Malin
    }

    @Test
    void earthAsAnArgumentWithNoSuccessfulSearch() {                                 // Check if the String "Earth" as an argument has a non successful search
        Player player = new Player("Sabina", windElement, warriorRole);
        assertNull(player.findElement("Earth"));
    }


    //TEST ITEMS METHODS  ----------------------------------------------------------------------------------------------

    @Test
    void addShoesToItems() {                                                             // Add shoes
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Shoes("Heels", 3, 3));
        assertEquals("Heels", player.findItem(shoes).getName());
    }

    @Test
    void addArmorToItems() {                                                             // Add armor
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Armor("Birthday suit", 3, 3));
        assertEquals("Birthday suit", player.findItem(suitArmor).getName());
    }

    @Test
    void addWeaponToItems() {                                                             // Add gun
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Weapon("Gun", 3, 3));
        assertEquals("Gun", player.findItem(loveWeapon).getName());
    }

    @Test
    void doesArmorAddHPToStats() {                                                       // Check if HP increases because of armor
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Armor("Birthday suit", 3, 3));
        assertEquals(7, player.getTemporaryHPFromStats());
    }

    @Test
    void doesArmorAddSpeedToStats() {                                                       // Check if Armor increases because of armor
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Armor("Birthday suit", 3, 3));
        assertEquals(7, player.getTemporaryHPFromStats());
    }

    @Test
    void doesWeaponAddPowerToStats() {                                                   // Check if Power increases because of weapon
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Weapon("Love", 3, 3));
        assertEquals(9, player.getTemporaryPower());
    }

    @Test
    void switchShoesChangesSpeed() {                                                    // Check if stats decreases because of shoes
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Shoes("Slippers", 3, 3));
        assertEquals(8, player.getTemporarySpeed());
    }

    @Test
    void switchArmorChangesHP() {                                                       // Check if HP decreases because player switch armor
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Armor("Birthday suit", 3, 3));
        player.addItem(new Armor("Spandex", 5, 5));
        assertEquals(9, player.getTemporaryHPFromStats());
    }

    @Test
    void switchWeaponChangesPower() {                                                   // Check if Power decreases because player switch weapon
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Weapon("Hate", 3, 3));
        player.addItem(new Weapon("Love", 4, 4));
        assertEquals(10, player.getTemporaryPower());
    }

    @Test
    void doesShoesAddSpeedToStats() {                                                   // Check if stats increases because player switch shoes
        Player player = new Player("Sabina", windElement, warriorRole);
        player.addItem(new Shoes("Heals", 3, 3));
        player.addItem(new Shoes("Slippers", 2, 2));
        assertEquals(7, player.getTemporarySpeed());
    }

    @Test
    void armorAsAnArgumentWithNoSuccessfulSearch() {                                 // Check if the String "Earth" as an argument has a non successful search
        Player player = new Player("Sabina", windElement, warriorRole);
        assertNull(player.findItem(suitArmor));
    }

    // TEST THIS
//    public void addItem(Item newItem){                                                              // Add an item to the array items
//        if (newItem.getClass().isInstance(new Armor(null,0,0)))
//            switchAndAddItem(0, newItem);                                                     // Remove extra stats from potentially already existing armor
//            // Add new armor
//        else if (newItem.getClass().isInstance(new Shoes(null,0,0)))
//            switchAndAddItem(1, newItem);                                                     // Remove extra stats from potentially already existing shoes
//            // Add new shoes
//        else
//            switchAndAddItem(2, newItem);                                                   // Remove extra stats from potentially already existing weapon
//        // Add new weapon
//    }

//    private void switchAndAddItem(int index, Item newItem) {                  // Upgrade or add an element
//        if (items[index] != null)
//            itemDecreaseStats(items[index]);
//
//        items[index] = newItem;
//        itemIncreaseStats(newItem);                                          // Add extra stats from the new item
//    }


    @Test
    void looseHPWithAfterPickedUpItem (){
        player.addItem(loveWeapon);
        player.looseHP(5);
        assertEquals(2, player.getCurrentHP());
    }


    @Test
    void findItemThrowIAE(){
        assertThrows(NullPointerException.class, () -> player.findItem(null));
    }

    @Test
    void pickUpShoesIncreaseSpeedAndPower(){                                // Test if a shoe-item increase speed and power
        Shoes heels = new Shoes("Heels", 3, 3);
        player.addItem(heels);                                              // Player has the default values 4 HP, 6 Power
                                                                            // and 5 Speed. Now speed and power increase with 3.

        assertEquals(9,player.getTemporaryPower() + 8, player.getTemporarySpeed());
    }

    @Test
    void switchShoes(){                                                     // Test if the player has the right object after a switch
        player.addItem(heels);
        player.addItem(flipFlops);
        assertEquals(flipFlops, player.findItem(shoes));                    // findItem check which Class the item is an instance of,
                                                                            // than search for an object with that class.
    }

    @Test
    void itemSwitchMakesCurrentHPZeroOrNegative(){
        player.addItem(loveWeapon);                                         // loveWeapon gives 3+ in HP. Which increases the temporary HP from 4 to 7.
        player.looseHP(5);                                       // Decreases the current HP from 7 to 2.
        assertThrows(IllegalStateException.class, () -> {
            player.addItem(new Weapon("Fork", 3, 0));   // Shoes gives 0+ in HP, therefor the switch of items result that the
        });                                                                 // current goes from 2 to -1. The switch is not possible.
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

    // TEST ATTACK ENEMY METHOD ----------------------------------------------------------------------------------------
    @Test
    void attackEnemy() {
        Player player = new Player("David", new FireElement(1), Role.Tank);
        Enemy enemy = new Enemy(new WaterElement(1), 2, new Room(player));
        player.attack(enemy);
        assertEquals(1, enemy.getCurrentHP());
    }

    @Test
    void throwCCEWhenParameterIsNotOfTypePlayer() {
       Player player = new Player("Malin", new FireElement(1), Role.Tank);
        Character notEnemy = new Player("Oskar", new WaterElement(1), Role.Warrior);
        assertThrows(ClassCastException.class, () -> player.attack(notEnemy));
    }




}
public class Player extends Character {

    // DATASAMLING/-AR -------------------------------------------------------------------------------------------------
    private final Element[] elements = new Element[4];        // Array containing different elements the player has collected
    private final Item[] items = new Item[3];                 // Array containing different items the player has picked up

    // INSTANCE VARIABLES ----------------------------------------------------------------------------------------------
    private final String name;
    private final Role role;
    private final PlayerStats playerStats;
    private Element activatedElement;     // The element the player use at the moment (You can only use one at the time)

    private int earthMedallions = 0;      // When the player has completed a room ze earns a medallion. There are
    private int waterMedallions = 0;      // four different kind of medallions, one for each element.
    private int fireMedallions = 0;       //      If the player has three of one sort, the next room will be a
    private int windMedallions = 0;       // boss room for the element the three medallions symbolize.
                                          //      When the player defeats the boss, ze will either earn or upgrade
                                          // the element for the boss room. It depends on if ze already has the object.


    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------
    public Player(String name, Element element, Role role) {
        super(element);
        this.name = name;
        this.role = role;
        this.playerStats = new PlayerStats(role.getHP(), role.getPower(), role.getSpeed());
        activatedElement = element;
        addElement(element);
    }

    // STATS METHODS ---------------------------------------------------------------------------------------------------

    public void changeStatPowerTemporary(int powerAmount) {         // Change the stats for power temporary
        playerStats.changePowerTemporary(powerAmount);
    }

    public void changeStatSpeedTemporary(int speedAmount) {         // Change the stats for speed temporary
        playerStats.changeSpeedTemporary(speedAmount);
    }

    public void changeStatHPTemporary(int HPAmount){                // Change the stats for HP temporary
        playerStats.changeHPTemporary(HPAmount);
    }

    public void resetStatsToDefault() {                             // Resets the stats for power, speed and HP
        playerStats.resetPowerAndSpeedToDefaultValues();
    }

    public void looseHP(int HPAmount){                              // When the player for example gets attacked
        playerStats.loseHP(HPAmount);
    }

    public void gainHP(int HPAmount){                               // When the player is healing
        playerStats.gainHP(HPAmount);
    }


    // ELEMENTS METHODS ------------------------------------------------------------------------------------------------
    // The index each element has in the array "elements":
    //   * index 0 = Earth element
    //   * index 1 = Water element
    //   * index 2 = Fire element
    //   * index 3 = Air element

    public void addElement(Element newElement) {
        if (newElement instanceof EarthElement) {               // For earth elements
            upgradeOrAddElement(0, newElement);          //... upgrade or add earth element

        } else if (newElement instanceof WaterElement)          // For water elements
            upgradeOrAddElement(1, newElement);          //... upgrade or add water element

        else if (newElement instanceof FireElement)             // For fire elements
            upgradeOrAddElement(2, newElement);          //... upgrade or add fire element

        else if (newElement instanceof WindElement)              // For wind elements
            upgradeOrAddElement(3, newElement);          //... upgrade or add wind element
        else
            throw new NullPointerException();
    }


    public Element findElement(String elementType) {                                                                                                                // Checks if the player has an certain element
        if (elementType.equalsIgnoreCase("earth") && elements[0] != null && elements[0] instanceof EarthElement)
            return elements[0];
        else if (elementType.equalsIgnoreCase("water") && elements[1] != null && elements[1] instanceof WaterElement)
            return elements[1];
        else if (elementType.equalsIgnoreCase("fire") && elements[2] != null && elements[2] instanceof FireElement)
            return elements[2];
        else if (elementType.equalsIgnoreCase("wind") && elements[3] != null && elements[3] instanceof WindElement)
            return elements[3];
        else if (elementSpelledCorrect(elementType)){
            System.out.println("You do not have this element yet!");
            return null;
        }
        else
            throw new IllegalArgumentException("Error: Argument not allowed.");
    }

    private void upgradeOrAddElement(int index, Element newElement) {                               // Upgrade or add an element
        if (elements[index] != null && elements[index].getElementLevel() != 3)
            elements[index].levelUpElement();
        else {
            elements[index] = newElement;
        }
    }

    public void changeActivatedElement(String elementType) {                    // Since you only can use one element at the time the player can change to another element (of the elements the player own)
        if (!elementSpelledCorrect(elementType))                                // check if user spelled the elementType correct
            throw new IllegalArgumentException();                               // Throw exception if the player has spelled the argument wrong

        else if (findElement(elementType) != null)
            activatedElement = findElement(elementType);
    }

    private boolean elementSpelledCorrect(String elementType){
        return elementType.equalsIgnoreCase("earth")                         // check if the elementType is correct spelled
                || elementType.equalsIgnoreCase("water")
                || elementType.equalsIgnoreCase("fire")
                || elementType.equalsIgnoreCase("wind");
    }

    // ITEMS-ARRAY METHODS ---------------------------------------------------------------------------------------------
    // The index each item has in the array "items":
    //    * index 0 = Armor
    //    * index 1 = Shoes
    //    * index 2 = Weapon

    public void addItem(Item newItem){                                                              // Add an item to the array items
        if (newItem instanceof Armor)
            switchAndAddItem(0, newItem);                                                     // Remove extra stats from potentially already existing armor
                                                                                                     // Add new armor
        else if (newItem instanceof Shoes)
            switchAndAddItem(1, newItem);                                                     // Remove extra stats from potentially already existing shoes
                                                                                                     // Add new shoes
        else
            switchAndAddItem(2, newItem);                                                   // Remove extra stats from potentially already existing weapon
                                                                                                    // Add new weapon
    }

    public Item findItem(Item itemType){                                                                                                       // Look if the player has an item of a special type (class). If yes -> fetch the item
        if (itemType != null){
            if (itemType instanceof Armor)
                return items[0];                       // Return armor

            else if (itemType instanceof Shoes)
                return items[1];                       // Return shoes

            else
                return items[2];                       // Return weapon
        }
        else
            throw new NullPointerException();
    }

    private void switchAndAddItem(int index, Item newItem) {            // Upgrade or add an element
        if (items[index] != null){                                      // The array with Items has predetermined places for each Item type. Therefor, if the
                                                                        // place for the certain index is empty, the player does not own an item of that type.

            if (checkIfSwitchItemIsPossible(newItem)){                  // Check if the player still has at least 1HP after the potential item switch
                itemDecreaseStats(items[index]);                        // Take back the extra stats that the item gives
            } else {
                throw new IllegalStateException();                      //TODO Är det rätt typ utav exception?
            }
        }
        items[index] = newItem;                                         // Replace the previous item with the new one
        itemIncreaseStats(newItem);                                     // Add the extra stats the new item gives
    }

    private boolean checkIfSwitchItemIsPossible(Item newItem) {
        boolean possible = true;                                                                // If this variable stays true it is possible to switch items.
        int currentItemsHP = findItem(newItem).getHP();                                         // FindItem fetches the current item with the same subclass as the
                                                                                                // new Item. Then we copy this items HP to the variable currentItemsHP.
        int newItemsHP = newItem.getHP();
        int HPDifference = newItemsHP - currentItemsHP;                                         // The difference between the two items HP.

        if (HPDifference < 0) {                                                                 // If the difference is more than 0 we now the currentHP will be more than 0.
            int newCurrentHP = (playerStats.getCurrentHP() - currentItemsHP) + HPDifference;
            if (newCurrentHP <= 0) {
                possible = false;                                                               // It is not possible to switch Item.
            }
        }
        return possible;
    }

    private void itemIncreaseStats(Item item){                              // Add extra stats from an item
        int power = item.getPower();
        int speed = item.getSpeed();
        int HP    = item.getHP();

        changeStatPowerTemporary(power);
        changeStatSpeedTemporary(speed);
        changeStatHPTemporary(HP);
    }

    private void itemDecreaseStats(Item item){                          // Take back extra stats from an item
        int power = item.getPower();
        int speed = item.getSpeed() ;
        int HP    = item.getHP();

        changeStatPowerTemporary((power * -1));
        changeStatSpeedTemporary((speed * -1));
        changeStatHPTemporary((HP * -1));
    }


    // ELEMENT MEDALLION METHODS ---------------------------------------------------------------------------------------
    public int fetchMedallionStatus(Element element) {
        if (element.getClass().isInstance(new EarthElement(1)))
            return earthMedallions;

        else if (element.getClass().isInstance(new WaterElement(1)))
            return waterMedallions;

        else if (element.getClass().isInstance(new FireElement(1)))
            return fireMedallions;

        else
            return windMedallions;
    }

    public void addMedallion(Element element) {
        if (element.getClass().isInstance(new EarthElement(1)) && earthMedallions < 3)
            earthMedallions++;

        else if (element.getClass().isInstance(new WaterElement(1)) && waterMedallions < 3)
            waterMedallions++;

        else if (element.getClass().isInstance(new FireElement(1)) && fireMedallions < 3)
            fireMedallions++;

        else if (element.getClass().isInstance(new WindElement(1)) && windMedallions < 3)
            windMedallions++;
    }

    public void resetMedallion(Element element) {                                                               //When the player has defeated a boss all the medallions for that element resets
        if (element.getClass().isInstance(new EarthElement(1)))
            earthMedallions = 0;

        else if (element.getClass().isInstance(new WaterElement(1)))
            waterMedallions = 0;

        else if (element.getClass().isInstance(new FireElement(1)))
            fireMedallions = 0;

        else if (element.getClass().isInstance(new WindElement(1)))
            windMedallions = 0;
    }

    // OTHER METHODS ---------------------------------------------------------------------------------------------------
    @Override
    public void attack(Character character) {                                       // Attack Enemy
        if (character instanceof Enemy) {
            int attackPower = getMainElement().attack(getTemporaryPower(), character.getMainElement());
            character.getStats().loseHP(attackPower);
        } else {
            throw new ClassCastException();
        }
    }

    // OTHER METHODS ---------------------------------------------------------------------------------------------------
    public void levelUp() {                                         // Level up the player
        int changeToThisLevel = getLevel() + 1;
        setLevel(changeToThisLevel);
        playerStats.levelStatsUp();                                 // When the player moves up a level the player´s default stats increases
    }

    // GET-METHODS -----------------------------------------------------------------------------------------------------
    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    @Override
    public Stats getStats() {
        return playerStats;
    }

    public int getCurrentHP() {            // If for example an enemy attack the player and the player no longer has a "full HP-tank"
        return playerStats.getCurrentHP();
    }

    public int getTemporaryHPFromStats(){           // If for example an item increase the "HP-tank"
        return playerStats.getTemporaryHP();
    }

    public int getTemporaryPower() {
        return playerStats.getTemporaryPower();
    }

    public int getTemporarySpeed() {
        return playerStats.getTemporarySpeed();
    }

    public Element getActivatedElement() {
        return activatedElement;
    }
}

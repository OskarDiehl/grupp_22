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

    // OTHER METHODS ---------------------------------------------------------------------------------------------------
    public void levelUp() {                                         // Level up the player
        int changeToThisLevel = getLevel() + 1;
        setLevel(changeToThisLevel);
        playerStats.levelStatsUp();                                 // When the player moves up a level the player´s default stats increases
    }

    public void changeStatPowerTemporary(int powerAmount) {         // Change the stats for power temporary
        playerStats.changePowerTemporary(powerAmount);
    }

    public void changeStatSpeedTemporary(int speedAmount) {         // Change the stats for speed temporary
        playerStats.changeSpeedTemporary(speedAmount);
    }

    public void changeStatHPTemporary(int HPAmount){                // Change the stats for HP temporary
        playerStats.changeHPTemporary(HPAmount);
    }

    public void resetStatsForPowerAndSpeed() {                      // Resets the stats for power, speed and HP
        playerStats.resetPowerAndSpeedToDefaultValues();
    }


    @Override
    public void attack(Character character) {                       // Attack Enemy
    //TODO HJÄLP JAG FÖRSTÅR INTE /MALIN
    }

    // ELEMENTS METHODS ------------------------------------------------------------------------------------------------
    // The index each element has in the array "elements":
    //   * index 0 = Earth element
    //   * index 1 = Water element
    //   * index 2 = Fire element
    //   * index 3 = Air element

    public void addElement(Element newElement) {
        if (newElement.getClass().isInstance(new EarthElement(1))) {          // For earth elements
            upgradeOrAddElement(0, newElement);                                    //... upgrade or add earth element

        } else if (newElement.getClass().isInstance(new WaterElement(1)))     // For water elements
            upgradeOrAddElement(1, newElement);                                    //... upgrade or add water element

        else if (newElement.getClass().isInstance(new FireElement(1)))        // For fire elements
            upgradeOrAddElement(2, newElement);                                    //... upgrade or add fire element

        else                                                                               // For wind elements
            upgradeOrAddElement(3, newElement);                                    //... upgrade or add wind element
    }

    public Element findElement(String elementType) {                                                                                   // Checks if the player has an certain element
        if (elementType.toLowerCase().equals("earth") && elements[0] != null && elements[0].getClass().isInstance(new EarthElement(2)))
            return elements[0];
        else if (elementType.toLowerCase().equals("water") && elements[1] != null && elements[1].getClass().isInstance(new WaterElement(2)))
            return elements[1];
        else if (elementType.toLowerCase().equals("fire") && elements[2] != null && elements[2].getClass().isInstance(new FireElement(3)))
            return elements[2];
        else if (elementType.toLowerCase().equals("wind") && elements[3] != null && elements[3].getClass().isInstance(new WindElement(1)))
            return elements[3];
        else if (elementType.toLowerCase().equals("earth")
                || elementType.toLowerCase().equals("water")
                || elementType.toLowerCase().equals("fire")
                || elementType.toLowerCase().equals("wind")){
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

    public void changeActivatedElement(String elementType) {                                        // Since you only can use one element at the time...
        if (elementType.toLowerCase().equals("earth")                                               // check if user spelled the elementType correct
                || elementType.toLowerCase().equals("water")
                || elementType.toLowerCase().equals("fire")
                || elementType.toLowerCase().equals("wind")) {
            Element chosenElement = findElement(elementType);                                       //... the player can change to another element (of the elements the player own)
            if (chosenElement != null)
                activatedElement = chosenElement;
        }
        else
            System.out.println("Can´t find the a element of the type you wish.");                   // If the player don´t have the element yet or spelled the argument wrong.
    }

    // ITEMS-ARRAY METHODS ---------------------------------------------------------------------------------------------
    // The index each item has in the array "items":
    //    * index 0 = Armor
    //    * index 1 = Shoes
    //    * index 2 = Weapon

    public void addItem(Item newItem){                                                              // Add an item to the array items
        if (newItem.getClass().isInstance(new Armor(null,0,0)))
            switchAndAddItem(0, newItem);                                                     // Remove extra stats from potentially already existing armor
                                                                                                     // Add new armor
        else if (newItem.getClass().isInstance(new Shoes(null,0,0)))
            switchAndAddItem(1, newItem);                                                     // Remove extra stats from potentially already existing shoes
                                                                                                     // Add new shoes
        else
            switchAndAddItem(2, newItem);                                                   // Remove extra stats from potentially already existing weapon
                                                                                                    // Add new weapon
    }

    public Item findItem(String itemType){                                                                                                       // Look if the player has an item of a special type (class). If yes -> fetch the item
        if (itemType.toLowerCase().equals("armor") && items[0].getClass().isInstance(new Armor("Armor", 0, 0)))
            return items[0];                                                                                                                     // Return armor

        else if (itemType.toLowerCase().equals("shoes") && items[1].getClass().isInstance(new Shoes("Shoes",0,0)))
            return items[1];                                                                                                                     // Return shoes

        else if (itemType.toLowerCase().equals("weapon") && items[2].getClass().isInstance(new Weapon("Weapon",0,0)))
                return items[2];                                                                                                                 // Return weapon
        else
            return null;
    }

    private void switchAndAddItem(int index, Item newItem) {                  // Upgrade or add an element
        if (items[index] != null)
            itemDecreaseStats(items[index]);

        items[index] = newItem;
        itemIncreaseStats(newItem);                                          // Add extra stats from the new item
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

    public int getCurrentHPFromStats() {            // If for example an enemy attack the player and the player no longer has a "full HP-tank"
        return playerStats.getCurrentHP();
    }

    public int getTemporaryHPFromStats(){           // If for example an item increase the "HP-tank"
        return playerStats.getTemporaryHP();
    }

    public int getTemporaryPowerFromStats() {
        return playerStats.getTemporaryPower();
    }

    public int getTemporarySpeedFromStats() {
        return playerStats.getTemporarySpeed();
    }

    public Element getActivatedElement() {
        return activatedElement;
    }
}

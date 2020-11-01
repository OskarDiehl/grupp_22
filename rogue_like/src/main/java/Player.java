public class Player extends Character {

    // DATASAMLING/-AR -------------------------------------------------------------------------------------------------
    private Element elements[] = new Element[4];        // Array containing different elements the player has collected
    private Item items[] = new Item[3];                 // Array containing different items the player has picked up

    // INSTANCE VARIABLES ----------------------------------------------------------------------------------------------
    private String name;
    private Role role;
    private PlayerStats playerStats;
    private Element activatedElement;     // The element the player use at the moment (You can only use one at the time)

    private int earthMedallions = 0;      // When the player has completed a room ze earns a medallion. There are
    private int waterMedallions = 0;      // four different kind of medallions, one for each element.
    private int fireMedallions = 0;       //      If the player has three of one sort, the next room will be a
    private int windMedallions = 0;       // boss room for the element the three medallions symbolize.
                                          //      When the player defeats the boss, ze will either earn or upgrade
                                          // the element for the boss room. It depends on if ze already has the object.


    //TODO fixa switch för level?

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

    public void changeStatPower(int powerAmount) {                  // Changes the stats for power
        playerStats.changePowerTemporary(powerAmount);
    }

    public void changeStatSpeed(int speedAmount) {                  // Changes the stats for speed
        playerStats.changeSpeedTemporary(speedAmount);
    }

    public void resetStatsForPowerAndSpeed() {                      // Resets the stats for power and speed
        playerStats.resetPowerAndSpeedToDefaultValues();
    }

    @Override
    public void attack(Character character) {
        //TODO fixa attack-metod
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

        else if (newElement.getClass().isInstance(new WindElement(1)))        // For wind elements
            upgradeOrAddElement(3, newElement);                                    //... upgrade or add wind element
        else
            throw new NullPointerException();  //TODO HUR FANKEN FÅR JAG MED DEN HÄR I COVERAGE?! /Malin

        //   throw new IllegalArgumentException("Error: no allowed element is chosen");
        //TODO kalla på ngt exception?

        //TODO Jag behöver ngn metod som returnerar vilken typ av element som det är /Malin
    }

    public Element findElement(String elementType) {                                                                                   // Checks if the player has an certain element
        if (elementType.toLowerCase().equals("earth") && elements[0].getClass().isInstance(new EarthElement(2)))
            return elements[0];
        else if (elementType.toLowerCase().equals("water") && elements[1].getClass().isInstance(new WaterElement(2)))
            return elements[1];
        else if (elementType.toLowerCase().equals("fire") && elements[2].getClass().isInstance(new FireElement(3)))
            return elements[2];
        else if (elementType.toLowerCase().equals("wind") && elements[3].getClass().isInstance(new WindElement(1)))
            return elements[3];
        else
            return null;        //TODO TA UPP bra lösning? /Malin      Fixa illegalargument
    }

    private void upgradeOrAddElement(int index, Element newElement) {                     // Upgrade or add an element
        if (elements[index] != null && elements[index].getElementLevel() != 3)
            elements[index].levelUpElement();
        else {
            elements[index] = newElement;
        }
    }

    public void changeActivatedElement(String elementType) {                              // Since you only can use one element at the time...
        Element chosenElement = findElement(elementType);                                 //... the player can change to another element (of the elements the player own)
        if (chosenElement != null)
            activatedElement = chosenElement;
        else
            System.out.println("Type again please");   //TODO MALIN FIXA DIN LILLA BAJSFIA /Malin
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
//
//    public void addItem2(Item newItem){                                                              // Add an item to the array items
//        if (newItem.getClass().isInstance(new Armor(null,0,0))) {
//            switchPotentiallyExistingItem(new Armor("Armor", 0, 0));            // Remove extra stats from potentially already existing armor
//            items[0] = newItem;                                                                     // Add new armor
//        }
//        else if (newItem.getClass().isInstance(new Shoes(null,0,0))){
//            switchPotentiallyExistingItem(new Shoes("Shoes", 0, 0));         // Remove extra stats from potentially already existing shoes
//            items[1] = newItem;                                                                     // Add new shoes
//        }
//
//        else{
//            switchPotentiallyExistingItem(new Weapon("Weapon", 0, 0));          // Remove extra stats from potentially already existing weapon
//            items[2] = newItem;                                                                     // Add new weapon
//        }
//
//        itemIncreaseStats(newItem);                                                                 // Add extra stats from the new item
//    }

    public Item findItem(String itemType){                                                                                                       // Look if the player has an item of a special type (class). If yes -> fetch the item
        if (itemType.toLowerCase().equals("armor") && items[0].getClass().isInstance(new Armor("Armor", 0, 0)))
            return items[0];                                                                                                                     // Return armor

        else if (itemType.toLowerCase().equals("shoes") && items[1].getClass().isInstance(new Shoes("Shoes",0,0)))
            return items[1];                                                                                                                     // Return shoes

        else if (itemType.toLowerCase().equals("weapon") && items[2].getClass().isInstance(new Weapon("Weapon",0,0)))
                return items[2];                                                                                                                 // Return weapon
        else
            return null;                                                      //TODO TA UPP bra lösning? /Malin
    }

    private void switchAndAddItem(int index, Item newItem) {                  // Upgrade or add an element
        if (items[index] != null)
            dropItemDecreaseStats(items[index]);

        items[index] = newItem;
        itemIncreaseStats(newItem);                                          // Add extra stats from the new item
    }

//    public Item findItem2(String itemType){                                                                                                       // Look if the player has an item of a special type (class). If yes -> fetch the item
//        if (itemType.toLowerCase().equals("armor") && items[0].getClass().isInstance(new Armor("Armor", 0, 0))){
//            return items[0];                                                                                                                     // Armor
//        }
//
//        else if (itemType.toLowerCase().equals("shoes") && items[1].getClass().isInstance(new Shoes("Shoes",0,0))){
//            return items[1];                                                                                                                     // Shoes
//        }
//
//        else if (itemType.toLowerCase().equals("weapon") && items[2].getClass().isInstance(new Weapon("Weapon",0,0))){
//            return items[2];                                                                                                                     // Weapon
//        }
//        else
//            return null;                                //TODO TA UPP bra lösning? /Malin
//    }

//    private void switchPotentiallyExistingItem(Item itemType){
//        if (findItem(itemType) != null)                                     // Check if there already exist an item with the certain itemType...
//            dropItemDecreaseStats(findItem(itemType));                      // ... if it exist -> take back the extra stats the item gave
//    }

    private void itemIncreaseStats(Item item){                              // Add extra stats from an item
        int power = item.getPower();
        int speed = item.getSpeed();
        int HP    = item.getHP();

        changeStatPower(power);
        changeStatSpeed(speed);
        playerStats.gainHP(HP);
    }

    private void dropItemDecreaseStats(Item item){                          // Take back extra stats from an item
        int power = item.getPower();
        int speed = item.getSpeed() ;
        int HP    = item.getHP();

        changeStatPower((power * -1));
        changeStatSpeed((speed * -1));
        playerStats.loseHP((HP * -1));
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

    public int getCurrentHPFromStats() {
        return playerStats.getCurrentHP();
    }

    public int getCurrentPowerFromStats() {
        return playerStats.getCurrentPower();
    }

    public int getCurrentSpeedFromStats() {
        return playerStats.getCurrentSpeed();
    }

    public Element getActivatedElement() {
        if (activatedElement != null)
            return activatedElement;
        else
            throw new NullPointerException("Error: No activated element"); //TODO Testa Malin
    }
}

public class Player extends Character {

    // DATASAMLING/-AR -------------------------------------------------------------------------------------------------
    private Element elements[] = new Element[4];
    private Item items[] = new Item[3];

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

    public void changeStatHP(int hp) {                              // Changes the stats for HP
        playerStats.changeCurrentHP(hp);
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

    public Element findElement(String elementType) {
        if (elementType.toLowerCase().equals("earth") && elements[0].getClass().isInstance(new EarthElement(2)))            // Checks if the player has an certain element
            return elements[0];
        else if (elementType.toLowerCase().equals("water") && elements[1].getClass().isInstance(new WaterElement(2)))
            return elements[1];
        else if (elementType.toLowerCase().equals("fire") && elements[2].getClass().isInstance(new FireElement(3)))
            return elements[2];
        else if (elementType.toLowerCase().equals("wind") && elements[3].getClass().isInstance(new WindElement(1)))
            return elements[3];
        else
            return null;        //TODO TA UPP bra lösning? /Malin
    }

    // ITEMS-ARRAY METHODS ---------------------------------------------------------------------------------------------
    // The index each item has in the array "items":
    //    * index 0 = Armor
    //    * index 1 = Shoes
    //    * index 2 = Weapon

    public void addItem(Item newItem){                                                          // Add an item to the array items  TODO gör private?
        if (newItem.getClass().isInstance(new Armor(null,0,0)))             // Add armor
            items[0] = newItem;

        else if (newItem.getClass().isInstance(new Shoes(null,0,0)))     // Add shoes
            items[1] = newItem;

        else
            items[2] = newItem;                                                                 // Add weapon

        itemIncreaseStats(newItem);
    }

    public Item getItem(String itemType){                                                                                                       // Look if the player has an item of a special type (class). If yes -> fetch the item
        if (itemType.toLowerCase().equals("armor") && items[0].getClass().isInstance(new Armor(null, 0, 0)))
            return items[0];                                                                                                                    // Armor
        else if (itemType.toLowerCase().equals("shoes") && items[1].getClass().isInstance(new Shoes(null,0,0)))
            return items[1];                                                                                                                    // Shoes
        else if (itemType.toLowerCase().equals("weapon") && items[2].getClass().isInstance(new Weapon(null,0,0)))
            return items[2];                                                                                                                    // Weapon
        else
            return null;                                //TODO TA UPP bra lösning? /Malin
    }

    public void addOrSwitchItem(Item newItem){          //TODO fixa Malin /Malin

    }

    public void dropItem(String itemType){              //TODO fixa Malin /Malin

    }

    private void itemIncreaseStats(Item item){
        int power = 0; /* = item.getPower();              TODO Vänta på att Oskar kanske fixar med abstrakta metoder :) /Malin */
        int speed = 0;
        int hp = 0;
        //TODO fixa för HP
        changeStatPower(power);
        changeStatSpeed(speed);
        changeStatHP(hp);
    }

    private void dropItemDecreaseStats(Item item){
        int power = 0; /* = item.getPower();              TODO Vänta på att Oskar kanske fixar med abstrakta metoder :) /Malin */
        int speed = 0 ;
        int hp = 0;                                     //TODO multiplicera med -1 på allt /Malin
        //TODO fixa för HP
        changeStatPower(power);
        changeStatSpeed(speed);
        // a
        changeStatHP(hp);
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

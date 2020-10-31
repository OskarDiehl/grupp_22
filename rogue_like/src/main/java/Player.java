public class Player extends Character {

    // DATASAMLING/-AR -------------------------------------------------------------------------------------------------
    private Element elements[] = new Element[4];
    private Item items[] = new Item[3];

    //Earth element == index 0
    //Water element == index 1
    //Fire element  == index 2
    //Air element   == index 3


    //Tar man ett Item börjar det verka direkt  /Vapen, rustning, skor

    // INSTANCE VARIABLES ----------------------------------------------------------------------------------------------
    private int currentLevel = 1;
    private Role role;
    private PlayerStats playerStats;
    private int earthMedallions = 0;
    private int waterMedallions = 0;
    private int fireMedallions = 0;
    private int windMedallions = 0;
    private int ownedElements = 0;

    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------
    public Player(String name, Element element, Role role) {
        super(name, element);
        //this.level = getCurrentLevel();   TODO Fråga Sabina /Malin
        this.role = role;
        this.playerStats = new PlayerStats(role.getHP(), role.getPower(), role.getSpeed());
        addElement(element);
    }

    // OTHER METHODS ---------------------------------------------------------------------------------------------------
    public void levelUp() {
        if (currentLevel < 3) {
            currentLevel++;
            levelUpChangeStats();
        } else
            currentLevel = 3;
    }

    public void levelUpChangeStats() {                              // When the player moves up a level the player´s default stats increases
        playerStats.levelStatsUp();
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


    // ELEMENTS-ARRAY METHODS ------------------------------------------------------------------------------------------
    public void addElement(Element newElement) {
        if (newElement.getClass().isInstance(new EarthElement(1))) {          //For earth elements
            upgradeOrAddElement(0, newElement);                                    //... upgrade or add earth element
        } else if (newElement.getClass().isInstance(new WaterElement(1)))       //For water elements
            upgradeOrAddElement(1, newElement);                                    //... upgrade or add water element

        else if (newElement.getClass().isInstance(new FireElement(1)))        //For fire elements
            upgradeOrAddElement(2, newElement);                                    //... upgrade or add fire element

        else if (newElement.getClass().isInstance(new WindElement(1)))        //For wind elements
            upgradeOrAddElement(3, newElement);                                    //... upgrade or add wind element

        //TODO kalla på ngt exception?

        //TODO Jag behöver ngn metod som returnerar vilken typ av element som det är /Malin
    }

    private void upgradeOrAddElement(int index, Element newElement) {
        if (elements[index] != null && elements[index].getElementLevel() != 3)
            elements[index].levelUpElement();
        else {
            elements[index] = newElement;
            ownedElements++;
        }
    }

    public String returnOwnedElements(){
        String mainElement = null;
        for (int i = 0 ; i < elements.length ; i++){
            if (elements[i] != null)
                mainElement = theMainElement(i);
        }
        return mainElement;
    }

    public String theMainElement(int index){
        if (index == 0)
            return "Earth";
        else if (index == 1)
            return "Water";
        else if (index == 2)
            return "Fire";
        else
            return "Wind";
    }


    // ITEMS-ARRAY METHODS ---------------------------------------------------------------------------------------------
    private void addItem(Item newItem) {

        //metod som på ngt vis lägger till ett item och eventuellt byter mot ett annat.

        //TODO Vad sägs om följande? /Malin  :
        // 1. Ta reda på vilket typ av item.
        // 2. Om användaren redan har ett item av den typen -> Fråga användaren om hen vill byta ut item.
        // 3. Om användaren säger ja -> Byt. Annars avbryt?
    }

    //Bestämda index för array:en med items
    //Armor = index 0
    //Shoes = index 1
    //Weapon = index 2

    // ELEMENT MEDALLION METHODS ---------------------------------------------------------------------------------------
    public int fetchMedallionStatus(Element element) {
        if (element.getClass().isInstance(new EarthElement(1)))
            return earthMedallions;
        else if (element.getClass().isInstance(new WaterElement(1)))
            return waterMedallions;
        else if (element.getClass().isInstance(new FireElement(1)))
            return fireMedallions;
        else /*if (element.getClass().isInstance(new WindElement(1)))*/
            return windMedallions;
        //TODO lösa det här eller ta bort? /Malin
//        else                      eller detta?
//            throw new IllegalArgumentException("Error: Can´t find the element");

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
        //TODO Snacka med David om att kalla på metod om man nått tre medaljer? /Malin

    }

    public void resetMedallions() {                      //When the player has defeated a boss all the medallions disappears
        earthMedallions = 0;
        waterMedallions = 0;
        fireMedallions = 0;
        windMedallions = 0;
    }


    // GET-METHODS -----------------------------------------------------------------------------------------------------
    public Element[] getElementsList() {
        return elements;
    }

    //TODO getElement /Malin

    public Item[] getItemsList() {
        return items;
    }

    public Role getRole() {
        return role;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public int getCurrentLevel() {
        return currentLevel;
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

    public int getEarthMedallions() {
        return earthMedallions;
    }

    public int getWaterMedallions() {
        return waterMedallions;
    }

    public int getFireMedallions() {
        return fireMedallions;
    }

    public int getWindMedallions() {
        return windMedallions;
    }
}


//Oskar här! Tänker att det kan vara bra att ha en metod som samlar stats från de olika items som spelaren har.
//Kommenterar bort metoderna nu i alla fall så att den inte stör med det du gör.
    /*public int getItemPower() {
        int itemPower = 7; //7 är en placeholder tills vi kan hämta power från items.
        return itemPower;
    }

    public int getItemSpeed() {
        int itemSpeed = 5; //Placeholder
        return itemSpeed;
    }

    public int getItemHP() {
        int itemHP = 3; //Placeholder
        return itemHP;
    }*/


//Möjlig lösning utan att ändra på mycket saker, omvandlar negativa tal och sätter false på increase i metoden den kallar på.
    /*public void doStuffWithChangePower(int amount){
        if (amount >-1) {
            changePower(true,amount);
        } else {
            amount = amount * -1;
            changePower(false, amount);
        }
    }*/

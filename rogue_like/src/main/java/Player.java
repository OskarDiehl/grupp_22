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
    private Role role;
    private PlayerStats playerStats;
    private int earthMedallions = 0;
    private int waterMedallions = 0;
    private int fireMedallions = 0;
    private int windMedallions = 0;
    private Element activatedElement;
    private String name;

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
    public void levelUp() {
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
        else
            throw new NullPointerException();  //TODO HUR FANKEN FÅR JAG MED DEN HÄR I COVERAGE?! /Malin

        //   throw new IllegalArgumentException("Error: no allowed element is chosen");
        //TODO kalla på ngt exception?

        //TODO Jag behöver ngn metod som returnerar vilken typ av element som det är /Malin
    }

    private void upgradeOrAddElement(int index, Element newElement) {
        if (elements[index] != null && elements[index].getElementLevel() != 3)
            elements[index].levelUpElement();
        else {
            elements[index] = newElement;
        }
    }

    public void changeActivatedElement(String elementType) {
        Element chosenElement = findElement(elementType);
        if (chosenElement != null)
            activatedElement = chosenElement;
        else
            System.out.println("Type again please");   //TODO MALIN FIXA DIN LILLA BAJSFIA /Malin
    }

    public Element findElement(String elementType) {
        if (elementType.toLowerCase().equals("earth") && elements[0].getClass().isInstance(new EarthElement(2)))
            return elements[0];
        else if (elementType.toLowerCase().equals("water") && elements[1].getClass().isInstance(new WaterElement(2)))
            return elements[1];
        else if (elementType.toLowerCase().equals("fire") && elements[2].getClass().isInstance(new FireElement(3)))
            return elements[2];
        else if (elementType.toLowerCase().equals("wind") && elements[3].getClass().isInstance(new WindElement(1)))
            return elements[3];
        else
            return null;
    }

    // ITEMS-ARRAY METHODS ---------------------------------------------------------------------------------------------
//    private void addItem(Item newItem) {
//
//        //metod som på ngt vis lägger till ett item och eventuellt byter mot ett annat.
//
//        //TODO Vad sägs om följande? /Malin  :
//        // 1. Ta reda på vilket typ av item.
//        // 2. Om användaren redan har ett item av den typen -> Fråga användaren om hen vill byta ut item.
//        // 3. Om användaren säger ja -> Byt. Annars avbryt?
//    }

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

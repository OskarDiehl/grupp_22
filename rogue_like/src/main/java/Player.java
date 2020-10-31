import java.util.Set;

public class Player extends Character {

    // DATASAMLING/-AR -------------------------------------------------------------------------------------------------
    private Element elements[] = new Element[4];
    private Item items[] = new Item[3];

    //Earth element == index 0
    //Water element == index 1
    //Fire element  == index 2
    //Air element   == index 3


    //Alla elementen har olika index. ArrayLocation? Om det finns lägg in vatten element
    //Tar man ett Item börjar det verka direkt  /Vapen, rustning, skor

    // INSTANCE VARIABLES ----------------------------------------------------------------------------------------------
    private int currentLevel = 1;
    private Role role;
    private PlayerStats playerStats;
    private int earthMedallions = 0;
    private int waterMedallions = 0;
    private int fireMedallions = 0;
    private int airMedallions = 0;

    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------
    public Player(String name, Element element, Role role) {
        super(name, element);
        //this.level = getCurrentLevel();   TODO Fråga Sabina /Malin
        this.role = role;
        this.playerStats = new PlayerStats(role.getHP(), role.getPower(), role.getSpeed());
        //TODO Skapa metod som lägger in elementet i elements /Malin

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
    private void addElement(Element newElement) {
      /*  if (newElement.getClass().isInstance(newElement) || newElement.getClass() instanceof new FireElement(1)){

        }*/
       /* if (newElement.getName.equals("Earth element")) TODO be Oskar fixa getName eller annan lösning för elementen
            checkIfPlayerHasElement(0, newElement);

        else if (newElement.getName.equals("Water element"))
            checkIfPlayerHasElement(1, newElement);

        else if (newElement.getName.equals("Fire element"))
            checkIfPlayerHasElement(2, newElement);

        else if (newElement.getName.equals("Air element"))
            checkIfPlayerHasElement(3, newElement);

        else */
            //TODO kalla på ngt exception?

        //TODO Jag behöver ngn metod som returnerar vilken typ av element som det är /Malin


        //TODO fixa olika if-satser för vart elementet ska placeras i Arrayen /Malin
    }


    private void upgradeElement(int index, Element newElement) {
        if (elements[index].getElementLevel() != 3) {
            //TODO Be Oskar fixa metod som levlar upp ett element.
        }
    }

    private void checkIfPlayerHasElement(int index, Element newElement) {
        if (elements[index] != null)
            upgradeElement(index, newElement);
        else
            elements[index] = newElement;
    }


    // ITEMS-ARRAY METHODS ---------------------------------------------------------------------------------------------
    private void addItem(Item newItem){
        //TODO Vad sägs om följande? /Malin  :
        // 1. Ta reda på vilket typ av element.
        // 2. Om användaren redan har ett item av den typen -> Fråga användaren om hen vill byta ut item.
        // 3. Om användaren säger ja -> Byt. Annars avbryt?
    }

    //Bestämda index för array:en med items
    //Armor = index 0
    //Shoes = index 1
    //Weapon = index 2

    // ELEMENT MEDALLION METHODS ---------------------------------------------------------------------------------------
    public int fetchMedallionStatus(Element element){
        if (element.getClass().isInstance(new EarthElement(1)))
            return earthMedallions;
        else
            return 3;

    }

    //hämta intarna (tar in element eller string som parameter)

    //restet medaljerna för just det elementet



    // GET-METHODS -----------------------------------------------------------------------------------------------------
    public Element[] getElementsList() {
        return elements;
    }

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

    public int getAirMedallions() {
        return airMedallions;
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

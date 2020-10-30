public class Player extends Character {

    // DATASAMLING/-AR -----------------------------------------------------
    private Element elements[] = new Element[4];
    private Item items[] = new Item[3];


    //Alla elementen har olika index. ArrayLocation? Om det finns lägg in vatten element
    //Tar man ett Item börjar det verka direkt  /Vapen, rustning, skor

    // INSTANCE VARIABLES ---------------------------------------------------
    private int currentLevel = 1;
    private Role role;
    private PlayerStats playerStats;
    //intar för medaljonger)


    // CONSTRUCTOR ----------------------------------------------------------
    public Player(String name, Element element, Role role) {
        super(name, element);
       //this.level = getCurrentLevel();   TODO Fråga Sabina /Malin
        this.role = role;
        this.playerStats = new PlayerStats(role.getHP(),role.getPower(),role.getSpeed());

    }

    // OTHER METHODS --------------------------------------------------------
    public void levelUp() {
        if (currentLevel < 3){
            currentLevel++;
            levelUpChangeStats();
        } else
            currentLevel = 3;
    }

    public void levelUpChangeStats(){ //TODO Fixa metod som förändrar stats när man levlar upp. /Malin
        // levla upp stats
    }

    public void changeStatPower(int powerAmount){                  // Changes the stats for power
        playerStats.changePowerTemporary(powerAmount);
    }

    //Möjlig lösning utan att ändra på mycket saker, omvandlar negativa tal och sätter false på increase i metoden den kallar på.
    /*public void doStuffWithChangePower(int amount){
        if (amount >-1) {
            changePower(true,amount);
        } else {
            amount = amount * -1;
            changePower(false, amount);
        }
    }*/

    public void changeStatSpeed(int speedAmount){                  // Changes the stats for speed
        playerStats.changeSpeedTemporary(speedAmount);
    }

    public void resetStatsForPowerAndSpeed(){                               // Resets the stats for power and speed
        playerStats.resetPowerAndSpeedToDefaultValues();
    }


    // ELEMENTS-ARRAY METHODS --------------------------------------------------------
    public Element[] getElementsList(){
        return elements;
    }

    private void addElement(Element newElement){
        int index = 0; //TODO ta bort 0 när if-satserna nedan är fixade /Malin

        //TODO fixa olika if-satser för vart elementet ska placeras i Arrayen /Malin

        newElement = elements[index];
    }


    // ITEMS-ARRAY METHODS --------------------------------------------------------
    public Item[] getItemsList(){
        return items;
    }

    // GET-METHODS ----------------------------------------------------------
    public Role getRole() {
        return role;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentHPFromStats(){
        return playerStats.getCurrentHP();
    }

    public int getCurrentPowerFromStats(){
        return playerStats.getCurrentPower();
    }

    public int getCurrentSpeedFromStats(){
        return playerStats.getCurrentSpeed();
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
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


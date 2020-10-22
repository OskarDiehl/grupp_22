//TODO organisera metoder, alla enemy metoder borde vara ihop exempelvis.
//TODO lös ett bra sätt att ta fram om rummet ska vara ett LuckyWheel eller inte
//TODO lös ett sätt för att generera ett random element för rummet (om det inte är ett luckywheel rum)

public class Room {

     private final int STANDARD_THRESHOLD = 6;
     private final int MAX_THRESHOLD = 10;
     private final int MIN_THRESHOLD = 1;

     private final int MAX_AMOUNT_OF_ENEMIES = 7;
     private final int MIN_AMOUNT_OF_ENEMIES = 4;
     private final int MAX_NUMBER_LUCKY_WHEEL = 5;

     private Enemy enemies[];
     private int enemyQuantity;
     private String roomType;
     private Element element;
     private int threshold;

     public Room(){
         threshold = STANDARD_THRESHOLD;
         roomType = decideTypeOfRoom(false);

         spawnEnemies();

    }

    public boolean spawnItem() {
        return spawnItem(generateRandomNumber(MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public boolean spawnItem(int num){
        return spawnItem(num, threshold);
    }

    private boolean spawnItem(int num, int threshold){
        if( num >= threshold){
            return true;
        }
        return false;
    }


    public String decideTypeOfRoom(boolean isItLuckyWheel){
         if( decideIfLuckyWheelSpawn(isItLuckyWheel)){
            return "Lucky Wheel";
         }
         else {
             element = new FireElement(1);
             return "Enemy";
         }
    }


     public boolean decideIfLuckyWheelSpawn(boolean isItLuckyWheel){
         if(isItLuckyWheel){
             return true;
         }
         return false;

     }



    public void setThreshold(int threshold) {
        if (threshold > MAX_THRESHOLD || threshold < MIN_THRESHOLD) {
            throw new IllegalArgumentException();
        } else {
            this.threshold = threshold;
        }
    }

    public int getThreshold() {
        return threshold;
    }

    //När ett rum skapas finns det en threshold som avgör hur stor chans det är att man får dropp, ju lägre threshold är, ju större chans är det att man får drop.



    public void spawnEnemies(){
        enemyQuantity = generateAmountOfEnemies();
        enemies = new Enemy[enemyQuantity];

        for(int i = 0; i < enemyQuantity; i++){
            enemies[i] = new Enemy(getElement(), 1);
        }

    }

    public Element getElement() {
        return element;
    }

//TODO returnerar för tillfället bara en enemy, borde kanske returnera hela arrayen.
    public Enemy[] getEnemies(){
        return enemies;
    }


    public int generateAmountOfEnemies(){
         return generateRandomNumber(MIN_AMOUNT_OF_ENEMIES, MAX_AMOUNT_OF_ENEMIES);
     }

    public String getRoomType() {
        return roomType;
    }

    public int getEnemyQuantity() {
        return enemyQuantity;
    }

    //Denna nås av test genom andra metoder, men kan inte testas direkt eftersom den är privat.
//Man bör fråga sig om denna bör vara publik, samt att den har begränsingar (MIN < MAX exempelvis)
    public int generateRandomNumber(int min, int max) {

        if (min < 1  || max < 1 || min > max) {
            throw new IllegalArgumentException();
        } else {

            return (int) ((Math.random() * (max - min)) + min);

        }
    }
}

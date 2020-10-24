//TODO organisera metoder, alla enemy metoder borde vara ihop exempelvis.

//TODO lös ett bra sätt att ta fram om rummet ska vara ett LuckyWheel eller inte

//TODO lös ett sätt för att generera ett random element för rummet (om det inte är ett luckywheel rum)

//TODO rummet måste kunna komma åt en players "medaljonger" för att avgöra om det blir boss eller inte

//TODO ändra enemies till en arrayList

import java.util.ArrayList;

public class Room {

     private final int STANDARD_THRESHOLD = 6;
     private final int MAX_THRESHOLD = 10;
     private final int MIN_THRESHOLD = 1;

     private final int MAX_AMOUNT_OF_ENEMIES = 7;
     private final int MIN_AMOUNT_OF_ENEMIES = 4;
     private final int MAX_NUMBER_LUCKY_WHEEL = 5;

     private ArrayList<Enemy> enemies; //denna ska ändras till en arraylist efter funderande
     private int enemyQuantity;
     private String roomType;
     private Element element;
     private int threshold;

     //TODO borde player vara ett argument i konstruktorn?
     public Room(){
         threshold = STANDARD_THRESHOLD;
         decideTypeOfRoom(false);

/*         if(roomType.equals("Enemy")){
             if(player.getMedallions() == 3){
                 player.resetMedallions();
                 spawnBoss();
             }

             else {
                 spawnEnemies();
             }
         }

         else if(roomType.equals("Lucky Wheel")) {

             //spawnLuckyWheel();
         }

 */



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
         if( (isItLuckyWheel)){
            roomType = "Lucky Wheel";
         }
         else {
             element = new FireElement(1);
             roomType = "Enemy";
         }

         return roomType;
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
        enemies = new ArrayList();

        for(int i = 0; i < enemyQuantity; i++){
            enemies.add(new Enemy(getElement() , 1));

        }

    }

    public Element getElement() {
        return element;
    }


    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public boolean isEnemiesDead() {
        if (enemies.isEmpty()) {
            return true;
        }
        return false;

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

    //TODO måste denna kallas på av enemy klassen? när dennes hp går ner till 0? Isåfall måste man deklarera Enemy med ett Room kanske?
    //TODO man måste kanske ha något sätt att kolla så att enemyn faktiskt finns?

    public void removeEnemy(Enemy enemy){

         if(!enemies.isEmpty()){
             if(enemies.remove(enemy)){
                 return;
             }
             else {
                 throw new IllegalArgumentException();
             }
         }

    }


    //Denna nås av test genom andra metoder, men kan inte testas direkt eftersom den är privat.
    //Man bör fråga sig om denna bör vara publik, samt att den har begränsingar (MIN <= MAX exempelvis)
    public int generateRandomNumber(int min, int max) {

        if (min < 1  || max < 1 || min > max) {
            throw new IllegalArgumentException();
        } else {

            return (int) ((Math.random() * (max - min)) + min);

        }
    }
}

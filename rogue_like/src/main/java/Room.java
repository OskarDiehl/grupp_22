public class Room {
     String element; //ska ändras till Element klassen sen
     private final int STANDARD_THRESHOLD = 6;
     private final int MAX_THRESHOLD = 10;
     private final int MIN_THRESHOLD = 1;

     private final int MAX_AMOUNT_OF_ENEMIES = 7;
     private final int MIN_AMOUNT_OF_ENEMIES = 4;

     private int threshold;

     public Room(){


        threshold = STANDARD_THRESHOLD;
        this.element = "Fire";
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

    public void decideTypeOfRoom(){

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
         int quantity = generateAmountOfEnemies();

    }
    public int generateAmountOfEnemies(){
         return generateRandomNumber(MIN_AMOUNT_OF_ENEMIES, MAX_AMOUNT_OF_ENEMIES);
     }





//Denna nås av test genom andra metoder, men kan inte testas direkt eftersom den är privat.
//Man bör fråga sig om denna bör vara publik, samt att den har begränsingar (MIN < MAX exempelvis)
    public int generateRandomNumber(int min, int max) {

        if (min < 1  || min >= max) {
            throw new IllegalArgumentException();
        } else {
            return (int) ((Math.random() * (max - min)) + min);

        }
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {




// Ska denna testas med tanke på att den är privat?
  @Test
    void shouldGenerateNumberBetweenOneAndTen(){

        Room room = new Room();
        int num = room.generateRandomNumber(1,10);

        assertTrue( 1 <= num && num <= 10, "num: " + num);
    }

    @Test
    void ifArgumentExceptionIsThrownWhenMinValueBelowOne(){

      Room room = new Room();
      assertThrows(IllegalArgumentException.class, () -> {
          room.generateRandomNumber(0, 5);
      });
    }


/*
    @Test
    void ifArgumentExceptionIsThrownWhenMaxValueAboveTen(){

        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.generateRandomNumber(2, 11);
        });
    }
*/


    //TODO ändra denna eftersom jag har ändrat logiken i generateRandomNumber
    @Test
    void ifArgumentExceptionIsThrownWhenMinValueIsMoreThanMaxValue(){

        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.generateRandomNumber(8, 7);
        });
    }

    @Test
    void spawnItemShouldBeTrue() {
        Room room = new Room();
        assertEquals(true, room.spawnItem(6));
    }

    @Test
    void spawnItemShouldBeFalse(){
        Room room = new Room();
        assertEquals(false, room.spawnItem(5));
    }

    @Test
    void spawnItemShouldBeTrueWithNewThreshold(){
        Room room = new Room();
        room.setThreshold(3);
        assertEquals(true, room.spawnItem(4));
    }

    @Test
    void spawnItemShouldBeFalseWithNewThreshold(){
        Room room = new Room();
        room.setThreshold(8);
        assertEquals(false, room.spawnItem(7));
    }


    @Test
    void ifThresholdValueChanges(){
        Room room = new Room();
        room.setThreshold(4);
        assertEquals(4, room.getThreshold());
    }

    @Test
    void spawnItemShouldBeTrueAfterSetThreshold(){
        Room room = new Room();
        room.setThreshold(1);
        assertTrue(room.spawnItem());
    }

    @Test
    void ifArgumentExceptionIsThrownWhenSetThresholdAboveTen() {
        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.setThreshold(13);
        });
    }

    @Test
    void ifArgumentExceptionIsThrownWhenSetThresholdBelowOne(){
        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.setThreshold(-1);
        });

    }



    //TODO denna borde kanske testa ALLA enemies, inte bara den första
    @Test void ifEnemiesAreTheRightElement(){
      Room room = new Room();

      assertTrue(room.getEnemies().get(3).getMainElement() instanceof FireElement);

    }

    //TODO eventuellt fundera på att inte använda array? Vad händer exempelvis när en fiende dör? Kanske lättare att hålla koll på när rummet är klart via en lista och sen bara kolla när den är tom.

    @Test void ifCorrectNumberOfEnemiesHaveBeenCreated(){
      Room room = new Room();

      assertEquals(room.getEnemyQuantity(), room.getEnemies().size());

    }




    @Test void GenerateAmountOfEnemiesIsTheCorrectIntervall(){

    }

    @Test
    void shouldGenerateElementForRoom(){
      Room room = new Room();
    }

    @Test
    void roomTypeShouldNotBeEmptyWhenCreatingRoom(){
      Room room = new Room();

      assertNotEquals(null, room.getRoomType());
  }

    //det finns de fyra element rummen + boss rummen för vardera + lyckohjulsrum
    @Test
    void roomTypeShouldBeLuckyWheel(){
      Room room = new Room();

      assertEquals("Lucky Wheel", room.decideTypeOfRoom(true));

      //eftersom maxIntervall är 1 borde det alltid bli rätt?
      // Testar så att när max intervallet är samma som det random numret så blir det true



      /*så när rummet skapas bör decideTypeOfRoom kallas på som bara avgör om det blir ett lyckohjulsrum eller inte (1/5).
      I ett senare skede bör det avgöras om spelaren har dem tre medaljongerna för att spawna en boss eller spawna enemies
      Kanske i en decideTypeOfEnemy metod.


      Men var ska informationen om vilken typ av rum det är sparas? Bör det finnas typ en sträng med "BOSS", "ENEMY" och "LUCKY WHEEL"
      Eller är det ens nödvändigt? Ska det bara vara om rummet inte har något Element ska det anses som lucky wheel?


       */

    }


    //TODO metoden decideTypeOfRoom borde alltså kallas med en metod som har en chans 1 / 5 att returnera true
    @Test
    void roomTypeShouldBeEnemy(){
        Room room = new Room();
        room.decideTypeOfRoom(false);

        assertEquals("Enemy", room.getRoomType());



    }

    @Test
    void roomShouldBeLuckyWheel(){
      Room room = new Room();
      room.decideTypeOfRoom(true);

      assertEquals("Lucky Wheel", room.getRoomType());


    }
    @Test
    void ifRemoveEnemyRemovesTheCorrectEnemy(){

    }

    @Test
    void itemShouldDropWhenAllEnemiesAreDead(){
        Room room = new Room();

        //room.checkIfEnemiesDead(){

        }


        /*
        Hur kontrollerar vi att alla enemies är döda?
        När en enemy är död måste det på något sätt skickas till Room, där vi sedan kan
        checka så att inte alla monster är döda. Om dem är döda så bör spawnItem kallas på.
         */


    }


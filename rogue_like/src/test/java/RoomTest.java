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
    void ifArgumentExceptionIsThrownWhenMinValueBelowOneOnGenerateRandomNumber(){

      Room room = new Room();
      assertThrows(IllegalArgumentException.class, () -> {
          room.generateRandomNumber(0, 5);
      });
    }

    @Test
    void getPlayerShouldReturnCorrectPlayer(){
    Player ply = new Player("test",new EarthElement(1),Role.Warrior);
    Room room = new Room(ply);

    assertEquals(ply, room.getPlayer());
    }





    @Test
    void ifArgumentExceptionIsThrownWhenMinValueIsMoreThanMaxValueInGenerateRandomNumber(){

        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.generateRandomNumber(8, 7);
        });
    }



    //TODO denna borde kanske testa ALLA enemies, inte bara den första
    @Test void ifEnemiesAreTheRightElement(){
      Room room = new Room();

      Element el = room.getElement();
     //assertTrue(room.getEnemies().get(3).getMainElement() instanceof el.getClass());
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

      while(room.getRoomType() != "Lucky Wheel"){
        room = new Room();
      }
      assertEquals("Lucky Wheel", room.getRoomType());
  }



  //eftersom maxIntervall är 1 borde det alltid bli rätt?
  // Testar så att när max intervallet är samma som det random numret så blir det true



      /*så när rummet skapas bör decideTypeOfRoom kallas på som bara avgör om det blir ett lyckohjulsrum eller inte (1/5).
      I ett senare skede bör det avgöras om spelaren har dem tre medaljongerna för att spawna en boss eller spawna enemies
      Kanske i en decideTypeOfEnemy metod.


      Men var ska informationen om vilken typ av rum det är sparas? Bör det finnas typ en sträng med "BOSS", "ENEMY" och "LUCKY WHEEL"
      Eller är det ens nödvändigt? Ska det bara vara om rummet inte har något Element ska det anses som lucky wheel?


       */


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

    @Test
    void elementShouldBeAddedToPlayerWhenKilledBoss(){

    }

    @Test
    void itemShouldDropWhenLuckyWheelIsActivated(){


    }

    @Test
    void enemyCantSpawnWhenPlayerHas3MedallionsOfRoomsElement(){
      FireElement elm = new FireElement(1);
      Player ply = new Player("test", elm, Role.Runner);
      ply.addMedallion(elm);
      ply.addMedallion(elm);
      ply.addMedallion(elm);

      Room room = new Room(ply, elm);

      while(room.getRoomType() == "Lucky Wheel") {
        room = new Room(ply, elm);
      }


      assertEquals("Boss",room.getRoomType());
    }



    @Test
    void bossCantSpawnWhenPlayerDoesNotHaveEnoughMedallionsOfRoomElement(){
      EarthElement elm = new EarthElement(1);
      Player ply = new Player("test", elm, Role.Runner);
      ply.addMedallion(elm);
      ply.addMedallion(elm);


      Room room = new Room(ply, elm);

      while(room.getRoomType() == "Lucky Wheel") {
        room = new Room(ply, elm);
      }

      assertNotEquals("Boss",room.getRoomType());

    }


        /*
        Hur kontrollerar vi att alla enemies är döda?
        När en enemy är död måste det på något sätt skickas till Room, där vi sedan kan
        checka så att inte alla monster är döda. Om dem är döda så bör spawnItem kallas på.
         */


    }


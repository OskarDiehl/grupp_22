import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {




// Ska denna testas med tanke på att den är privat?
  @Test
    void shouldGenerateNumberBetweenOneAndTen(){

        Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior));
        int num = room.generateRandomNumber(1,10);

        assertTrue( 1 <= num && num <= 10, "num: " + num);
    }

    @Test
    void ifArgumentExceptionIsThrownWhenMinValueBelowOneOnGenerateRandomNumber(){

      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior));
      assertThrows(IllegalArgumentException.class, () -> {
          room.generateRandomNumber(0, 5);
      });
    }

    @Test
    void decideTypeOfRoomReturnsLuckyWheelWhenTrue(){
      Room room = new Room(new Player("Test", new FireElement(1), Role.Runner));

      assertEquals("Lucky Wheel" , room.decideTypeOfRoom(true));
    }

    @Test
    void decideTypeOfRoomIsNotEnemy(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Runner));

        assertNotEquals("Enemy" , room.decideTypeOfRoom(true));
    }

    @Test
    void getPlayerShouldReturnCorrectPlayer(){
    Player ply = new Player("test",new EarthElement(1),Role.Warrior);
    Room room = new Room(ply);

    assertEquals(ply, room.getPlayer());
    }





    @Test
    void ifArgumentExceptionIsThrownWhenMinValueIsMoreThanMaxValueInGenerateRandomNumber(){

        Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior));
        assertThrows(IllegalArgumentException.class, () -> {
            room.generateRandomNumber(8, 7);
        });
    }



    //TODO denna borde kanske testa ALLA enemies, inte bara den första
    @Test void ifEnemiesAreTheRightElement(){
      Room room = new Room(new Player("Test", new FireElement(1), Role.Warrior), new EarthElement(1), "Enemy");

     assertTrue(room.getEnemies().get(3).getMainElement() instanceof EarthElement);
    }

    //TODO eventuellt fundera på att inte använda array? Vad händer exempelvis när en fiende dör? Kanske lättare att hålla koll på när rummet är klart via en lista och sen bara kolla när den är tom.

    @Test void ifCorrectNumberOfEnemiesHaveBeenCreated(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Enemy");

      assertEquals(room.getEnemyQuantity(), room.getEnemies().size());

    }




    @Test void GenerateAmountOfEnemiesIsTheCorrectIntervall(){

    }

    @Test
    void shouldGenerateElementForRoom(){
      Room room = new Room(new Player("Test", new FireElement(1), Role.Runner));

      assertNotEquals(null, room.getElement());

    }

    @Test
    void roomTypeShouldNotBeEmptyWhenCreatingRoom(){
      Room room = new Room(new Player("Test", new EarthElement(1), Role.Tank), new FireElement(1));

      assertNotEquals(null, room.getRoomType());
  }



    @Test
    void roomTypeShouldBeLuckyWheel(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Lucky Wheel");

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
        Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Enemy");


        assertEquals("Enemy", room.getRoomType());



    }

    @Test
    void roomShouldBeLuckyWheel(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Lucky Wheel");


      assertEquals("Lucky Wheel", room.getRoomType());


    }
    @Test
    void ifRemoveEnemyRemovesTheCorrectEnemy(){

    }

    @Test
    void removeEnemyShouldThrowIllegalArgumentWhenEnemyIsNotInEnemies(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Runner));
        Enemy enemy = new Enemy(room.getElement(), 1,room);

        assertThrows(IllegalArgumentException.class, () -> {
           room.removeEnemy(enemy);
        });

    }

    @Test
    void itemShouldDropWhenAllEnemiesAreDead(){
        Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior));



        //room.checkIfEnemiesDead(){

        }

    @Test
    void elementShouldBeAddedToPlayerWhenKilledBoss(){

    }

    @Test
    void iLLegalStateExceptionThrownWhenRemovingNonExistingBoss(){


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

      Room room = new Room(ply, elm, "Enemy");


      assertEquals("Boss",room.getRoomType());
    }



    @Test
    void bossCantSpawnWhenPlayerDoesNotHaveEnoughMedallionsOfRoomElement(){
      EarthElement elm = new EarthElement(1);
      Player ply = new Player("test", elm, Role.Runner);
      ply.addMedallion(elm);
      ply.addMedallion(elm);


      Room room = new Room(ply, elm, "Enemy");


      assertNotEquals("Boss",room.getRoomType());

    }

    @Test
    void isEnemiesDeadShouldReturnTrueWhenAllEnemiesRemoved(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior));

      ArrayList<Enemy>  enemies = room.getEnemies();

      for( Enemy e : enemies){
        room.removeEnemy(e);
      }

      assertTrue(room.isEnemiesDead());


    }

  @Test
  void isEnemiesDeadShouldReturnFalseWhenNotAllEnemiesRemoved(){
    Room room = new Room(new Player("Test", new FireElement(1), Role.Warrior), "Enemy");

    assertFalse(room.isEnemiesDead());


  }

  @Test
  void luckyWheelShouldBeCreatedWhenItHasSpawned(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior));

      while(room.getRoomType() != "Lucky Wheel"){
        room = new Room(new Player("test",new EarthElement(1),Role.Warrior));
      }

      assertTrue(room.getLuckyWheel() != null);

  }

  @Test
  void luckyWheelShouldntBeCreatedWhenItHasntSpawned(){
    Room room = new Room(new Player("test",new FireElement(1), Role.Tank), "Enemy");


    assertTrue(room.getLuckyWheel() == null);

  }

  @Test
  void itemDroppedShouldNotBeNullWhenAllEnemiesAreKilled(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), new EarthElement(1),"Enemy");


      ArrayList<Enemy> enemies = room.getEnemies();

      for(Enemy e: enemies){
        room.removeEnemy(e);
      }

      assertTrue(room.getItemDropped() != null);

  }

  @Test
  void itemDroppedShouldBeNullWhenEnemiesAreAlive(){

      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Enemy");



    assertTrue(room.getItemDropped() == null);

    }

  @Test
  void bossShouldNotBeNull(){
      FireElement elm = new FireElement(1);
      Player ply = new Player("test",elm, Role.Tank);

      ply.addMedallion(elm);
      ply.addMedallion(elm);
      ply.addMedallion(elm);

      Room room = new Room(ply, elm);

      while(room.getRoomType() == "Lucky Wheel"){
        room = new Room(ply, elm);
      }

      assertTrue(room.getBoss() != null);



  }

  @Test
  void bossShouldBeNull() {
    FireElement elm = new FireElement(1);
    Player ply = new Player("test", elm, Role.Tank);

    ply.addMedallion(elm);

    Room room = new Room(ply, elm);

    while (room.getRoomType() == "Lucky Wheel") {
      room = new Room(ply, elm);
    }

    assertTrue(room.getBoss() == null);


  }


  @Test
  void illegalArgumentShouldBeThrownWhenBossIsCalledAsRoomType(){


  }

  @Test
  void bossShouldBeRemoved(){
      Player ply = new Player("Test", new FireElement(1), Role.Tank);
      EarthElement elm = new EarthElement(1);
      ply.addMedallion(elm);
      ply.addMedallion(elm);
      ply.addMedallion(elm);

      Room room = new Room(ply, elm, "Enemy");
      room.removeBoss();

      assertTrue(room.getBoss() == null);
  }

  @Test
    void fireElementRoomShouldReturnFireElement(){
        Room room = new Room(new Player("Test", new EarthElement(1), Role.Warrior), new FireElement(1));

        assertTrue(room.getElement() instanceof FireElement);
  }

    @Test
    void earthElementRoomShouldReturnEarthElement(){
        Room room = new Room(new Player("Test", new EarthElement(1), Role.Warrior), new EarthElement(1));

        assertTrue(room.getElement() instanceof EarthElement);
    }

    @Test
    void waterElementRoomShouldReturnWaterElement(){
        Room room = new Room(new Player("Test", new EarthElement(1), Role.Warrior), new WaterElement(1));

        assertTrue(room.getElement() instanceof WaterElement);
    }

    @Test
    void waterElementRoomShouldReturnWindElement(){
        Room room = new Room(new Player("Test", new EarthElement(1), Role.Warrior), new WindElement(1));

        assertTrue(room.getElement() instanceof WindElement);
    }

    @Test
    void spawnEnemiesShouldReturnArrayListOfSameSizeAsEnemies(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Enemy");

        assertEquals(room.spawnEnemies().size(), room.getEnemies().size());

    }

    @Test
    void whenBossSpawnedBossShouldNotBeNull(){
        Player ply = new Player("Test", new FireElement(1), Role.Tank);

        Room room = new Room(ply, "Enemy");
        room.spawnBoss();

        assertNotNull(room.getBoss());


    }

    @Test
    void decideTypeOfElementShouldBeFire(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Enemy");

        assertTrue(room.decideTypeOfElement(1) instanceof FireElement);

    }

    @Test
    void decideTypeOfElementShouldBeWater(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Enemy");

        assertTrue(room.decideTypeOfElement(2) instanceof WaterElement);

    }

    @Test
    void decideTypeOfElementShouldBeWind(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Enemy");

        assertTrue(room.decideTypeOfElement(3) instanceof WindElement);

    }

    @Test
    void decideTypeOfElementShouldBeEarth(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Enemy");


        assertTrue(room.decideTypeOfElement(4) instanceof EarthElement);

    }


    @Test
    void decideTypeOfElementShouldThrowIllegalArgumentException(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Enemy");


        assertTrue(room.decideTypeOfElement(4) instanceof EarthElement);

    }













        /*
        Hur kontrollerar vi att alla enemies är döda?
        När en enemy är död måste det på något sätt skickas till Room, där vi sedan kan
        checka så att inte alla monster är döda. Om dem är döda så bör spawnItem kallas på.
         */


    }


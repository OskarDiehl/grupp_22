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
    void decideTypeOfRoomShouldBeEnemyWhenIsLuckyWheelFalse(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Runner));


        assertEquals("Enemy" , room.decideTypeOfRoom(false));
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
    void removeEnemyShouldThrowIllegalArgumentWhenEnemyIsNotInEnemies(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Runner), "Enemy");
        Enemy enemy = new Enemy(room.getElement(), 1,room);

        assertThrows(IllegalArgumentException.class, () -> {
           room.removeEnemy(enemy);
        });

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
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior),"Enemy");

      ArrayList<Enemy> enemies = room.getEnemies();

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
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Lucky Wheel");
      assertNotNull(room.getLuckyWheel());
  }

  @Test
  void luckyWheelShouldntBeCreatedWhenItHasntSpawned(){
    Room room = new Room(new Player("test",new FireElement(1), Role.Tank), "Enemy");


    assertNull(room.getLuckyWheel());

  }

  @Test
  void itemDroppedShouldNotBeNullWhenAllEnemiesAreKilled(){
      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), new EarthElement(1),"Enemy");


      ArrayList<Enemy> enemies = room.getEnemies();

      for(Enemy e: enemies){
        room.removeEnemy(e);
      }

      assertNotNull(room.getItemDropped());

  }

  @Test
  void itemDroppedShouldBeNullWhenEnemiesAreAlive(){

      Room room = new Room(new Player("test",new EarthElement(1),Role.Warrior), "Enemy");



    assertNull(room.getItemDropped());

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

      assertNotNull(room.getBoss());



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

    assertNull(room.getBoss());


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

      assertNull(room.getBoss());
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


        assertThrows(IllegalArgumentException.class, () -> {
            room.decideTypeOfElement(6);
        });

    }

    @Test
    void illegalStateExceptionThrownWhenRoomTypeIsNotLuckyWheel(){
        Room room = new Room(new Player("Test", new EarthElement(1), Role.Tank), "Enemy");

        assertThrows(IllegalStateException.class, () -> {
            room.spinTheLuckyWheel();
        });

    }

    @Test
    void itemDroppedFromLuckyWheelIsInstanceOfItem(){
        Room room = new Room(new Player("Test", new EarthElement(1), Role.Tank), "Lucky Wheel");
        room.spinTheLuckyWheel();

        while(room.getItemDropped() == null){
            room.spinTheLuckyWheel();
        }

        assertTrue(room.getItemDropped() instanceof Item);

    }

    @Test
    void givePlayerElementGivesElementToPlayer(){
      Player ply = new Player("Test", new FireElement(1), Role.Tank);
      Room room = new Room(ply, new EarthElement(1));
      room.givePlayerElement();
      assertTrue(ply.findElement("earth") instanceof EarthElement);

    }

    @Test
    void illegalArgumentThrownWhenRoomTypeNotEnemyOrLuckyWheel(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Room(new Player("Test",new WaterElement(1), Role.Tank), "asdfasdf");

        });
    }

    @Test
    void illegalArgumentThrownWhenRemoveBossWhenBossDontExists(){
      Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");

        assertThrows(IllegalStateException.class, () -> {
            room.removeBoss();
        });

        //Test

    }

    @Test
    void doesPlayerPickUpItemAfterLWDrop(){
        Player player = new Player("Test", new FireElement(1), Role.Tank);
        Room room = new Room(player, "Lucky Wheel");
        LuckyWheel lw = room.getLuckyWheel();

        Item item = lw.spinLuckyWheel();
        while(item == null){
            item = lw.spinLuckyWheel();
        }

        player.addItem(item);
        assertEquals(item, player.findItem(item));
    }
}


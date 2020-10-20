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

    @Test
    void ifArgumentExceptionIsThrownWhenMaxValueAboveTen(){

        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.generateRandomNumber(2, 11);
        });
    }

    @Test
    void ifArgumentExceptionIsThrownWhenMinValueIsEqualToMaxValue(){

        Room room = new Room();
        assertThrows(IllegalArgumentException.class, () -> {
            room.generateRandomNumber(7, 7);
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

    @Test void ifAllEnemiesAreTheRightElement(){

    }

    @Test void ifCorrectNumberOfEnemiesHaveBeenCreated(){

    }

    @Test
    void shouldGenerateElementForRoom(){
      Room room = new Room();


    }







}
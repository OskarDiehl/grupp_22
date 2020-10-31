import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuckyWheelTest {

    @Test
    void spinLuckyWheel() {
    }

    @Test
    void getRoom() {
    }


    @Test
    void deathShouldBePlacedOnFirstIndex(){
        Room room = new Room();
        while(room.getRoomType() != "Lucky Wheel"){
            room = new Room();
        }

        LuckyWheel lw = room.getLuckyWheel();


        assertEquals("DEATH", lw.getDroptable().get(0));
    }



    @Test
    void deathShouldBePlacedOnLastIndex(){
        Room room = new Room();
        while(room.getRoomType() != "Lucky Wheel"){
            room = new Room();
        }

        LuckyWheel lw = room.getLuckyWheel();
        int lastIndex = lw.getDroptable().size() -1;

        assertEquals("DEATH", lw.getDroptable().get(lastIndex));

    }

    @Test
    void playerShouldLoseAllHPWhenLuckyWheelIsDeath(){
        Room room = new Room();
        while(room.getRoomType() != "Lucky Wheel"){
            room = new Room();
        }

        LuckyWheel lw = room.getLuckyWheel();
        Item item = lw.spinLuckyWheel();
        while(item != null) {
            item = lw.spinLuckyWheel();
        }

        Player player = room.getPlayer();
        assertEquals(0, player.getCurrentHPFromStats());

    }

    @Test
    void spinLuckyWheelShouldReturnItemWhenWheelIsNotDEATH(){
        Room room = new Room();
        while(room.getRoomType() != "Lucky Wheel"){
            room = new Room();
        }

        LuckyWheel lw = room.getLuckyWheel();
        Item item = lw.spinLuckyWheel();
        while(item == null){
            item = lw.spinLuckyWheel();
        }

        assertTrue(item instanceof Item);
    }
}
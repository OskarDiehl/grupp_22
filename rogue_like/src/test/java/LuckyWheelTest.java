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
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");

        LuckyWheel lw = room.getLuckyWheel();


        assertEquals("DEATH", lw.getDroptable().get(0));
    }



    @Test
    void deathShouldBePlacedOnLastIndex(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");

        LuckyWheel lw = room.getLuckyWheel();
        int lastIndex = lw.getDroptable().size() -1;

        assertEquals("DEATH", lw.getDroptable().get(lastIndex));

    }

    @Test
    void playerShouldLoseAllHPWhenLuckyWheelIsDeath(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");

        LuckyWheel lw = room.getLuckyWheel();
        Item item = lw.spinLuckyWheel();
        while(item != null) {
            item = lw.spinLuckyWheel();
        }

        Player player = room.getPlayer();
        assertEquals(0, player.getCurrentHPFromStats());

    }

    @Test
    void spinLuckyWheelShouldReturnNullIfDEATH(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");

        LuckyWheel lw = room.getLuckyWheel();
        Item item = lw.spinLuckyWheel();
        while(item instanceof Item) {
            item = lw.spinLuckyWheel();
        }

        assertEquals(null, item);

    }

    @Test
    void spinLuckyWheelShouldReturnItemWhenWheelIsNotDEATH(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");


        LuckyWheel lw = room.getLuckyWheel();
        Item item = lw.spinLuckyWheel();
        while(item == null){
            item = lw.spinLuckyWheel();
        }

        assertTrue(item instanceof Item);
    }

    @Test
    void IfGetDroptableReturnsADropTableWith10Objects(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");


        LuckyWheel lw = room.getLuckyWheel();
        assertEquals(10,lw.getDroptable().size());

    }

    @Test
    void getITEMS_AVAILABLEShouldBeSameSizeAsRoomItems(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");

        LuckyWheel lw = room.getLuckyWheel();

        assertEquals(lw.getITEMS_AVAILABLE().length, room.getITEMS().length);

    }


    @Test
    void getRoomShouldBeTheSameInstanceAsRoom(){
        Room room = new Room(new Player("Test", new FireElement(1), Role.Tank), "Lucky Wheel");


        LuckyWheel lw = room.getLuckyWheel();
        Room roomFromLW = lw.getRoom();

        assertEquals(room, roomFromLW);
    }
}
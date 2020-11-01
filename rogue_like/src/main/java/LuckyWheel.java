import java.util.ArrayList;
import java.util.Arrays;

public class LuckyWheel {

    private Item[] ITEMS_AVAILABLE;
    private final int DROPTABLE_SIZE = 10;
    private Room room;
    private ArrayList<Object> droptable = new ArrayList<>();

    public LuckyWheel(Room room) {
        this.room = room;
        this.ITEMS_AVAILABLE = room.getITEMS();
        placeRandomItemsInDropTable();
    }


    public void placeRandomItemsInDropTable() {
        int size = room.getITEMS().length;
        droptable.add(0, "DEATH");
        for (int i = 1; i < DROPTABLE_SIZE - 1; i++) {
            int rndNum = room.generateRandomNumber(1, size) - 1;
            droptable.add(i, ITEMS_AVAILABLE[rndNum]);
        }
        droptable.add(DROPTABLE_SIZE - 1, "DEATH");
    }

    public Item spinLuckyWheel() {
        int num = room.generateRandomNumber(1, 10) - 1;
        if (droptable.get(num).equals("DEATH")) {
            room.getPlayer().getStats().loseHP(room.getPlayer().getCurrentHPFromStats());
            return null;
        }
        Item item = (Item) droptable.get(num);
        return item;
    }


    public ArrayList<Object> getDroptable() {
        return new ArrayList<Object>(droptable);
    }

    public Room getRoom() {
        return room;
    }


    public Item[] getITEMS_AVAILABLE() {
        return Arrays.copyOf(ITEMS_AVAILABLE, ITEMS_AVAILABLE.length);
    }
}
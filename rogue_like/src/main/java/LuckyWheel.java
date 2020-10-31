import java.util.ArrayList;

public class LuckyWheel {

    private Item[] ITEMS_AVAILABLE;
    private final int DROPTABLE_SIZE = 10;
    private Room room;
    private ArrayList<Object> droptable;


    public LuckyWheel(Room room) {
        this.room = room;
        this.ITEMS_AVAILABLE = room.getITEMS();


    }

    public void placeRandomItemsInDropTable()

    {
        int size = room.getITEMS().length - 1;
        droptable.add(0,"DEATH");
        droptable.add(DROPTABLE_SIZE-1, "DEATH");

        for(int i = 1; i< DROPTABLE_SIZE-1;i++ ){
            droptable.add(i,ITEMS_AVAILABLE[generateRandomNumber(1,size)]);
        }

        }


        public Item spinLuckyWheel () {
            int num = generateRandomNumber(1,10);

            if(droptable.get(num).equals("DEATH")){
                room.getPlayer().getPlayerStats().loseHP(room.getPlayer().getCurrentHPFromStats());
                return null;
            }

            Item item = (Item)droptable.get(num);

            return item;
    }


        private int generateRandomNumber ( int min, int max){


        if (min < 1 || max < 1 || min > max) {
            throw new IllegalArgumentException();
        } else {
            max += 1;

            return (int) ((Math.random() * (max - min)) + min);
        }
    }
    }




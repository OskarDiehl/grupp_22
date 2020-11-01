//TODO organisera metoder, alla enemy metoder borde vara ihop exempelvis.




import java.util.ArrayList;
import java.util.Arrays;

public class Room {

    private static final Item[] ITEMS = new Item[]{
            new Weapon("Boring Sword", 1, 0),
            new Weapon("Cool Sword", 3, -1),
            new Weapon("Mega Hammer", 10, -5),
            new Weapon("Dinky Hammer", -1, 0),
            new Weapon("Cast Iron Frying Pan", 4, -2),

            new Armor("Knight's Armor", 4, -2),
            new Armor("Leather Scrap Armor", 1, 0),
            new Armor("Wearable Bank Vault", 10, -10),
            new Armor("Bussiness Casual", 0, 0),
            new Armor("Birthday Suit", 0, 0),

            new Shoes("Flip Flops", 1, -1),
            new Shoes("Sneakers", 3, 0),
            new Shoes("Yeezys", 4, -1),
            new Shoes("Clogs", 2, -3),
            new Shoes("Stilettos", 8, -4)

    };

    private final int MAX_AMOUNT_OF_MEDALLIONS = 3;
    private final int MIN_THRESHOLD = 1;
    private final int AMOUNT_OF_ELEMENTS = 4;

    private final int MAX_AMOUNT_OF_ENEMIES = 7;
    private final int MIN_AMOUNT_OF_ENEMIES = 4;
    private final int MAX_NUMBER_LUCKY_WHEEL = 5;

    private ArrayList<Enemy> enemies;
    private int enemyQuantity;
    private String roomType;
    private Element element;
    private Player player;
    private LuckyWheel luckyWheel;
    private Item itemDropped;
    private Boss boss;


    public Room(Player player) {
        this.player = player;
        this.element = decideTypeOfElement(generateRandomNumber(MIN_THRESHOLD, AMOUNT_OF_ELEMENTS));
        buildRoom(decideTypeOfRoom(decideIfLuckyWheel()));
    }

    public Room(Player player, String roomType) {
        if (checkIfRoomTypeCorrect(roomType)) {
            this.element = decideTypeOfElement(generateRandomNumber(MIN_THRESHOLD, AMOUNT_OF_ELEMENTS));
            this.player = player;
            buildRoom(roomType);
        }
    }

    public Room(Player player, Element element) {
        this.element = element;
        this.player = player;
        buildRoom(decideTypeOfRoom(decideIfLuckyWheel()));
    }

    public Room(Player player, Element element, String roomType) {
        if (checkIfRoomTypeCorrect(roomType)) {
            this.element = element;
            this.player = player;
            buildRoom(roomType);
        }
    }


    private boolean checkIfRoomTypeCorrect(String roomType) {
        if((roomType.equals("Enemy")) || (roomType.equals("Lucky Wheel"))){
            return true;
        }
        throw new IllegalArgumentException();
    }



    private void buildRoom(String typeOfRoom) {

        if (checkIfRoomTypeCorrect(typeOfRoom)) {

            if (typeOfRoom == "Enemy" && shouldBossSpawn()) {
                typeOfRoom = "Boss";
            }

            roomType = typeOfRoom;

            switch (typeOfRoom) {
                case "Enemy":
                    spawnEnemies();
                    break;
                case "Boss":
                    spawnBoss();
                    break;
                case "Lucky Wheel":
                    spawnLuckyWheel();
                    break;
            }
        }
    }


    public String decideTypeOfRoom(boolean isItLuckyWheel) {
        String name;

        if ((isItLuckyWheel)) {
            name = "Lucky Wheel";
        } else {
            name = "Enemy";

        }
        return name;
    }

    public Element decideTypeOfElement(int elementNumber) { //denna är private eftersom jag endast vill att ett element ska kunna kallas på en gång
        switch (elementNumber) {
            case 1:
                element = new FireElement(1);
                break;
            case 2:
                element = new WaterElement(1);
                break;
            case 3:
                element = new WindElement(1);
                break;
            case 4:
                element = new EarthElement(1);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return element;
    }

    private boolean decideIfLuckyWheel() {
        return (generateRandomNumber(MIN_THRESHOLD, MAX_NUMBER_LUCKY_WHEEL) == MAX_NUMBER_LUCKY_WHEEL);

    }




    public ArrayList<Enemy> spawnEnemies() {

        if (enemies == null) {
            enemyQuantity = generateAmountOfEnemies();
            enemies = new ArrayList();
            for (int i = 0; i < enemyQuantity; i++) {
                enemies.add(new Enemy(getElement(), player.getLevel(), this));

            }
        }

        return new ArrayList<Enemy>(getEnemies());

    }

    public void spawnLuckyWheel() {
        luckyWheel = new LuckyWheel(this);
    }

    public void spinTheLuckyWheel() {
        if (roomType == "Lucky Wheel") {
            Item item = luckyWheel.spinLuckyWheel();
            if (item != null) {
                itemDropped = luckyWheel.spinLuckyWheel();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public Item spawnItem() {
        return ITEMS[generateRandomNumber(1, ITEMS.length - 1)];
    }

    public void spawnBoss() {
        boss = new Boss(getElement(), player.getLevel(), this);

    }


    public boolean shouldBossSpawn() {
        int medallions = player.fetchMedallionStatus(getElement());

        if (medallions == MAX_AMOUNT_OF_MEDALLIONS) {
            player.resetMedallion(getElement());
            return true;
        }
        return false;
    }



    public void removeEnemy(Enemy enemy) {

        if (enemies.isEmpty() || !enemies.contains(enemy)) {
            throw new IllegalArgumentException();
        } else {
            enemies.remove(enemy);
            if (isEnemiesDead()) {
                itemDropped = spawnItem();
            }
        }
    }


    public void removeBoss() {
        if (boss != null) {
            boss = null;
            givePlayerElement();
        } else {
            throw new IllegalStateException();
        }
    }

    public void givePlayerElement() {
        player.addElement(getElement());
    }

    public int generateAmountOfEnemies() {
        return generateRandomNumber(MIN_AMOUNT_OF_ENEMIES, MAX_AMOUNT_OF_ENEMIES);
    }

    public boolean isEnemiesDead() {
        return (enemies.isEmpty());

    }


    public int generateRandomNumber(int min, int max) {

        if (min < 1 || max < 1 || min > max) {
            throw new IllegalArgumentException();
        } else {
            max += 1;
            return (int) ((Math.random() * (max - min)) + min);
        }
    }




    public Boss getBoss() {
        return boss;
    }
    public LuckyWheel getLuckyWheel() {
        return luckyWheel;
    }

    public Player getPlayer() {
        return player;
    }

    public Element getElement() {
        return element;
    }

    public ArrayList<Enemy> getEnemies() {
        return new ArrayList<Enemy>(enemies);
    }


    public String getRoomType() {
        return roomType;
    }

    public int getEnemyQuantity() {
        return enemyQuantity;
    }


    public Item getItemDropped() {
        return itemDropped;
    }

    public Item[] getITEMS() {
        return Arrays.copyOf(ITEMS, ITEMS.length);
    }
}


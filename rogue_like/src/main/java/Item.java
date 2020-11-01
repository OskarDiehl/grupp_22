public abstract class Item {

    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getHP();
    public abstract int getSpeed();
    public abstract int getPower();
}

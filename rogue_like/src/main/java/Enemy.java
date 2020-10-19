public class Enemy extends Character {

    public Enemy(String name, Element element, int level) {
        super(name, element);
        this.level = level;
        generateStats(level);
    }

    protected void generateStats(int level) {
        stats = new Stats(level);
    }

}

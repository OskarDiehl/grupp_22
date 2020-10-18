public class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private String name;
    private Element element;
    private int level;
    protected Stats stats;

    // CONSTRUCTOR  ------------------------------------------------------------------------
    public Character(String name, Element element){
        this.name = name;
        this.element = element;
        this.level = 1;
    }

    // OTHER METHODS ------------------------------------------------------------------------

    public void levelUp() {
        if (level < 3){
            level++;
            levelUpChangeStats();
        } else {
            throw new IllegalStateException("Level 3 is the highest level that you can reach.");
        }
    }

    public void levelUpChangeStats(){  //TODO Abstrakt? /Malin

    }

    // GET-METHODS  ------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public Element getElement() {
        return element;
    }

    public int getLevel() {
        return level;
    }

    public Stats getStats() {
        return stats;
    }
}
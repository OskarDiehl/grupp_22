public abstract class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private String name;
    private Element element;
    protected int level;
    protected Stats stats;

    // CONSTRUCTOR  ------------------------------------------------------------------------
    public Character(String name, Element element){
        this.name = name;
        this.element = element;
        //this.level = 1; TODO Implementera detta i Player Malin /Sabina
    }

    // OTHER METHODS ------------------------------------------------------------------------



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


public class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private String name;
    private Element element;
    private int level;
    //stats

    // CONSTRUCTOR  ------------------------------------------------------------------------
    public Character(String name, Element element){
        this.name = name;
        this.element = element;
        this.level = 1;
    }

    //OTHER METHODS ------------------------------------------------------------------------

    public void levelUp() {
        if (level < 3)
            level++;
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
}
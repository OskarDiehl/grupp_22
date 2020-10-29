public abstract class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private String name;
    private Element element;
    private int level;

    // CONSTRUCTORS  ------------------------------------------------------------------------
    public Character(String name, Element element){
        this.name = name;
        this.element = element;
    }

    public Character(Element element, int level){
        this.element = element;
        this.level = level;
    }

    // OTHER METHODS ------------------------------------------------------------------------

    public void setLevel(int level) {
        if (level >= 1 && level <=3) {
            this.level = level;
        } else {
            throw new IllegalArgumentException();
        }
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


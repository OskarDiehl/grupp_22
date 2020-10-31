public abstract class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private String name;
    private Element mainElement;
    private int level;

    // CONSTRUCTORS  ------------------------------------------------------------------------
    public Character(String name, Element mainElement){
        this.name = name;
        this.mainElement = mainElement;
    }

    public Character(Element mainElement, int level){
        this.mainElement = mainElement;
        if(level >= 1 && level <= 3)
            this.level = level;
        else
            throw new IllegalArgumentException();
    }

    // OTHER METHODS ------------------------------------------------------------------------

    public void setLevel(int level) {
        if (level >= 1 && level <=3)
            this.level = level;
        else
            throw new IllegalArgumentException();

    }

    // GET-METHODS  ------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public Element getMainElement() {
        return mainElement;
    }

    public int getLevel() {
        return level;
    }



}


public abstract class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private final Element mainElement;
    private int level;

    //TODO fixa minLevel och maxLevel

    // CONSTRUCTORS  ------------------------------------------------------------------------
    public Character(Element mainElement){
        this.mainElement = mainElement;
        level = 1;
    }

    public Character(Element mainElement, int level){
        this.mainElement = mainElement;
        setLevel(level);
    }

    // OTHER METHODS ------------------------------------------------------------------------
    public void setLevel(int level){
        if(level >= 1 && level <= 3)        //A character can reach up to level 3
            this.level = level;
        else {
            throw new IllegalArgumentException();
        }
    }

    public abstract void attack(Character character);

    // GET-METHODS  ------------------------------------------------------------------------

    public Element getMainElement() {
        return mainElement;
    }

    public int getLevel() {
        return level;
    }

    public abstract Stats getStats();
}


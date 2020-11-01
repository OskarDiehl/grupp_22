public abstract class Character {

    // INSTANCE VARIABLES  ------------------------------------------------------------------------
    private Element mainElement;
    private int level;

    // CONSTRUCTORS  ------------------------------------------------------------------------
    public Character(Element mainElement){
        this.mainElement = mainElement;
        level = 1;
    }

    public Character(Element mainElement, int level){
        this.mainElement = mainElement;
        setLevel(level);
    }


    // CONSTRUCTORS  ------------------------------------------------------------------------
    public void setLevel(int level){
        if(level >= 1 && level <= 3)
            this.level = level;
        else {
            throw new IllegalArgumentException();
        }
    }

    // GET-METHODS  ------------------------------------------------------------------------

    public Element getMainElement() {
        return mainElement;
    }

    public int getLevel() {
        return level;
    }

    //public abstract Stats getStats();



}


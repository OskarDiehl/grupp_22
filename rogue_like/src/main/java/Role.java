public enum Role {
    Tank ("Tank", 5, 6,4 ),   //TODO HP är life
    Warrior ("Warrior", 5,6,5),
    Runner("Runner",5,4,6);

    // VARIABLES -------------------------------------------------------------------------
    private final String roleName;
    private int life;
    private int power;
    private int speed;

    // CONSTRUCTOR -----------------------------------------------------------------------
    Role (String roleName, int life, int power, int speed){
        this.roleName = roleName;
        this.life = life;
        this.power = power;
        this.speed = speed;
    }

    // GET-METHODS ------------------------------------------------------------------------
    public String getRoleName() {
        return roleName;
    }

    public int getLife() {
        return life;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }
}


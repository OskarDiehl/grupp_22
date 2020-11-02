public enum Role {
    //When a player is created, its default stats sets to different values depending on the role the user chooses

    Tank    ("Tank",    6,  6,4 ),
    Warrior ("Warrior", 4,  6,5),
    Runner  ("Runner",  5,  4,6);

    // VARIABLES -------------------------------------------------------------------------------------------------------
    private final String roleName;
    private final int HP;
    private final int power;
    private final int speed;

    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------
    Role (String roleName, int HP, int power, int speed){
        this.roleName = roleName;
        this.HP = HP;
        this.power = power;
        this.speed = speed;
    }

    // GET-METHODS -----------------------------------------------------------------------------------------------------
    public String getRoleName() {
        return roleName;
    }

    public int getHP() {
        return HP;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }
}


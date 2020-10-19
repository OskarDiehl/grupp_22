public enum Role {
    Tank ("Tank", 5, 6,4 ),
    Warrior ("Warrior", 5,6,5),
    Runner("Runner",5,4,6);

    private final String roleName;
    private int life;
    private int power;
    private int speed;

    Role (String roleName, int life, int power, int speed){
        this.roleName = roleName;
        this.life = life;
        this.power = power;
        this.speed = speed;
    }

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

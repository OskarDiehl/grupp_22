public class Player extends Character {
    public Player(String name, Element element) {
        super(name, element);

    }

    public void levelUp() {

        int currentLevel = getLevel();
        currentLevel++;
    }
}

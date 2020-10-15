public class Element {

    public boolean isStrong() {
        return true;
    }

    public boolean isWeak() {
        return true;
    }

    public int attack() {
        int power = 5;

        if (isStrong()) {
            power += 2;
        } else if (isWeak()) {
            power -= 2;
        }

        return power;

    }

}

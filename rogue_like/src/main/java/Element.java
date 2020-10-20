//kolla upp hur man Kan testa abstrakta klasser!!!!

public class Element {

    public boolean isStrong() {
        return true;
    }

    public boolean isWeak() {
        return true;
    }

    public int attack() {
        int power = 5; //temporär power tills det går att hämta från charcter


        if (isStrong()) {
            power += 2;
        } else if (isWeak()) {
            power -= 2;
        }

        return power;

    }

}

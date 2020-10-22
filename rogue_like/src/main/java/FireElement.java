public class FireElement extends Element {


    public FireElement(int elementLevel) {
        super(elementLevel);
    }

    @Override
    public boolean isStrong(Element element) { // TODO: implementera när fler element är skapade!!
        return true;
        /*if (element instanceof WindElement) {
            return true;
        } else {
            return false;
        }*/
    }


    public boolean isWeak(Element element) {
        if (element instanceof WaterElement) {
            return true;
        } else {
            return false;
        }
    }

    public int attack(Element element) {
        int power = 5; //temporär power tills det går att hämta från charcter. Ska ändras till player.getPowerFromStats()

        if (isStrong(element)) {
            power += 2;
        } else if (isWeak(element)) {
            power -= 2;
        }

        if (elementLevel == 2) {
            return power * 2;
        } else if(elementLevel == 3) {
            return power * 3;
        } else {
            return power;
        }

    }

}

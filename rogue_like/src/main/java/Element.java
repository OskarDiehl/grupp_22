//kolla upp hur man Kan testa abstrakta klasser!!!!

public  abstract class Element {

    int elementLevel;

    //Fick inte det att fungera med att ha två konstruktorer här och få dem att fungera i subklasserna /Oskar
    public Element(int elementLevel) {
        if (elementLevel == 1 || elementLevel == 2 || elementLevel == 3) {
            this.elementLevel = elementLevel;
        } else {
            throw new IllegalArgumentException("The Element Level cant be set below 1 or above 3");
        }
    }

    public abstract boolean isStrong(Element element);

    public abstract boolean isWeak(Element element);

    public int getElementLevel() {
        return elementLevel;
    }

    //Kanske ska flyttas till Character eller någonting sådant.
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

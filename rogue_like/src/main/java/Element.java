public abstract class Element {

    private int elementLevel;
    //Extra bonus power for restarting your Element Level.
    private int prestigeBonus;

    public Element(int elementLevel) {
        if (elementLevel == 1 || elementLevel == 2 || elementLevel == 3) {
            this.elementLevel = elementLevel;
        } else {
            throw new IllegalArgumentException("The Element Level can't be set below 1 or above 3");
        }
    }

    public abstract boolean isStrong(Element element);

    public abstract boolean isWeak(Element element);

    public int getElementLevel() {
        return elementLevel;
    }

    // TODO: 2020-11-02 Gör den här mer komplex
    public void levelUpElement() {
        if (elementLevel == 3 && prestigeBonus >=10) {
            throw new IllegalArgumentException();
        } else if (elementLevel == 3) {
            elementLevel = 1;
            prestigeBonus += 2;
        } else {
            elementLevel++;
        }
    }

    public int getPrestigeBonus() {
        return prestigeBonus;
    }

    //An element makes an attack with the power that is included in the method towards an enemy
    //with the element that is also included with the attack.
    //If the element that is making the attack is strong, the attack gets +2 power. If it is weak it gets -2 power
    //Then the Power doubles if the element level is level 2, or triples if the element level is level 3.
    //In the last stage the calculated power is returned as the attack power which can be used to attack the enemy.
    public int attack(int power,Element element) {
        power += prestigeBonus;

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

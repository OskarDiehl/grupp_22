public class FireElement extends Element {


    public FireElement(int elementLevel) {
        super(elementLevel);
    }

    @Override
    public boolean isStrong(Element element) { // TODO: implementera när fler element är skapade!!
        return element instanceof WindElement;
    }


    @Override
    public boolean isWeak(Element element) {
        return element instanceof WaterElement;
    }


}

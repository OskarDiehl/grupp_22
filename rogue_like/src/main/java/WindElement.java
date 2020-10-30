public class WindElement extends Element {
    public WindElement(int elementLevel) {
        super(elementLevel);
    }

    @Override
    public boolean isStrong(Element element) {
        return element instanceof EarthElement;
    }

    @Override
    public boolean isWeak(Element element) {
        return element instanceof FireElement;
    }
}

public class EarthElement extends Element {
    public EarthElement(int elementLevel) {
        super(elementLevel);
    }

    @Override
    public boolean isStrong(Element element) {
        return element instanceof WaterElement;
    }

    @Override
    public boolean isWeak(Element element) {
        return element instanceof WindElement;
    }
}

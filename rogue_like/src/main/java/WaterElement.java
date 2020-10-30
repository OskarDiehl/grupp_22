//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;

public class WaterElement extends Element {


    public WaterElement(int elementLevel) {
        super(elementLevel);
    }

    @Override
    public boolean isStrong(Element element) {
        return element instanceof FireElement;
    }

    @Override
    public boolean isWeak(Element element) {
        return element instanceof EarthElement;
    }

}

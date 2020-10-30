import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EarthElementTest {

    @Test
    void isStrongWithWaterElementReturnsTrue() {
        Element e1 = new EarthElement(1);
        Element e2 = new WaterElement(1);
        assertTrue(e1.isStrong(e2));
    }

    @Test void isStrongWithWindElement() {
        Element e1 = new EarthElement(3);
        Element e2 = new WindElement(3);
        assertTrue(e1.isWeak(e2));
    }

}

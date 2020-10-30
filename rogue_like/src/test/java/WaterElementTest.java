import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WaterElementTest {

    @Test
    void isStrongWithFireElementReturnTrue() {
        Element e1 = new WaterElement(2);
        Element e2 = new FireElement(2);
        assertTrue(e1.isStrong(e2));
    }

    @Test
    void isStrongWithWindElementReturnFalse() {
        Element e1 = new WaterElement(2);
        Element e2 = new WindElement(2);
        assertFalse(e1.isStrong(e2));
    }

    @Test
    void isWeakWithEarthElementReturnsTrue() {
        Element e1 = new WaterElement(2);
        Element e2 = new EarthElement(2);
        assertTrue(e1.isWeak(e2));
    }

    @Test
    void isWeakWithFireElementReturnsFalse() {
        Element e1 = new WaterElement(2);
        Element e2 = new FireElement(2);
        assertFalse(e1.isWeak(e2));
    }

}

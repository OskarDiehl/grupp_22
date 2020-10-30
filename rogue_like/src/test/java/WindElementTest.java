import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WindElementTest {

    @Test
    void isStrongWithEarthElementReturnsTrue() {
        Element e1 = new WindElement(1);
        Element e2 = new EarthElement(2);
        assertTrue(e1.isStrong(e2));
    }

    @Test
    void isWeakWithFireElementReturnsTrue() {
        Element e1 = new WindElement(3);
        Element e2 = new FireElement(1);
        assertTrue(e1.isWeak(e2));
    }

}

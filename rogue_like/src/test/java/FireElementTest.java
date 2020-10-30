import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FireElementTest {

    @Test
    void isStrongWindElementReturnTrue() {
        Element e1 = new FireElement(2);
        Element e2 = new WindElement(2);
        assertTrue(e1.isStrong(e2));
    }

    @Test
    void isWeakWaterElementReturnTrue() {
        Element e1 = new FireElement(2);
        Element e2 = new WaterElement(2);
        assertTrue(e1.isWeak(e2));
    }


}

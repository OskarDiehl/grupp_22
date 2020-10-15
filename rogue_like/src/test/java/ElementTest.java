import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ElementTest {


    @Test
    void isStrongMethodReturnsTrue() {
        Element e = new Element();

        assertTrue(e.isStrong());
    }

    @Test
    void isWeakMethodReturnsTrue() {
        Element e = new Element();
        assertTrue(e.isWeak());
    }

    @Test
    void attackAndIsStrongReturnsSeven() {
        Element e = new Element();
        assertEquals(7,e.attack());
    }

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ElementTest {

    @Test
    void createInstancOfElement() {
        Element e = new Element();
    }

    @Test
    void isStrongMethodIsTrue() {
        Element e = new Element();
        e.isStrong();
    }

}

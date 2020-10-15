import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void testConstructor() {
        Element element = new Element();
        Character character = new Character("Malin", element);
        assertEquals("Malin" + element , character.getName() + character.getElement());
    }
}

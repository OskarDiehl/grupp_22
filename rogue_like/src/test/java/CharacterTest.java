import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void getNameFromConstructorArgument() {
        Element element = new Element();
        Character character = new Character("Malin", element);
        assertEquals("Malin", character.getName());
    }

    @Test
    void getElementFromConstructorArgument() {
        Element element = new Element();
        Character character = new Character("Malin", element);
        assertEquals(element, character.getElement());
    }
}

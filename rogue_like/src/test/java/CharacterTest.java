import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    private Element element;

    @Test
    void getNameFromConstructorArgument() {
        Character character = new Character("Malin", element);
        assertEquals("Malin", character.getName());
    }

    @Test
    void getElementFromConstructorArgument() {
        Element e = new Element();
        Character character = new Character("Malin", e);
        assertEquals(e, character.getElement());
    }

    @Test
    void getLevelAndCheckIfItReturnsOne() {
        Character character = new Character("Malin", element);
        assertEquals(1, character.getLevel());

    }

//    @Test
//    void getLevelandCheckIfItHasChanged() {
//
//    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
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
    void levelUpToSecondLevel(){
        Player player = new Player("Sabina", element);
        player.levelUp();
        assertEquals(2, player.getLevel());
    }

}

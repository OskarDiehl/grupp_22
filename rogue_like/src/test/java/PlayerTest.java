import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Element element;
    @Test
    void getNameFromConstructorArgument() {
        Player player = new Player("Sabina", element);
        assertEquals("Sabina", player.getName());
    }

    @Test
    void getElementFromConstructorArgument() {
        Element e = new Element();
        Player player = new Player("Sabina", e);
        assertEquals(e, player.getElement());
    }

    @Test
    void getLevelFromConstructorArgument(){
        Player player = new Player("Sabina", element);
        assertEquals(1, player.getLevel());
    }
}

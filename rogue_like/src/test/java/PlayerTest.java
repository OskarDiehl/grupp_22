import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Element element;
    @Test
    void getNameFromConstructorArgument() {
        Player player = new Player("Sabina", element, "Warrior");
        assertEquals("Sabina", player.getName());
    }

    @Test
    void getElementFromConstructorArgument() {
        Element e = new Element();
        Player player = new Player("Sabina", e, "Warrior");
        assertEquals(e, player.getElement());
    }

    @Test
    void getLevelFromConstructorArgument(){
        Player player = new Player("Sabina", element, "Warrior");
        assertEquals(1, player.getLevel());
    }

    @Test
    void getWarriorAsRoleFromConstructorArgument(){
        Player player = new Player("Sabina", element, "Warrior");
        assertEquals("Warrior", player.getRole());
    }
}
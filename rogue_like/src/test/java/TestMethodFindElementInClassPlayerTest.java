import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMethodFindElementInClassPlayerTest {
    private Element element = new WindElement(1);
    private Role role = Role.Runner;
    @Test
    void addFireElementToElements(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addElement(fireElement);
        assertEquals(fireElement, player.findElement("Fire"));
    }

}

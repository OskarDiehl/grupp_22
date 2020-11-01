import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    void getNameWithConstructorArgumentFromSubClass() {
        Item i = new Armor("TestItem",6,-2);
        assertEquals("TestItem", i.getName());
    }

    @Test
    void returnZeroHPFromGetHP() {
        Item i = new Shoes("Shoo",2,2);
        assertEquals(0, i.getHP());
    }

}

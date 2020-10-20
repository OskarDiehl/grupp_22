import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    void getNameWithConstructorArgument() {
        Item i = new Armor("TestItem",6,-2);
        assertEquals("TestItem", i.getName());
    }

}

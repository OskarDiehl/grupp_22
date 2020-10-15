import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;    TODO Är det här något som är relevant? /Malin

public class CharacterTest {

    @Test
    void testConstructor() {
        Element element = new Element();
        Character character = new Character("Malin", element);
        assertEquals("Malin" + element , character.getName() + character.getElement());
        //"Malin", element
        //Stats ska kanske sättas utifrån element och roll?
    }
}

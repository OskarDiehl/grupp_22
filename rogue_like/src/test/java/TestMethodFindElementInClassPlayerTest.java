import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMethodFindElementInClassPlayerTest {
    private Element element = new WindElement(1);
    private Role role = Role.Runner;

    @Test
    void earthAsAnArgumentWithASuccessfulSearch(){
        EarthElement earthElement = new EarthElement(2);
        Player player = new Player("Sabina", earthElement, role);
        assertEquals(earthElement, player.findElement("Earth"));
    }

    @Test
    void waterAsAnArgumentWithASuccessfulSearch(){
        WaterElement waterElement = new WaterElement(2);
        Player player = new Player("Sabina", waterElement, role);
        assertEquals(waterElement, player.findElement("Water"));
    }

    @Test
    void fireAsAnArgumentWithASuccessfulSearch(){
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addElement(fireElement);
        assertEquals(fireElement, player.findElement("Fire"));
    }

    @Test
    void windAsAnArgumentWithASuccessfulSearch(){
        Player player = new Player("Sabina", element, role);
        assertEquals(element, player.findElement("Wind"));
    }

    @Test
    void earthAsAnArgumentWithNoSuccessfulSearch(){
        Player player = new Player("Sabina", element, role);
        assertNull(player.findElement("Earth"));
    }

    @Test
    void typeWrongInFindElementMethod(){                                                 //Type wrong in method "findElement"
        Player player = new Player("Sabina", element, role);
        assertNull(player.findElement("win"));
    }


    //TODO FRÅGOR TILL DE ANDRA:
    // - Ska jag blanda versaler osv?
    // - Byta namn på t.ex: fireAsAnArgumentWithASuccessfulSearch()
    // - I vissa test lägger jag till element i efterhand och andra lägger jag direkt in dem i parametern, spelar roll?
    // -




}

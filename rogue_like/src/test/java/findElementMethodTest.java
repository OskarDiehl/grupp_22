import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Test class that test the method "findElement" in the class Player   TODO Ska den här beskrivningen stå här? /Malin

public class findElementMethodTest {
    private Element element = new WindElement(1);
    private Role role = Role.Runner;

    @Test
    void earthAsAnArgumentWithASuccessfulSearch(){                                  // Check if the String "Earth" as an argument has a successful search
        EarthElement earthElement = new EarthElement(2);
        Player player = new Player("Sabina", earthElement, role);
        assertEquals(earthElement, player.findElement("Earth"));
    }

    @Test
    void waterAsAnArgumentWithASuccessfulSearch(){                                  // Check if the String "Water" as an argument has a successful search
        WaterElement waterElement = new WaterElement(2);
        Player player = new Player("Sabina", waterElement, role);
        assertEquals(waterElement, player.findElement("Water"));
    }

    @Test
    void fireAsAnArgumentWithASuccessfulSearch(){                                   // Check if the String "fire" as an argument has a successful search
        FireElement fireElement = new FireElement(2);
        Player player = new Player("Sabina", element, role);
        player.addElement(fireElement);
        assertEquals(fireElement, player.findElement("fire"));
    }

    @Test
    void windAsAnArgumentWithASuccessfulSearch(){                                   // Check if the String "wind" as an argument has a successful search
        Player player = new Player("Sabina", element, role);
        assertEquals(element, player.findElement("wind"));
    }

    @Test
    void earthAsAnArgumentWithNoSuccessfulSearch(){                                 // Check if the String "Earth" as an argument has a non successful search
        Player player = new Player("Sabina", element, role);
        assertNull(player.findElement("Earth"));
    }

    @Test
    void typeWrongInFindElementMethod(){                                            //Type wrong in method "findElement" -> throw IllegalArgumentException
        Player player = new Player("Sabina", element, role);
        assertThrows(IllegalArgumentException.class, () -> player.findElement("Bad argument"), "Error: Argument not allowed.");
    }



    //TODO FRÅGOR TILL DE ANDRA:
    // - Ska jag blanda versaler osv?
    // - Byta namn på t.ex: fireAsAnArgumentWithASuccessfulSearch()
    // - I vissa test lägger jag till element i efterhand och andra lägger jag direkt in dem i parametern, spelar roll?
    // - NullpointerException i testet "earthAsAnArgumentWithNoSuccessfulSearch"
    // - Byta namn på testsviten/testklassen?




}

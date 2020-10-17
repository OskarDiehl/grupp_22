import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Element element;

    //TEST CONSTRUCTOR ------------------------------------------------------------------------
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

    //TEST XXX ------------------------------------------------------------------------
/*    @Test TODO Ska Stats tas upp redan i Character eller ska det in i Player istället? Det underlättar en hel del /Malin
    void getStatsWithoutFullStats(){
        Stats stats = new Stats(9, 5, 8);
        Player player = new Player("Sabina", element,"Warrior");
        assertEquals(stats.getLife(), player.getStats().getLife());
        assertEquals(stats.getPower(), player.getStats().getPower());
        assertEquals(stats.getSpeed(), player.getStats().getSpeed());
    }*/

}

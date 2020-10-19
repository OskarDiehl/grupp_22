/*
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    private Element element;

    //TEST CONSTRUCTOR ------------------------------------------------------------------------
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

    @Test   TODO KOLLA HÄR MALIN
    void getStatsFromConstructorArgument(){
        Stats stats = new Stats();
        Character character = new Character("Sabina", element);
        assertEquals(stats.toString(), character.getStats().toString()); // TODO Gjorde jag rätt nu? /Malin
    }


    @Test
    void getLevelAndCheckIfItReturnsOne() {
        Character character = new Character("Malin", element);
        assertEquals(1, character.getLevel());
    }



    //TEST LEVELING ------------------------------------------------------------------------
    @Test
    void levelUpToSecondLevel(){
        Character character = new Character("Sabina", element);
        character.levelUp();
        assertEquals(2, character.getLevel());
    }

    @Test
    void canNotLevelUpAfterLevelThree(){
        Character character = new Character("Sabina", element);
        character.levelUp();
        character.levelUp();
        character.levelUp();                  //TODO refactor? /Malin
        assertEquals(3, character.getLevel());
    }

}
*/

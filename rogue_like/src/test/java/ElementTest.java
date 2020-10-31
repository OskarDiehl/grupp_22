import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ElementTest {


    @Test
    void isStrongMethodReturnsTrue() {
        Element e1 = new WaterElement(1);
        Element e2 = new FireElement(1);
        assertTrue(e1.isStrong(e2));
    }

    @Test
    void isWeakMethodReturnsTrue() {
        Element e1 = new WaterElement(3);
        Element e2 = new FireElement(2);
        assertTrue(e2.isWeak(e1));
    }

    @Test
    void attackAndIsStrongReturnsSeven() {
        Element e1 = new WaterElement(1);
        Element e2 = new FireElement(1);
        assertEquals(7,e1.attack(e2));
    }

    @Test
    void constructorWithArgumentTwoReturnsElementLevelTwo() {
        Element e = new WaterElement(2);
        assertEquals(2, e.getElementLevel());
    }

    @Test
    void attackReturnsFifteenWithElementLevelOfThree(){
        Element e1 = new FireElement(3);
        Element e2 = new FireElement(2);
        assertEquals(15, e1.attack(e2));
    }

    @Test
    void attackReturnsTenWithElementLevelOfTwo(){
        Element e1 = new FireElement(2);
        Element e2 = new FireElement(2);
        assertEquals(10, e1.attack(e2));
    }

    @Test
    void attackIsWeakReturnsPowerThree() {
        Element e1 = new FireElement(1);
        Element e2 = new WaterElement(1);
        assertEquals(3, e1.attack(e2));
    }

    @Test
    void ifElementLevelAboveThreeThrowIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            Element e = new FireElement(4);
        });
    }

    @Test
    void ifElementLevelBelowOneThrowIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            Element e = new FireElement(0);
        });
    }

    @Test
    void levelUpElementFromOneToTwoAndGetLevelReturnsTwo() {
        Element e1 = new FireElement(1);
        e1.levelUpElement();
        assertEquals(2, e1.getElementLevel());
    }

    @Test
    void levelUpElementIfElementLevelThreeThrowIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            Element e1 = new FireElement(3);
            e1.levelUpElement();
        });
    }



}

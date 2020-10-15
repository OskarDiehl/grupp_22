import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArmorTest {

    String defaultName = "ArmorTest";
    int defaultHP = 5;
    int defaultSpeed = -2;

    @Test
    void getNameWithConstructorArgumentName() {
        Armor a = new Armor(defaultName, defaultHP, defaultSpeed);
        assertEquals(defaultName, a.getName());
    }

    @Test
    void getHPBoostReturns5() {
        Armor a = new Armor(defaultName, defaultHP, defaultSpeed);
        assertEquals(defaultHP, a.getHP());
    }

    @Test
    void getSpeedReturnsNegativeTwo() {
        Armor a = new Armor(defaultName,defaultHP,defaultSpeed);
        assertEquals(defaultSpeed, a.getSpeed());
    }

}

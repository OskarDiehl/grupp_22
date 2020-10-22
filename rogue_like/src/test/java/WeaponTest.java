import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WeaponTest {

    String defaultName = "WeaponTest";
    int defaultPower = 4;
    int defaultHP = -1;

    @Test
    void getNameFromConstructorArgument() {
        Weapon w = new Weapon(defaultName, defaultPower, defaultHP);
        assertEquals(defaultName, w.getName());
    }

    @Test
    void getPowerReturnsFour() {
        Weapon w = new Weapon(defaultName, defaultPower, defaultHP);
        assertEquals(defaultPower, w.getPower());
    }

    @Test
    void getHPreturnsNegativeOne() {
        Weapon w = new Weapon(defaultName, defaultPower, defaultHP);
        assertEquals(defaultHP, w.getHp());
    }

}

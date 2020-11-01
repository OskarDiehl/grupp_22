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
    void getHPReturnsNegativeOne() {
        Weapon w = new Weapon(defaultName, defaultPower, defaultHP);
        assertEquals(defaultHP, w.getHP());
    }

    @Test
    void getSpeedReturnsZero() {
        Item i = new Weapon("Weapon",2,2);
        assertEquals(0, i.getSpeed());
    }

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShoesTest {

    String defaultName = "ShoesTest";
    int defaultSpeed = 3;
    int defaultPower = -3;

    @Test
    void getNameFromConstructorArgument() {
        Shoes s = new Shoes(defaultName, defaultSpeed, defaultPower);
        assertEquals(defaultName, s.getName());
    }

    @Test
    void getSpeedReturnsThree() {
        Shoes s = new Shoes(defaultName, defaultSpeed, defaultPower);
        assertEquals(defaultSpeed, s.getSpeed());
    }

    @Test
    void getPowerReturnsNegativeThree() {
        Shoes s = new Shoes(defaultName, defaultSpeed, defaultPower);
        assertEquals(defaultPower, s.getPower());
    }


}

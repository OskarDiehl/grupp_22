import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStats {

    @Test
    void getFullLifeFromConstructorArgument() {
        Stats stats = new Stats();
        assertEquals(10, stats.getLife());
    }

    @Test
    void getFullPowerFromConstructorArgument() {
        Stats stats = new Stats();
        assertEquals(10, stats.getPower());
    }

    @Test
    void getFullRunnerFromConstructorArgument() {
        Stats stats = new Stats();
        assertEquals(10, stats.getSpeed());
    }

    @Test
    void looseTwoLives(){
        Stats stats = new Stats();
        stats.looseLives(2);
        assertEquals(8, stats.getLife());
    }

}

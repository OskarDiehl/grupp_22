import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsTest {

    //TEST CONSTRUCTOR
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


    //TEST LIFE
    @Test
    void looseTwoLives(){
        Stats stats = new Stats();
        stats.looseLives(2);
        assertEquals(8, stats.getLife());
    }

    //TEST POWER
    @Test
    void decreasePowerWithThree(){
        Stats stats = new Stats();
        stats.decreasePower(3);
        assertEquals(7, stats.getPower());
    }

    //TEST SPEED
    //TODO Ska man kunna öka och minska speed? /Malin

}

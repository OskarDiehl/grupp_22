import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {

    //TEST CONSTRUCTORS ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role (enemy character).
    @Test
    void getFullLifeFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 4);
        assertEquals(5, stats.getCurrentLife());
    }

    @Test
    void getFullPowerFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 4);
        assertEquals(5, stats.getPower());
    }

    @Test
    void getFullRunnerFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 4);
        assertEquals(5, stats.getSpeed());
    }

    //Constructor for character WITH a role. The "role constructor".
    @Test
    void tryParametersInRoleConstructorArgument(){ //TODO slipa på namngivningen /Malin
        Stats stats = new Stats(9, 5, 8);
        assertEquals(9, stats.getCurrentLife());
        assertEquals(5, stats.getPower());
        assertEquals(8, stats.getSpeed());
    }

    @Test
    void throwIAEIfNotInbetweenOneToTen(){
        assertThrows(IllegalArgumentException.class, () -> new Stats(1, 1, 11));
    }


    //TEST LIFE  ------------------------------------------------------------------------
    @Test
    void looseTwoLivesFromTenExistingLives(){
        Stats stats = new Stats(2);
        stats.loseLives(2);
        assertEquals(3, stats.getCurrentLife());
    }


    @Test
    void checkMinimumZeroLives(){  //TODO Vad ska hända om life hamnar på 0 eller under? /Malin
        Stats stats = new Stats(1);
        stats.loseLives(11);
        assertEquals(0, stats.getCurrentLife());
    }

    @Test
    void gainTwoLivesToTwoExistingLives(){
        Stats stats = new Stats(5,10,10);
        stats.loseLives(3);
        stats.gainLives(2);
        assertEquals(4, stats.getCurrentLife());
    }

    @Test
    void checkMaximumLives(){
        Stats stats = new Stats(2); //TODO ändra konstruktoranropen
        stats.gainLives(2);
        assertEquals(5, stats.getMaxLife());
    }

    // OTHER METHODS ------------------------------------------------------------------------
    @Test
    void characterIsAttackedByAnOtherCharacter(){
        //TODO Vad händer när en karaktär blir attackerad? Är det bara life som påverkas? /Malin
        Stats stats = new Stats(3);
        stats.attackedByAnEnemy(2);
        assertEquals(6, stats.getCurrentLife());
    }


    //TEST TO-STRING-METHOD ------------------------------------------------------------------------
    @Test
    void correctToString(){
        Stats stats = new Stats(1);
        assertEquals("Life: 3\nPower: 3\nSpeed: 3", stats.toString());
    }
}

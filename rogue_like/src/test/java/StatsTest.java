import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {

    //TEST CONSTRUCTORS ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role (enemy character).
    @Test
    void getFullHPFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 4);
        assertEquals(5, stats.getCurrentHP());
    }

    @Test
    void getFullPowerFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 4);
        assertEquals(5, stats.getDefaultPower());
    }

    @Test
    void getFullRunnerFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 4);
        assertEquals(5, stats.getDefaultSpeed());
    }

    //Constructor for character WITH a role. The "role constructor".
    @Test
    void tryParametersInRoleConstructorArgument(){ //TODO slipa på namngivningen /Malin
        Stats stats = new Stats(9, 5, 8);
        assertEquals(9, stats.getCurrentHP());
        assertEquals(5, stats.getDefaultPower());
        assertEquals(8, stats.getDefaultSpeed());
    }

    @Test
    void throwIAEIfNotInbetweenOneToTen(){
        assertThrows(IllegalArgumentException.class, () -> new Stats(1, 1, 11));
    }


    //TEST HP  ------------------------------------------------------------------------
    @Test
    void looseTwoLivesFromTenExistingLives(){
        Stats stats = new Stats(5, 3, 4);
        stats.loseLives(2);
        assertEquals(3, stats.getCurrentHP());
    }


    @Test
    void checkMinimumZeroLives(){  //TODO Vad ska hända om HP hamnar på 0 eller under? /Malin
        Stats stats = new Stats(1, 3, 4);
        stats.loseLives(11);
        assertEquals(0, stats.getCurrentHP());
    }

    @Test
    void gainTwoLivesToTwoExistingLives(){
        Stats stats = new Stats(5,10,10);
        stats.loseLives(3);
        stats.gainLives(2);
        assertEquals(4, stats.getCurrentHP());
    }

    @Test
    void checkMaximumLives(){
        Stats stats = new Stats(3, 3, 4);
        stats.gainLives(2);
        assertEquals(5, stats.getDefaultHP());
    }

    // OTHER METHODS ------------------------------------------------------------------------
    @Test
    void characterIsAttackedByAnOtherCharacter(){
        //TODO Vad händer när en karaktär blir attackerad? Är det bara HP som påverkas? /Malin
        Stats stats = new Stats(8, 3, 4);
        stats.attackedByAnEnemy(2);
        assertEquals(6, stats.getCurrentHP());
    }


    //TEST TO-STRING-METHOD ------------------------------------------------------------------------
    @Test
    void correctToString(){
        Stats stats = new Stats(3, 3, 3);
        assertEquals("HP: 3\nPower: 3\nSpeed: 3", stats.toString());
    }
}

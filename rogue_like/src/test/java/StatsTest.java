import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {

    //TEST CONSTRUCTORS ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role. The "standard constructor"
    @Test
    void getFullLifeFromStandardConstructorArgument() {
        Stats stats = new Stats(2);
        assertEquals(5, stats.getLife());
    }

    @Test
    void getFullPowerFromStandardConstructorArgument() {
        Stats stats = new Stats(2);
        assertEquals(5, stats.getPower());
    }

    @Test
    void getFullRunnerFromStandardConstructorArgument() {
        Stats stats = new Stats(2);
        assertEquals(5, stats.getSpeed());
    }

    //Constructor for character WITH a role. The "role constructor".
    @Test
    void tryParametersInRoleConstructorArgument(){ //TODO slipa på namngivningen /Malin
        Stats stats = new Stats(9, 5, 8);
        assertEquals(9, stats.getLife());
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
        Stats stats = new Stats(1);
        stats.loseLives(2);
        assertEquals(8, stats.getLife());
    }


    @Test
    void checkMinimumZeroLives(){  //TODO Vad ska hända om life hamnar på 0 eller under? /Malin
        Stats stats = new Stats(1);
        stats.loseLives(11);
        assertEquals(0, stats.getLife());
    }

    @Test
    void earnTwoLivesToFiveExistingLives(){
        Stats stats = new Stats(5,10,10);
       stats.gainLives(2);
        assertEquals(7, stats.getLife());
    }

    @Test
    void checkMaximumTenLives(){
        Stats stats = new Stats(1);
        stats.gainLives(2);
        assertEquals(10, stats.getLife());
    }


    //TEST POWER ------------------------------------------------------------------------
    @Test
    void decreasePowerWithThree(){
        Stats stats = new Stats(1);
        stats.decreasePower(3);
        assertEquals(7, stats.getPower());
    }

    //TEST SPEED ------------------------------------------------------------------------
    //TODO Ska man kunna öka och minska speed under spelets gång? /Malin


    // OTHER METHODS ------------------------------------------------------------------------

    @Test
    void characterIsAttackedByAnOtherCharacter(){
        //TODO Vad händer när en karaktär blir attackerad? Är det bara life som påverkas? /Malin
        Stats stats = new Stats(1);
        stats.attackedByAnEnemy(2);
        assertEquals(8, stats.getLife());
    }


    //TEST TO-STRING-METHOD ------------------------------------------------------------------------
    @Test
    void correctToString(){
        Stats stats = new Stats(1);
        assertEquals("Life: 10\nPower: 10\nSpeed: 10", stats.toString());
    }
}

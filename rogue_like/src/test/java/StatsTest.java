import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {

    //TEST CONSTRUCTORS ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role (enemy character).
    @Test
    void getFullHPFromStandardConstructorArgument() {
        Stats stats = new Stats(5, 3, 4);
        assertEquals(5, stats.getDefaultHP());
    }

    @Test
    void getFullPowerFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 5, 4);
        assertEquals(5, stats.getDefaultPower());
    }

    @Test
    void getFullRunnerFromStandardConstructorArgument() {
        Stats stats = new Stats(2, 3, 5);
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
    void looseTwoLivesFromTenExistingHP(){
        Stats stats = new Stats(5, 3, 4);
        stats.loseHP(2);
        assertEquals(3, stats.getCurrentHP());
    }


    @Test
    void checkMinimumZeroHP(){  //TODO Vad ska hända om HP hamnar på 0 eller under? /Malin
        Stats stats = new Stats(1, 3, 4);
        stats.loseHP(11);
        assertEquals(0, stats.getCurrentHP() + 0, stats.getDefaultHP());
    }

    @Test
    void gainTwoLivesToTwoExistingHP(){
        Stats stats = new Stats(5,10,10);
        stats.loseHP(3);
        stats.gainHP(2);
        assertEquals(4, stats.getCurrentHP());
    }

    @Test
    void checkMaximumHP(){
        Stats stats = new Stats(6, 3, 4);
        stats.loseHP(3);
        stats.gainHP(5);
        assertEquals(6, stats.getCurrentHP());
    }

    //TEST LEVEL UP STATS METHODS -----------------------------------------------------------------
    @Test
    void levelStatsUpToLevelTwo(){
        Stats stats = new Stats(8, 3, 4);
        stats.levelUpTheDefaultStats(2);
        assertEquals( 5, stats.getDefaultPower() + 6, stats.getDefaultSpeed());
    }

    @Test
    void levelUpAndReachMaxStats(){
        Stats stats = new Stats(8, 6, 6);
        stats.levelUpTheDefaultStats(5);
        assertEquals( 10, stats.getDefaultHP() + 10, stats.getDefaultSpeed());
    }

    //TEST OTHER METHODS --------------------------------------------------------------------------
    @Test
    void characterIsAttackedByAnotherCharacter(){
        //TODO Vad händer när en karaktär blir attackerad? Är det bara HP som påverkas? /Malin
        Stats stats = new Stats(8, 3, 4);
        stats.loseHP(2);
        assertEquals(6, stats.getCurrentHP());
    }

    @Test
    void doesMaxStatWork(){
        Stats stats = new Stats(8, 3, 4);
        assertEquals(10, stats.getMaxStat());
    }

    @Test
    void doesMinStatWork(){
        Stats stats = new Stats(8, 3, 4);
        assertEquals(0, stats.getMinStat());
    }


    //TEST TO-STRING-METHOD ------------------------------------------------------------------------
    @Test
    void correctToString(){
        Stats stats = new Stats(3, 3, 3);
        assertEquals("HP: 3\nPower: 3\nSpeed: 3", stats.toString());
    }
}

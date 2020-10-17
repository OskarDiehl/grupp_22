import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsTest {

    //TEST CONSTRUCTORS ------------------------------------------------------------------------
    //Constructor for character WITHOUT a role. The "standard constructor"
    @Test
    void getFullLifeFromStandardConstructorArgument() {
        Stats stats = new Stats();
        assertEquals(10, stats.getLife());
    }

    @Test
    void getFullPowerFromStandardConstructorArgument() {
        Stats stats = new Stats();
        assertEquals(10, stats.getPower());
    }

    @Test
    void getFullRunnerFromStandardConstructorArgument() {
        Stats stats = new Stats();
        assertEquals(10, stats.getSpeed());
    }

    //Constructor for character WITH a role. The "role constructor".
    @Test
    void getFullLifeFromRoleConstructorArgument(){
        Stats stats = new Stats(9, 5, 8);
        assertEquals(9, stats.getLife());
        assertEquals(5, stats.getPower());
        assertEquals(8, stats.getSpeed());
    }


    //TEST LIFE  ------------------------------------------------------------------------
    @Test
    void looseTwoLifesFromTenExistingLifes(){
        Stats stats = new Stats();
        stats.looseLifes(2);
        assertEquals(8, stats.getLife());
    }


    @Test
    void checkMinimumZeroLifes(){  //TODO Vad ska hända om life hamnar på 0 eller under? /Malin
        Stats stats = new Stats();
        stats.looseLifes(11);
        assertEquals(0, stats.getLife());
    }

    @Test
    void earnTwoLifesToFiveExistingLifes(){
        Stats stats = new Stats(5,10,10);
       stats.gainLifes(2);
        assertEquals(7, stats.getLife());
    }

    @Test
    void checkMaximumTenLifes(){
        Stats stats = new Stats();
        stats.gainLifes(2);
        assertEquals(10, stats.getLife());
    }


    //TEST POWER ------------------------------------------------------------------------
    @Test
    void decreasePowerWithThree(){
        Stats stats = new Stats();
        stats.decreasePower(3);
        assertEquals(7, stats.getPower());
    }

    //TEST SPEED ------------------------------------------------------------------------
    //TODO Ska man kunna öka och minska speed under spelets gång? /Malin


    // TEST ATTACK-METHODS ------------------------------------------------------------------------
    @Test
    void characterAttackAnotherCharacter(){
        //TODO Vad händer när en karaktär går till attack? Är det bara power som påverkas? /Malin
        Stats stats = new Stats();
        stats.attackEnemy(5);
        assertEquals(5, stats.getPower());
    }

    @Test
    void characterIsAttackedByAnOtherCharacter(){
        //TODO Vad händer när en karaktär blir attackerad? Är det bara life som påverkas? /Malin
        Stats stats = new Stats();
        stats.attackedByAnEnemy(2, 4);
        assertEquals(8, stats.getLife());
        assertEquals(6, stats.getPower());
    }

}

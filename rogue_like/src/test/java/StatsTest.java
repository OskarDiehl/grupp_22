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
    void looseTwoLifesFromTenExistingLifes(){
        Stats stats = new Stats();
        stats.looseLifes(2);
        assertEquals(8, stats.getLife());
    }

    //@Test checkMinimumZeroLifes TODO skapa test som kollar att life kan vara minst 0. Vad händer då? /Malin

    @Test
    void earnTwoLifesToFiveExistingLifes(){
        Stats stats = new Stats();
        stats.looseLifes(5);  //TODO Här använder jag en annan metod för att minska liv. Borde vi skapa en till konstruktor för Stats där man ställer in life istället? /Malin
        stats.gainLifes(2);
        assertEquals(7, stats.getLife());
    }


    // @Test checkMaximumTenLifes TODO skapa test som kollar att det kan finnas max tio liv /Malin


    //TEST POWER
    @Test
    void decreasePowerWithThree(){
        Stats stats = new Stats();
        stats.decreasePower(3);
        assertEquals(7, stats.getPower());
    }

    //TEST SPEED
    //TODO Ska man kunna öka och minska speed? /Malin


/*    @Test
    void characterAttackAnotherCharacter(){
        //TODO Vad händer när en karaktär går till attack? Är det bara power som påverkas? /Malin
        Stats stats = new Stats();
    }*/

  /*  @Test
    void characterIsAttackedByAnOtherCharacter(){
        //TODO Vad händer när en karaktär blir attackerad? Är det bara life som påverkas? /Malin
        Stats stats = new Stats();
    }*/

}

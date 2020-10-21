public class PlayerStats extends Stats {

    // 3 , 5, 8


    //VARIABLES  --------------------------------------------------------------------------
    private int currentLevel;

    // variabel för när man förändrar power och speed? /Malin


    // CONSTRUCTOR  ------------------------------------------------------------------------
    public PlayerStats(int life, int power, int speed) {
        super(life, power, speed);
        currentLevel = 1;
    }

    // OTHER METHODS  ------------------------------------------------------------------------

    //Levla upp statsen.

    //Höj power tillfälligt

    //Sänk power tillfälligt

    //Höj speed tillfälligt

    //Sänk speed tillfälligt


    //removeChangedStats

    // LEVEL-METHODS  ------------------------------------------------------------------------
    public void levelStatsUp(){
        if (currentLevel < 3)
            currentLevel++;
        else
            currentLevel = 3;
    }


    // GET-METHODS  ------------------------------------------------------------------------
    public int getCurrentLevel() {
        return currentLevel;
    }
}

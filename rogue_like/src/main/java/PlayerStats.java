public class PlayerStats extends Stats {
    //VARIABLES  --------------------------------------------------------------------------
    private int currentLevel;
    private int currentPower;
    private int currentSpeed;


    // CONSTRUCTOR  ------------------------------------------------------------------------
    public PlayerStats(int HP, int power, int speed) {
        super(HP, power, speed);
        currentLevel = 1;
        currentPower = getDefaultPower();
        currentSpeed = getDefaultSpeed();
    }


    // OTHER METHODS  ------------------------------------------------------------------------
    public void changePowerTemporary(int power) {               //Increases or decreases the power temporary
        int totalPower = currentPower + power;                  //TODO Är det ngn mening att göra den här privat och ha en metod som man "mellanlandar" hos? Är det säkrare? :)))) /Malin
        if (totalPower > getMaxStat())
            currentPower = getMaxStat();
        else if (totalPower < getMinStat())
            currentPower = getMinStat();
        else
            currentPower = currentPower + power;
    }

    public void changeSpeedTemporary(int speed) {               //Increases or decreases the speed temporary
        int totalSpeed = currentSpeed + speed;
        if (totalSpeed > getMaxStat())
            currentSpeed = getMaxStat();
        else if (totalSpeed < getMinStat())
            currentSpeed = getMinStat();
        else
            currentSpeed = currentSpeed + speed;
    }

    public void resetPowerAndSpeedToDefaultValues(){                    // Resets the power- and speed stats to their default values
        currentPower = getDefaultPower();
        currentSpeed = getDefaultSpeed();
    }

    //TODO Skapa metod för om Playern "dör" /Malin

    // LEVEL-METHODS  ------------------------------------------------------------------------
    public void levelStatsUp(){
        if (currentLevel < 3){
            currentLevel++;
            levelUpTheDefaultStats(2);                                        // When the player jump up a level all the stats increase with two
        }
        else
            currentLevel = 3;
    }


    // GET-METHODS  ------------------------------------------------------------------------
    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }


}

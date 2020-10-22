public class PlayerStats extends Stats {
    //VARIABLES  --------------------------------------------------------------------------
    private int currentLevel;
    private int currentPower;
    private int currentSpeed;


    // CONSTRUCTOR  ------------------------------------------------------------------------
    public PlayerStats(int life, int power, int speed) {
        super(life, power, speed);
        currentLevel = 1;
        currentPower = getDefaultPower();
        currentSpeed = getDefaultSpeed();
    }


    // OTHER METHODS  ------------------------------------------------------------------------
    private void increasePowerTemporary(int increasedPower) {            // Increases the power
        if ((currentPower + increasedPower) <= getMaxStat()){
            currentPower = currentPower + increasedPower;
        } else
            currentPower = getMaxStat();
    }

    private void decreasePowerTemporary(int decreasePower) {             // Decreases the power
        if ((currentPower - decreasePower) >= getMinStat())
            currentPower = currentPower - decreasePower;
        else
            currentPower = getMinStat();
    }

    private void increaseSpeedTemporary(int increasedSpeed) {            // Increases the speed
        if ((currentSpeed + increasedSpeed) <= getMaxStat()){
            currentSpeed = currentSpeed + increasedSpeed;
        } else
            currentSpeed = getMaxStat();
    }

    private void decreaseSpeedTemporary(int decreasedSpeed) {            // Decreases the speed
        if ((currentSpeed - decreasedSpeed) >= getMinStat())
            currentSpeed = currentSpeed - decreasedSpeed;
        else
            currentSpeed = getMinStat();
    }

    public void resetPowerAndSpeedToDefaultValues(){                    // Resets the power- and speed stats to their default values
        currentPower = getDefaultPower();
        currentSpeed = getDefaultSpeed();
    }

    public void changePower(Boolean increase, int amount){
        if (increase)                                                   // if increase is true -> increase power with amount
            increasePowerTemporary(amount);
        else
            decreasePowerTemporary(amount);                             // if increase is false -> decrease power with amount
    }

    public void changeSpeed(Boolean increase, int amount){
        if (increase)                                                   // if increase is true -> increase speed with amount
            increaseSpeedTemporary(amount);
        else
            decreaseSpeedTemporary(amount);                             // if increase is false -> decrease speed with amount
    }


    // LEVEL-METHODS  ------------------------------------------------------------------------
    public void levelStatsUp(){
        if (currentLevel < 3){
            currentLevel++;
            levelUp(2);                                        // When the player jump up a level all the stats increase with two
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

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
        if (increase)
            increasePowerTemporary(amount);
        else
            decreasePowerTemporary(amount);
    }

    public void changeSpeed(Boolean increase, int amount){
        if (increase)
            increaseSpeedTemporary(amount);
        else
            decreaseSpeedTemporary(amount);
    }


    // LEVEL-METHODS  ------------------------------------------------------------------------
    public void levelStatsUp(){
        if (currentLevel < 3)
            currentLevel++;
        else
            currentLevel = 3;
    }

    private void levelConditions(){
        //TODO -> Hur kommer jag åt default-variablerna? /Malin
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

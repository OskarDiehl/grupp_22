public class PlayerStats extends Stats {
    //VARIABLES  --------------------------------------------------------------------------
    private int temporaryPower;
    private int temporarySpeed;
    private int temporaryHP;


    // CONSTRUCTOR  ------------------------------------------------------------------------
    public PlayerStats(int HP, int power, int speed) {
        super(HP, power, speed);
        temporaryPower = getDefaultPower();
        temporarySpeed = getDefaultSpeed();
        temporaryHP    = getDefaultHP();
    }


    // OTHER METHODS  ------------------------------------------------------------------------

    public void changePowerTemporary(int power) {               //Increases or decreases the power temporary
        int totalPower = temporaryPower + power;
        if (totalPower > getMaxStat())
            temporaryPower = getMaxStat();
        else if (totalPower < getMinStat())
            temporaryPower = getMinStat();
        else
            temporaryPower = temporaryPower + power;
    }

    public void changeSpeedTemporary(int speed) {               //Increases or decreases the speed temporary
        int totalSpeed = temporarySpeed + speed;
        if (totalSpeed > getMaxStat())
            temporarySpeed = getMaxStat();
        else if (totalSpeed < getMinStat())
            temporarySpeed = getMinStat();
        else
            temporarySpeed = temporarySpeed + speed;
    }

    public void changeHPTemporary(int HP) {               //Increases or decreases the HP temporary
        int totalHP = temporaryHP + HP;
        if (totalHP > getMaxStat())
            temporaryHP = getMaxStat();
        else if (totalHP < getMinStat())
            temporaryHP = getMinStat();
        else
            temporaryHP = temporaryHP + HP;
    }

    public void resetPowerAndSpeedToDefaultValues(){                    // Resets the power- and speed stats to their default values
        temporaryPower = getDefaultPower();
        temporarySpeed = getDefaultSpeed();
        temporaryHP    = getDefaultHP();
    }


    // LEVEL-METHODS  ------------------------------------------------------------------------
    public void levelStatsUp(){
            levelUpTheDefaultStats(2);                         // When the player jump up a level all the stats increase with two
    }


    // GET-METHODS  ------------------------------------------------------------------------
    public int getTemporaryPower() {
        return temporaryPower;
    }

    public int getTemporarySpeed() {
        return temporarySpeed;
    }

    public int getTemporaryHP() {
        return temporaryHP;
    }
}

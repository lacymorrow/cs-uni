
/**
 * Write a description of class Tank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tank
{
    // instance variables - replace the example below with your own
    private double floatLev;
    private double maxCap;
    private Meter meterInd;

    /**
     * Constructor for objects of class Tank
     */
    public Tank(Meter floatInd,double capacity)
    {
        // initialise instance variables
        floatLev = 0;
        maxCap = capacity;
        meterInd = floatInd;
    }

    public void setFloatLevel(double newLevel)
    {
        floatLev = newLevel;
        meterInd.setQuantity(newLevel);
    }
    
    public double getLevel(){
        return floatLev;
    }
}

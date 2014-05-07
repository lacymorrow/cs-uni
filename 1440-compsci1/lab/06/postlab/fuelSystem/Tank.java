
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
    private Rect lowAlert;

    /**
     * Constructor for objects of class Tank
     */
    public Tank(Meter floatInd, Rect lowInd, double level,double capacity)
    {
        // initialise instance variables
        floatLev = level;
        maxCap = capacity;
        meterInd = floatInd;
        lowAlert = lowInd;
    }

    public void setFloatLevel(double newLevel)
    {
        floatLev = newLevel;
        meterInd.setQuantity(newLevel);
        if(newLevel <= 10){
            lowAlert.makeVisible();
        } else {
            lowAlert.makeInvisible();
        }
    }
    
    public double getLevel(){
        return floatLev;
    }
}

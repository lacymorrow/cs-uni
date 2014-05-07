
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

    /**
     * Constructor for objects of class Tank
     */
    public Tank(double capacity)
    {
        // initialise instance variables
        floatLev = 0;
        maxCap = capacity;
    }

    public void setFloatLevel(double newLevel)
    {
        floatLev = newLevel;
    }
    
    public double getLevel(){
        return floatLev;
    }
}

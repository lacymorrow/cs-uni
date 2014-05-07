
/**
 * Write a description of class FuelSystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FuelSystem
{
    // instance variables - replace the example below with your own
    private Meter fuelInd;
    private Tank fuelTank;

    /**
     * Constructor for objects of class FuelSystem
     */
    public FuelSystem()
    {
        // initialise instance variables
        fuelInd = new Meter("Fuel",30,30,"red",0,100,200);
        fuelTank = new Tank(fuelInd, 200);
    }
    
    public Tank getTank(){
        return fuelTank;
    }
}

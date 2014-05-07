
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
    private Rect lowInd;

    /**
     * Constructor for objects of class FuelSystem
     */
    public FuelSystem()
    {
        // initialise instance variables
        lowInd = new Rect(15,15, 30, 70);
        lowInd.makeInvisible();
        fuelInd = new Meter("Fuel",30,30,"red",50,100,200);
        fuelTank = new Tank(fuelInd, lowInd, 50, 100);
    }
    
    public Tank getTank(){
        return fuelTank;
    }
}

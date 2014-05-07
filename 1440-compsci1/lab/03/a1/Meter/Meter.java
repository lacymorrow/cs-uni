
/**
 * Write a description of class Meter here.
 * 
 * @author Thomas Morrow
 * @version a1
 */
public class Meter
{
    // instance variables - replace the example below with your own
    private double quantity;
    private double maxQuantity;
    
    /**
     * Constructor for objects of class Meter
     */
    public Meter(double initialQuantity, double maximumQuantity)
    {
        quantity = initialQuantity;
        maxQuantity = maximumQuantity;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getQuantity()
    {
        return quantity;
    }
    public void setQuantity(double q)
    {
        quantity = q;
    }
}

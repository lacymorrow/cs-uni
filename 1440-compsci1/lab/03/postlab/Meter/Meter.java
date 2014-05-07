
/**
 * Write a description of class Meter here.
 * 
 * @author Thomas Morrow
 * @version a1
 */
public class Meter
{
    // instance variables - replace the example below with your own
    private Rect rectGry;
    private Rect rectMet;
    private double quantity;
    private double maxQuantity;
    private double maxPixels;
    private String metName;
    private Text label;
    
    /**
     * Constructor for objects of class Meter
     */
    public Meter(int x, int y, double initialQuantity, double maximumQuantity, double maxPixelWidth)
    {
        if (initialQuantity < 0) {
            System.out.println("Illegal for initial quantity: " + initialQuantity + ".  Setting to zero.");
            initialQuantity = 0;
        }
        if (x > 300) {
            System.out.println("Illegal for x: " + x + ".  Setting to zero.");
            x = 0;
        }
        quantity = initialQuantity;
        maxQuantity = maximumQuantity;
               if (quantity > maxQuantity) {
            System.out.println("Illegal for quantity: " + quantity + ".  Setting to max.");
            quantity = maxQuantity;
        }
        maxPixels = maxPixelWidth;
        metName = "Meter";
        rectGry = new Rect(maxPixelWidth,20,x,y);
        rectGry.changeColor("gray");
        rectMet = new Rect((quantity/maximumQuantity) * maxPixelWidth,20,x,y);
        rectMet.changeColor("black");
        label = new Text(metName+"   ::   Quantity = "+getQuantity(), "black", x, y-10);
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
        if (quantity < 0) {
            System.out.println("Illegal for quantity: " + quantity + ".  Setting to zero.");
            quantity = 0;
        }
        if (quantity > maxQuantity) {
            System.out.println("Illegal for quantity: " + quantity + ".  Setting to max.");
            quantity = maxQuantity;
        }
        rectMet.changeSize((quantity/maxQuantity) * maxPixels,20);
        label.changeString(metName+"   ::   Quantity = "+getQuantity());
    }
}

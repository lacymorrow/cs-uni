
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
    public Meter(String name, int x, int y, String color, double initialQuantity, double maximumQuantity, double maxPixelWidth)
    {
        quantity = initialQuantity;
        maxQuantity = maximumQuantity;
        maxPixels = maxPixelWidth;
        metName = name;
        rectGry = new Rect(maxPixelWidth,20,x,y);
        rectGry.changeColor("gray");
        rectMet = new Rect((quantity/maximumQuantity) * maxPixelWidth,20,x,y);
        rectMet.changeColor(color);
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
        rectMet.changeSize((quantity/maxQuantity) * maxPixels,20);
        label.changeString(metName+"   ::   Quantity = "+getQuantity());
    }
}

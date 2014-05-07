
/**
 * Write a description of class TestGraphicObjects here.
 * 
 * @author Thomas Morrow
 * @version a0
 */
public class TestGraphicObjects
{
    private Text label;
    private Rect rectGrn;
    private Rect rectBlu;
    private Rect rectYel;
    private Rect rectBlk;
    private double maxVal;
    private double maxWidth;
    private double barLength;
    /**
     * Constructor for objects of class TestGraphicObject
     */
    public TestGraphicObjects()
    {
        maxVal = 1000.0;
        maxWidth = 200.0;
        rectGrn = new Rect(200,20,100,200);
        rectGrn.changeColor("green");
        rectBlu = new Rect(50,20,100,250);
        rectBlu.changeColor("blue");
        rectYel = new Rect(240,20,100,300);
        rectYel.changeColor("yellow");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void showQuantityBar(double quantity, int x, int y)
    {
        barLength = quantity * (maxWidth/maxVal);
        rectBlk = new Rect(barLength,20,x,y);
        rectBlk.changeColor("black");
    }
    
    public void showQuantityBar(String name, double quantity, int x, int y)
    {
        barLength = quantity * (maxWidth/maxVal);
        rectBlk = new Rect(barLength,20,x,y);
        rectBlk.changeColor("black");
        label = new Text(name, "blue", x, y-10);        
    }
}

/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Picture
{
    private Square face;
    private Circle one;
    private Circle two;
    private Circle three;
    private Circle four;
    private Circle five;
    private Rect top;
    private Rect side;
    private RightTriangle tl;
    private RightTriangle tr;
    private RightTriangle ts;
    private RightTriangle bs;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        draw();
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        face = new Square(100, 50, 50, "blue", true);

        one = new Circle(20, 90, 90, "white", true);
        
        two = new Circle(20, 60, 60, "white", true);
        
        three = new Circle(20, 120, 120, "white", true);
        
        four = new Circle(20, 120, 60, "white", true);
        
        five = new Circle(20, 60, 120, "white", true);
        
        top = new Rect(70, 29, 20, 80, "blue", true);
        
        side = new Rect(151, 50, 80, 20, "blue", true);
        
        tl = new RightTriangle(90, 70, 49, 20, "blue", true);
        
        tr = new RightTriangle(270, 150, 29, 20, "blue", true);
        
        ts = new RightTriangle(90, 171, 50, 20, "blue", true);
        
        bs = new RightTriangle(270, 151, 130, 20, "blue", true);
    }

}

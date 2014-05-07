import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text
{
    private String textString;
    private String color;
    private Point pos;
    private boolean isVisible = false;
    
    /**
     * construct a text string for the graphical display
     */
    public Text(String s, String colorString, int x, int y) 
    {
        pos = new Point(x,y);
        textString = s;
        color = colorString;
        isVisible = true;
        draw();
    }
    /**
     * changes text
     */
    public void changeString(String newString)
    {
        textString = newString;
        draw();
    }
    
    /**
     * Make this text visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this text invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    /**
     * sets the position of the text.
     */
    public void changePosition(int x, int y)
    {
        pos = new Point(x,y);
        draw();
    }
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Draw the text with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,textString, pos);
            canvas.wait(10);
        }
    }    
    
   private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}

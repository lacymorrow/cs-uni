/**
 * An isosceles right triangle
 *
 * @author Ray Russell
 * @version 1.2 (Spring 2009)
 * 
 * @author  Kenneth Jacker
 * @version 1.1  (Spring 2006)
 *
 * @author  Jay Fenwick
 * @version 1.0  (Spring 2005) 
 */

import java.awt.*;

public class RightTriangle
{
    private int     triType;       // 0, 90, 180, or 270
    private int     xPosition;
    private int     yPosition;
    private int     sideLen;
    private String  color;
    private boolean isVisible;

    /**
     * Create a new, non-rotated triangle at default position with default color.
     */
    public RightTriangle()
    {
        triType   =   0;
        xPosition =  50;
        yPosition = 100;
        sideLen   =  30;
        color     = "green";
        isVisible = false;
    }
    /**
     * A parameterized constructor
     */
    public RightTriangle(int type, int x, int y, int len, String color, boolean visibility)
    {
        triType    = type;
        xPosition  = x;
        yPosition  = y;
        sideLen    = len;
        this.color = color;
        if (visibility) {
            makeVisible();
        } else {
           isVisible  = false;
        }
    }

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the triangle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the triangle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the triangle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newLen)
    {
        erase();
        sideLen = newLen;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /*
     * Draw the triangle with current specifications on screen.
     */
    private void draw()
    {
        int x[] = new int[3]; int y[] = new int[3];;

        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int l         = sideLen;

            x[0] = xPosition;  y[0] = yPosition;

            switch (triType) {
                case   0:
                    x[1] = xPosition + l;  x[2] = xPosition;
                    y[1] = yPosition;      y[2] = yPosition - l;
                    break;
    
                case  90:
                    x[1] = xPosition;      x[2] = xPosition - l;
                    y[1] = yPosition - l;  y[2] = yPosition;
                    break;
    
                case 180:
                    x[1] = xPosition - l;  x[2] = xPosition;
                    y[1] = yPosition;      y[2] = yPosition + l;
                    break;
    
                case 270:
                    x[1] = xPosition;      x[2] = xPosition + l;
                    y[1] = yPosition + l;  y[2] = yPosition;
                    break;
    
                default:
	            System.out.println("Invalid right triangle type!");
                    System.exit(1);
            }

            canvas.draw(this, color, new Polygon(x, y, 3));
            canvas.wait(10);
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}

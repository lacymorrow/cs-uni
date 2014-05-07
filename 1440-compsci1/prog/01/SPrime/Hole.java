
/**
 * Hole
 * 
 * @author Lacy Morrow
 * @version 0.1
 */
public class Hole
{
    // instance variables - replace the example below with your own
    private char theHole;

    /**
     * Constructor for objects of class Hole
     */
    public Hole()
    {
        // initialise instance variables
        theHole = 'o';
    }

    public boolean isOpen()
    {
        if(theHole=='o'){
            return true;
        } else {
            return false;
        }
    }
    
    public void plug(){
        theHole='x';
    }
}

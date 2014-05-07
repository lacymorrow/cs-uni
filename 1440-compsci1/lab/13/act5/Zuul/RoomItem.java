
/**
 * Write a description of class RoomItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class RoomItem
{
    private String name;

    /**
     * Constructor for objects of class RoomItem
     */
    public RoomItem(String name)
    {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}

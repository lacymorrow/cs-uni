
/**
 * Write a description of class LacyCastle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LacyCastle extends Castle
{

    /**
     * Constructor for objects of class LacyCastle
     */
    public LacyCastle()
    {
        clearRooms();
        createRooms();
    }
    
    public void createRooms(){
        Room dungeon;
        FurnishedRoom cell;
        // create the rooms
        dungeon = new Room("in a dungeon");
        addRoom(dungeon);
        cell = new FurnishedRoom("in solitary confinement cell");
        addRoom(cell);
        
        //add items
        cell.addItem(new LifePotion());
        
        // initialise room exits
        dungeon.setExit("metalDoor", cell);

        // start game in dungeon
        setCurrentRoom(dungeon);
    }
}


/**
 * Sets all rooms of castle
 */

import java.util.ArrayList;

public class Castle
{
    private ArrayList<Room> rooms;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Castle() 
    {
        clearRooms();
        createRooms();
    }

    public void clearRooms() {
        rooms = new ArrayList<Room>();
        currentRoom = null;
    }
    public void addRoom(Room r) {rooms.add(r);}
    public void setCurrentRoom(Room r) {currentRoom = r;}
    public Room getCurrentRoom() {return currentRoom;}
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room drawbridge, courtyard, smithy, tower, tunnel;
      
        // create the rooms
        drawbridge = new Room("on the drawbridge");
        addRoom(drawbridge);
        courtyard = new Room("in the main courtyard");
        addRoom(courtyard);
        smithy = new Room("in the blacksmith shop");
        addRoom(smithy);
        tower = new Room("in the prison tower");
        addRoom(tower);
        tunnel = new Room("in a secret tunnel under the tower");
        addRoom(tunnel);
        
        // initialise room exits
        drawbridge.setExit("forward", courtyard);
        courtyard.setExit("backward", drawbridge);
        courtyard.setExit("left", smithy);
        smithy.setExit("right", courtyard);
        courtyard.setExit("right", tower);
        tower.setExit("left", courtyard);

        tower.setExit("trapdoor", tunnel);
        tunnel.setExit("trapdoor", tower);


        // start game outside
        setCurrentRoom(drawbridge);  
    }


}

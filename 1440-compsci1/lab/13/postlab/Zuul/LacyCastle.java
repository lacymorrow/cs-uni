
/**
 * Constructs a casle object with custom layout
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
        FurnishedRoom dungeon, cell, palace, fountain;
        // create the rooms
        dungeon = new FurnishedRoom("in a dungeon, you see the trapdoor to the palace distant above you");
        addRoom(dungeon);
        cell = new FurnishedRoom("in a solitary confinement cell with no exits. You are left to waste away");
        addRoom(cell);
        palace = new FurnishedRoom("in the palace in front of the king. You were brought here by armed guards");
        addRoom(palace);
        fountain = new FurnishedRoom("in a mysterious room with a glowing fountain in it");
        addRoom(fountain);
        
        //add items
        cell.addItem(new PoisonPotion());
        fountain.addItem(new LifePotion());
        
        // initialise room exits
        palace.setExit("forward", dungeon);
        dungeon.setExit("left", fountain);
        dungeon.setExit("right", cell);
        fountain.setExit("right", dungeon);

        // start game in dungeon
        setCurrentRoom(palace);
    }
}

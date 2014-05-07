import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
/**
 * Room with contained items
 */
public class FurnishedRoom extends Room
{
    private HashMap<String,RoomItem> items;

    /**
     * Constructor for objects of class FurnishedRoom
     */
    public FurnishedRoom(String description)
    {
        super(description);
        items = new HashMap<String,RoomItem>();
    }
    
    public String getLongDescription(){
        return super.getLongDescription() + getItemString() + "\n";
    }
    
    public void addItem(RoomItem item){
        items.put(item.getName(),item);
    }
    
    public RoomItem removeItem(String itemName){
        RoomItem ret = items.get(itemName);
        items.remove(itemName);
        return ret;
    }
    
    private String getItemString()
    {
        String itemString = "Items:";
        Set keys = items.keySet();
        if (keys.size() == 0) itemString += " None.";
        else {
           for(Iterator iter = keys.iterator(); iter.hasNext(); )
              itemString += " " + iter.next();
        }
        return itemString;
    }
}

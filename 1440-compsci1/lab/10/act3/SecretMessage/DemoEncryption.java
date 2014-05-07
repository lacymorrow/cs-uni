
/**
 * Demonstrates Encryption Model
 * 
 * @author Lacy Morrow
 * @version 0.1
 */
public class DemoEncryption
{

    /**
     * Constructor for objects of class DemoEncryption
     */
    public DemoEncryption()
    {
        
    }

    public String swap(char a, char b, String clear){
        clear = clear.replace(a,'$');
        clear = clear.replace(b,a);
        clear = clear.replace('$',b);
        return clear;
    }
    
    public String mutateOnePair(Pair pair, String swapStr){
        return swap(swapStr.charAt(pair.getFirstIndex()),swapStr.charAt(pair.getSecondIndex()),swapStr);
    }
    
    public String mutate(String swapStr, RandomPairList randList){
        for(int i=0;i<randList.size();i++){
            swapStr = mutateOnePair(randList.getPair(i), swapStr);
        }
        return swapStr;
    }
}


/**
 * Demonstrates Encryption Model
 * 
 * @author Lacy Morrow
 * @version 0.1
 */
public class DemoEncryption
{
    private String clearText;
    private String encryptedText;
    private RandomPairList pairList;
    /**
     * Constructor for objects of class DemoEncryption
     */
    public DemoEncryption(String text)
    {
        pairList = new RandomPairList(text.length()/4,text.length());
        System.out.println("Original Text:");
        System.out.println(text+"\n");
        pairList.display();
        encryptedText = mutate(text,pairList);
        System.out.println("Encrypted Text:");
        System.out.println(encryptedText+"\n");
        //reverse encryption
        pairList.reverse();
        clearText = mutate(encryptedText,pairList);
        System.out.println("Clear Text:");
        System.out.println(clearText);
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

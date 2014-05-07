public class Pair
{
    // instance variables - replace the example below with your own
    private int firstIndex;
    private int secondIndex;

    /**
     * Constructor for objects of class Pair
     */
    public Pair()
    {
        // initialise instance variables
        firstIndex = secondIndex = 0;        
    }
    
    public Pair(int firstIndex,int secondIndex){
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }
    
    public void setFirstIndex(int i){
        firstIndex = i;
    }
    
    public void setSecondIndex(int i){
        secondIndex = i;
    }
    
    public int getFirstIndex(){
        return firstIndex;
    }
    
    public int getSecondIndex(){
        return secondIndex;
    }
}

import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class RandomPairList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPairList
{
    // instance variables - replace the example below with your own
    private ArrayList<Pair> pairs;
    private Random genRandom;

    /**
     * Constructor for objects of class RandomPairList
     */
    public RandomPairList()
    {
        pairs = new ArrayList<Pair>();
        genRandom = new Random();
    }
    
    public RandomPairList(int n, int limit)
    {
        pairs = new ArrayList<Pair>();
        genRandom = new Random();
        generateRandomPairList(n,limit);
    }
    
    public Pair getPair(int index){
        return pairs.get(index);
    }
    
    public int size(){
        return pairs.size();
    }
    
    public void generateRandomPairList(int n, int limit){
        pairs.clear();
        for(int i=0;i<n;i++){
            pairs.add(new Pair(genRandom.nextInt(limit),genRandom.nextInt(limit)));
        }
    }
    
    public void display(){
        System.out.println("firstIndex\tsecondIndex");
        for(int i=0;i<size();i++){
            System.out.println(pairs.get(i).getFirstIndex()+"\t\t"+pairs.get(i).getSecondIndex());
        }
    }
    public void reverse()
    {
        ArrayList<Pair> holder = new ArrayList<Pair>();
        for (int i = pairs.size()-1; i >= 0; i--) {
           holder.add(pairs.get(i));
        }
        pairs = holder;
     }

}
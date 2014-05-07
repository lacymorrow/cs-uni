import java.lang.Math;
/**
 * Sieve
 * 
 * @author Lacy Morrow
 * @version 0.1
 * Sieve
 */
public class Sieve
{
    // instance variables - replace the example below with your own
    private Hole[] hole;
    private int lastHole;
    private int checkTo;
    /**
     * Constructor for objects of class Sieve
     */
    public Sieve(int maxHole)
    {
        hole = new Hole[maxHole+1];
        for(int i=0;i<=maxHole;i++){
            hole[i] = new Hole();
        }
        lastHole = hole.length;
        checkTo = lastHoleToPlug();
    }
    
    public void plugHoles()
    {
        for(int i=2;i<checkTo;i++){
            if(hole[i].isOpen() == true){
                plugMultiples(i);
            }
        }
    }
    
    public void plugMultiples(int p){
        for(int a=p+p;a<lastHole;a+=p){
            if(hole[a].isOpen() == true){
                hole[a].plug();
            }
        }
    }
    
    public void filterNumbers(boolean horizontal){
        System.out.println("Filtered Numbers up to");
        System.out.println("---------"+(lastHole-1)+"---------");
        if(horizontal == true){
            int a = 0;
            for(int i=0;i<lastHole;i++){
                if(hole[i].isOpen() == true){
                    if(a<71){
                        System.out.print(i+",");
                        a += ((""+i).length())+1;
                    } else {
                        System.out.print("\n"+i+",");
                        a = (""+i).length()+1;
                    }
                }
            }
        } else {
            for(int i=0;i<lastHole;i++){
                if(hole[i].isOpen() == true){
                    System.out.println(i);
                }
            }
        }
    }
    
    private int lastHoleToPlug(){
        return (int)Math.round(Math.sqrt(lastHole));
    }
            
    
    public void reset(){
        for(int i=0;i<lastHole;i++){
            hole[i] = new Hole();
        }
    }
}

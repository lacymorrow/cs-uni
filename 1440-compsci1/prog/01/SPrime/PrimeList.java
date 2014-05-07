
/**
 * Creates a Sieve with n number of holes
 * 
 * @author Lacy Morrow
 * @version 0.1
 * PrimeList
 */
public class PrimeList
{
    // instance variables - replace the example below with your own
    private Sieve sieve;
    private boolean horizontal;

    /**
     * Constructor for objects of class PrimeList
     */
    public PrimeList (int lastHole, boolean horizontal) 
    {
        // constructor that creates a sieve with lastHole number of holes
        sieve = new Sieve(lastHole);
        this.horizontal = horizontal;
    }

    public void displayPrimeList()
    {
        sieve.reset();
        sieve.plugHoles();
        sieve.filterNumbers(horizontal);
    }
    
    public void minusMultiples(int p)
    {
        sieve.reset();
        sieve.plugMultiples(p);
        sieve.filterNumbers(horizontal);
    }
}

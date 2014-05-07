
/**
 * LemonadeStand Class
 * Creates an instance of a lemonade stand for one day of activities
 * 
 * @author Lacy Morrow 9/29/09
 * @version 0.1
 */
public class LemonadeStand
{
    private int lemons;
    private int water; //in gallons
    private int sugar; //in cups
    private int empties; //in 16oz units
    private int glasses; //in 16oz units
    private int price; //in cents
    private int profit; //in cents


    /**
     * Constructor for objects of class LemonadeStand
     */
    public LemonadeStand(int lemonAmt, int waterAmt, int sugarAmt, int glassAmt, int priceAmt)
    {
        lemons = lemonAmt;
        water = waterAmt;
        sugar = sugarAmt;
        empties = glassAmt;
        glasses = 0;
        price = priceAmt;
        profit = 0;

    }

}


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
    
    public int makeLemonade(){
        if(checkIngredients() == true){
            lemons -= 6;
            water -= 1;
            sugar -= 1;
            empties -= 8;
            glasses += 8;
            return glasses;
        } else {
            //NOT ENOUGH INGREDIENTS
            return glasses;
        }
    }
    
    public boolean checkIngredients(){
        if(lemons>=6 && water>=1 && sugar>=1 && empties>=8){
            return true;
        } else {
            return false;
        }
    }
    
    public int sellLemonade(int amount){
        if(glasses >= amount){
            glasses -= amount;
            profit += price*amount;
            return glasses;
        } else if(checkIngredients() == true){
            makeLemonade();
            glasses -= amount;
            profit += price*amount;
            return glasses;
        } else {
            return glasses;
        }
    }
    
    public void displayInventory(){
        System.out.println("Number of Lemons: "+lemons);
        System.out.println("Gallons of Water: "+water);
        System.out.println("Cups of Sugar: "+sugar);
        System.out.println("Number of Empty Glasses: "+empties);
        System.out.println("Number of Full Glasses: "+glasses);
    }
    
    public void displayMoney(){
        System.out.println("Daily Rate: "+price+" cents/glass");
        System.out.println("Total daily profit: "+profit+" cents");
    }

}

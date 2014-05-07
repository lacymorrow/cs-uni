
/**
 * Loan Portfolio
 * 
 * @author Lacy Morrow 
 * @version 0.1
 */
public class Loan
{
    // instance variables - replace the example below with your own
    private double initialPrinciple;
    private double currentBalance;
    private double monthlyInterestRate;
    private int term;
    private int paymentsMade;

    /**
     * Constructor for objects of class Loan
     */
    public Loan(double initialPrinciple, double yearlyInterestRate, int term)
    {
        // initialise instance variables
        initialPrinciple = this.initialPrinciple;
        monthlyInterestRate = yearlyInterestRate/100/12;
        term = this.term;
        currentBalance = initialPrinciple;
        paymentsMade = 0;
    }

    /**
     * getInitialPrinciple
     * 
     * @return     initialPrinciple 
     */
    public double getInitialPrinciple()
    {
        return initialPrinciple;
    }
    /**
     * getCurrentBalance
     * 
     * @return     currentBalance 
     */
    public double getCurrentBalance()
    {
        return currentBalance;
    }
    /**
     * getMonthlyInterestRate
     * 
     * @return     monthlyInterestRate 
     */
    public double getMonthlyInterestRate()
    {
        return monthlyInterestRate;
    }
    /**
     * getTerm
     * 
     * @return     term
     */
    public int getTerm()
    {
        return term;
    }
        /**
     * getPaymentsMade
     * 
     * @return     paymentsMade
     */
    public int getPaymentsMade()
    {
        return paymentsMade;
    }
}

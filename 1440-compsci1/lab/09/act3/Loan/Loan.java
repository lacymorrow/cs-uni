
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
    private double monthlyPayment;

    /**
     * Constructor for objects of class Loan
     */
    public Loan(double initialPrinciple, double yearlyInterestRate, int term)
    {
        // initialise instance variables
        this.initialPrinciple = initialPrinciple;
        monthlyInterestRate = yearlyInterestRate/100/12;
        this.term = term;
        currentBalance = initialPrinciple;
        paymentsMade = 0;
        calcMonthlyPayment();
    }
    
    private void makePayment(){
        if(currentBalance >= monthlyPayment-(currentBalance * monthlyInterestRate)){
            paymentsMade++;
            currentBalance += monthlyPayment-(currentBalance * monthlyInterestRate);
        } else {
            
        }
    }
    
    private void calcMonthlyPayment(){
        double termSubfactor = Math.pow(1.0+monthlyInterestRate, term) ;
        double rateFactorDenom = termSubfactor-1.0 ; // uses termSubfactor
        double adjustedRateFactor = monthlyInterestRate/rateFactorDenom ; // uses rateFactorDenom
        double adjustedRate = monthlyInterestRate+adjustedRateFactor ; // uses adjustedRateFactor
        monthlyPayment = roundToCents(adjustedRate*initialPrinciple) ; // uses adjustedRate
    }
    
    private double roundToCents(double amount) {
        return (Math.floor((amount * 100.0) + .5) / 100.0);
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
    /**
     * getMonthlyPayment
     * 
     * @return     monthlyPayment
     */
    public double getMonthlyPayment()
    {
        return monthlyPayment;
    }
}

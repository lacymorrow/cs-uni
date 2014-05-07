import java.util.ArrayList;
/**
 * Keeps a portfolio of loans
 * 
 * @author Lacy Morrow
 * @version 0.1
 */
public class LoanPortfolio
{
    // instance variables - replace the example below with your own
    private ArrayList<Loan> loans;

    /**
     * Constructor for objects of class LoanPortfolio
     */
    public LoanPortfolio()
    {
        loans = new ArrayList<Loan>();
    }
    
    public void listLoans(){
        int i=1;
        for (Loan currLoan : loans){
            System.out.println("Loan "+i);
            System.out.println("-----------------");
            currLoan.displayLoan();
            System.out.println();
            i++;
        }
    }
    
    public void add(Loan newLoan)
    {
        loans.add(newLoan);
    }
    
    public void remove(int l){
        if(loans.size()-1>=l){
            loans.remove(l);
        }
    }
}

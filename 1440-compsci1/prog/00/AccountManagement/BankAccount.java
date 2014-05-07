
/**
 * Write a description of class BankAccount here.
 * 
 * @author Lacy Morrow
 * @version 0.1
 */
public class BankAccount
{
    // instance variables - replace the example below with your own
    private double interestRate; //percentage
    private int accountNumber;
    private int balance; //in cents
    private String name;
    private String holder;

    /**
     * Constructor for objects of class BankAccount
     */
    public BankAccount()
    {
        interestRate = 7.5;
        accountNumber = 1986309;
        balance = 3001;
        name = "Primary Checking";
    }
    
    public BankAccount(double interestRate, int accountNumber, int balance, String name)
    {
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }
    
    /**
     * accountTransfer Method
     */
    
    public boolean accountTransfer(BankAccount fromAccount, int amount){
        if(amount>0 && fromAccount.withdraw(amount) == true){
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Methods
     */
    public void deposit(int amount){
        if(amount>0){
            balance += amount;
        }
    }
    
    public boolean withdraw(int amount){
        if(balance > amount && amount > 0){
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    public void addMonthlyInterest(){
        balance += (interestRate/100.0/12*balance);
    }
    
    public void setBalance(int amount){
        if(amount >= 0){
            balance = amount;
        }
    }
    
    public void setAccountNumber(int acctNumber){
        accountNumber = acctNumber;
    }
    
    public void setInterestRate(double ir){
        interestRate = ir;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public String getBalanceString(){
        holder = "$"+(balance/100)+"."+(balance%100);
        if(holder.substring(holder.indexOf(".")).length() == 2){
            holder = ""+holder.substring(0,holder.indexOf("."))+".0"+holder.substring(holder.indexOf(".")+1, holder.length());
        }
        return holder;
    }
    
    public String getAccountInformation(){
        holder = "$"+(balance/100)+"."+(balance%100);
        if(holder.substring(holder.indexOf(".")).length() == 2){
            holder = ""+holder.substring(0,holder.indexOf("."))+".0"+holder.substring(holder.indexOf(".")+1, holder.length());
        }
        return "Account name: "+name+"\nAccount number: "+accountNumber+"\nBalance: "+holder+"\nInterest Rate: "+interestRate+"%";
    }
    
    public void displayAccountInformation(){
        System.out.println("Account name: "+name+"\nAccount number: "+accountNumber+"\nBalance: "+holder+"\nInterest Rate: "+interestRate+"%");
    }
    
    /**
     * Accessor Methods
     */
    public double getInterestRate(){
        return interestRate;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public int getAccountNumber(){
        return accountNumber;
    }
    
    public String getName(){
        return name;
    }
    
    
}

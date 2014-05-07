/**
 * TestBankAccount provides methods to do simple testing of the BankAccount methods
 * from Program 0
 * 
 * The names of the methods indicate what BankAccount methods they test.
 * 
 * Test your BankAccount methods in the following order. Do not try to test methods
 * later in this list until all earlier methods pass.
 *    testConstructorAndAccessors();
 *    testDeposit();
 *    testWithdraw();
 *    testMutators();
 *    testAddMonthlyInterest();
 *    testGetBalanceString();
 *    testGetAccountInformation();
 *    
 * The method displayAccountInformation() cannot be automatically tested. You will need
 * to do that yourself by inspection.
 * 
 * You can test all methods (except displayAccountInformation()) by running testAllMethods();
 * however, do not attempt that until you have gone through the list above one at a time and 
 * made sure that everything passes.
 * 
 * Once your program works, if you make any modifications to your program such as documentation
 * or identifier name changes, etc. Use testAllMethods() to make sure everything still works.
 * 
 * @author Ray Russell 
 * @version 2005-09-22
 */
public class TestBankAccount
{
        BankAccount testAccount;

	public TestBankAccount()
	{
		
	}

	public void testAllMethods()
	{
		testConstructorAndAccessors();
		testDeposit();
		testWithdraw();
		testMutators();
		testAddMonthlyInterest();
		testGetBalanceString();
		testGetAccountInformation();
	}
	
    public void testConstructorAndAccessors()
	{
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		if (testAccount.getInterestRate() == 6.0)
		   System.out.println("getInterestRate passed");
		else
		   System.out.println("getInterestRate failed");
		if (testAccount.getAccountNumber() == 1234)
		   System.out.println("getAccountNumber passed");
		else
		   System.out.println("getAccountNumber failed");
		if (testAccount.getBalance() == 20000)
		   System.out.println("getBalance passed");
		else
		   System.out.println("getBalance failed");
		if (testAccount.getName().equals("MyAccount"))
		   System.out.println("getName passesd");
		else
		   System.out.println("getName failed");
	}
	
	public void testDeposit()
	{
	    testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.deposit(2000);
	    if (testAccount.getBalance() == 22000)
	       System.out.println("deposit passed on normal data");
		else
		   System.out.println("getName failed on normal data");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.deposit(0);
	    if (testAccount.getBalance() == 20000)
	       System.out.println("deposit passed on 0 deposit");
		else
		   System.out.println("getName failed on 0 deposit");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.deposit(-100);
	    if (testAccount.getBalance() == 20000)
	       System.out.println("deposit passed on negative deposit");
		else
		   System.out.println("getName failed on negative deposit");
	}
	
	public void testWithdraw()
	{
	    testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.withdraw(2000);
	    if (testAccount.getBalance() == 18000)
	       System.out.println("deposit passed on normal data");
		else
		   System.out.println("getName failed on normal data");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.withdraw(0);
	    if (testAccount.getBalance() == 20000)
	       System.out.println("deposit passed on 0 deposit");
		else
		   System.out.println("getName failed on 0 deposit");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.withdraw(-100);
	    if (testAccount.getBalance() == 20000)
	       System.out.println("deposit passed on negative deposit");
		else
		   System.out.println("getName failed on negative deposit");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
	    testAccount.withdraw(100000);
	    if (testAccount.getBalance() == 20000)
	       System.out.println("deposit passed on overdraft attempt");
		else
		   System.out.println("getName failed on overdraft attempt");
	}
	
	public void testMutators()
	{
	    testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		testAccount.setInterestRate(8.0);
		if (testAccount.getInterestRate() == 8.0)
		   System.out.println("setInterestRate passed");
		else
		   System.out.println("setInterestRate failed");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		testAccount.setAccountNumber(3456);
		if (testAccount.getAccountNumber() == 3456)
		   System.out.println("setAccountNumber passed");
		else
		   System.out.println("setAccountNumber failed");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		testAccount.setName("Primary Checking");
		if (testAccount.getName().equals("Primary Checking"))
		   System.out.println("setName passed");
		else
		   System.out.println("setName failed");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		testAccount.setBalance(10000000);
		if (testAccount.getBalance() == 10000000)
		   System.out.println("setBalance passed normal input");
		else
		   System.out.println("setBalance failed normal input");
		testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		testAccount.setBalance(-500);
		if (testAccount.getBalance() == 20000)
		   System.out.println("setBalance passed with negative input");
		else
		   System.out.println("setBalance failed with negative input");
   }
   
   public void testAddMonthlyInterest()
	{
	    testAccount = new BankAccount (6.0, 1234, 20000, "MyAccount");
		testAccount.addMonthlyInterest();
		if (testAccount.getBalance() == 20100)
		   System.out.println("addMonthlyInterest passed");
		else
		   System.out.println("addMonthlyInterest failed");
	}
	
	public void testGetBalanceString()
	{
	    testAccount = new BankAccount (6.0, 1234, 20022, "MyAccount");
		if (testAccount.getBalanceString().equals("$200.22"))
		   System.out.println("getBalanceString passed with 2-digit cents");
		else
		   System.out.println("getBalanceString failed with 2-digit cents");
		testAccount.setBalance(20001);
		if (testAccount.getBalanceString().equals("$200.01"))
		   System.out.println("getBalanceString passed with 1-digit cents");
		else
		   System.out.println("getBalanceString failed with 1-digit cents");
		testAccount.setBalance(20000);
		if (testAccount.getBalanceString().equals("$200.00"))
		   System.out.println("getBalanceString passed with 0 cents");
		else
		   System.out.println("getBalanceString failed with 0 cents");
	}
	public void testGetAccountInformation()
	{
            testAccount = new BankAccount (6.0, 1234, 20022, "MyAccount");
            String studentResult = testAccount.getAccountInformation();
            int namePart1 = studentResult.indexOf("Account");
            int namePart2 = studentResult.indexOf("name", namePart1);
            int namePart3 = studentResult.indexOf("MyAccount", namePart2);

            int numPart1 = studentResult.indexOf("Account", namePart3);
            int numPart2 = studentResult.indexOf("number", numPart1);
            int numPart3 = studentResult.indexOf("1234", numPart2);

            int balPart1 = studentResult.indexOf("Balance", numPart3);
            int balPart2 = studentResult.indexOf("$200.22", balPart1);

            int ratePart1 = studentResult.indexOf("Interest", balPart2);
            int ratePart2 = studentResult.indexOf("Rate", ratePart1);
            int ratePart3 = studentResult.indexOf("6.0%", ratePart2);

            if (namePart1 < namePart2 && namePart2 < namePart3 && 
                namePart3 < numPart1 && numPart1 < numPart2 &&
                numPart2 < numPart3 && numPart3 < balPart1 &&
                balPart1 < balPart2 && balPart2 < ratePart1 &&
                ratePart1 < ratePart2 && ratePart2 < ratePart3)
            {
                System.out.println("getAccountInformation passed");
            }
	    else {
                System.out.println("It seems like your getAccountInformation method did not pass the test, but this method is a little tricky for me to auto test.");
                System.out.println("So, test it yourself and manually inspect the output.  Your output should be CLOSE to what is asked for in the assignment.");
                System.out.println("Rest assured, that this will be graded manually.");
            }
	}
}
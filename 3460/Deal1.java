import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class Deal1 {
	private Random r = new Random();
	private BufferedReader in;
	private int c = 0;
	private int hold = 0;
	private int change = 0;
	private int high = 0;
	private String[] contestants = { 
		"Ann", "Sue", "George", "Harry",
		"Ricky", "Fred", "Ethel", "Lucy" 
	};
	private int[] curtain = new int[3];
	private int[] values = new int[2];
	
	public Deal1() {
		in = new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public void run() throws IOException {
		int i;
		int n;
		System.out.println("Welcome to \"Let's Make A Deal\"!");
		sleep(1500);
		System.out.println("Are you ready to play?");
		sleep(1500);
		
		// STRATEGY 1
		System.out.println("\nSTRATEGY 1\n----------");
		generate();
		System.out.println("The first contestants are " + contestants[c] 
							   + " and " + contestants[c+1] + ".");
		sleep(1500);
		System.out.println(contestants[c] + " chooses curtain number 1.");
		values[0] = curtain[0];
		sleep(1000);
		System.out.println(contestants[c+1] + " chooses curtain number 2.");
		values[1] = curtain[1];
		sleep(1000);
		if (values[0] < values[1]) {
			System.out.println(contestants[c+1] + " has a higher value, "
							   + contestants[c] + " is eliminated.");
			i = 2;
			values[0] = values[1];
		} else {
			System.out.println(contestants[c] + " has a higher value, "
							   + contestants[c+1] + " is eliminated.");
			i=1;
		}
		sleep(1000);
		System.out.println(contestants[c] + " may choose to hold or switch curtains.");
		sleep(1000);
		System.out.println(contestants[c] + " chooses to hold curtain " + i + ".");
		sleep(1000);
		if (values[0] == high) {
			hold++;
			System.out.println(contestants[c] + " has won the grand prize of $" + high + "!");
		} else {
			System.out.println("I'm sorry " + contestants[c] + ", you chose the curtain "
							   + "with $" + values[0] + " but the grand prize was $" + high);
		}
		System.out.println("Thanks for playing!");
		sleep(1500);
		c+=2;
		
		// STRATEGY 2
		System.out.println("\nSTRATEGY 2\n----------");
		generate();
		System.out.println("The second contestants are " + contestants[c] 
						   + " and " + contestants[c+1] + ".");
		sleep(1500);
		System.out.println(contestants[c] + " chooses curtain number 1.");
		values[0] = curtain[0];
		sleep(1000);
		System.out.println(contestants[c+1] + " chooses curtain number 2.");
		values[1] = curtain[1];
		sleep(1000);
		if (values[0] < values[1]) {
			System.out.println(contestants[c+1] + " has a higher value, "
							   + contestants[c] + " is eliminated.");
			values[0] = values[1];
		} else {
			System.out.println(contestants[c] + " has a higher value, "
							   + contestants[c+1] + " is eliminated.");
		}
		sleep(1000);
		System.out.println(contestants[c] + " may choose to hold or switch curtains.");
		sleep(1000);
		System.out.println(contestants[c] + " chooses to switch to curtain 3.");
		values[0] = curtain[2];
		sleep(1000);
		if (values[0] == high) {
			change++;
			System.out.println(contestants[c] + " has won the grand prize of $" + high + "!");
		} else {
			System.out.println("I'm sorry " + contestants[c] + ", you chose the curtain "
							   + "with $" + values[0] + " but the grand prize was $" + high);
		}
		System.out.println("Thanks for playing!");
		sleep(1500);
		c+=2;
		
		// STRATEGY 3
		System.out.println("\nSTRATEGY 3\n----------");
		generate();
		System.out.println("The third contestants are " + contestants[c] 
						   + " and " + contestants[c+1] + ".");
		sleep(1500);
		i = r.nextInt(3);
		values[0] = curtain[i];
		System.out.println(contestants[c] + " chooses curtain number " + (i+1) + ".");
		sleep(1000);
		n = r.nextInt(3);
		while (i == n) {
			n = r.nextInt(3);
			values[1] = curtain[n];
		}
		System.out.println(contestants[c+1] + " chooses curtain number " + (i+1) + ".");
		sleep(1000);
		if (values[0] < values[1]) {
			System.out.println(contestants[c+1] + " has a higher value, "
							   + contestants[c] + " is eliminated.");
			values[0] = values[1];
		} else {
			System.out.println(contestants[c] + " has a higher value, "
							   + contestants[c+1] + " is eliminated.");
		}
		sleep(1000);
		System.out.println(contestants[c] + " may choose to hold or switch curtains.");
		sleep(1000);
		System.out.println(contestants[c] + " chooses to hold curtain " + (i+1) + ".");
		sleep(1000);
		if (values[0] == high) {
			hold++;
			System.out.println(contestants[c] + " has won the grand prize of $" + high + "!");
		} else {
			System.out.println("I'm sorry " + contestants[c] + ", you chose the curtain "
							   + "with $" + values[0] + " but the grand prize was $" + high);
		}
		System.out.println("Thanks for playing!");
		sleep(1500);
		c+=2;
		
		// STRATEGY 4
		System.out.println("\nSTRATEGY 4\n----------");
		generate();
		System.out.println("The fourth and final contestants are " + contestants[c] 
						   + " and " + contestants[c+1] + ".");
		sleep(1500);
		i = r.nextInt(3);
		values[0] = values[1] = curtain[i];
		System.out.println(contestants[c] + " chooses curtain number " + (i+1) + ".");
		sleep(1000);
		n = r.nextInt(3);
		while (i == n) {
			n = r.nextInt(3);
			values[1] = curtain[n];
		}
		System.out.println(contestants[c+1] + " chooses curtain number " + (n+1) + ".");
		switch (i+n) {
			case 1:
				i=2;
				break;
			case 2:
				i=1;
				break;
			case 3:
				i=0;
				break;
			default:
				System.out.println("Logic Error");
				break;
		}
		sleep(1000);
		if (values[0] < values[1]) {
			System.out.println(contestants[c+1] + " has a higher value, "
							   + contestants[c] + " is eliminated.");
			values[0] = values[1];
		} else {
			System.out.println(contestants[c] + " has a higher value, "
							   + contestants[c+1] + " is eliminated.");
		}
		sleep(1000);
		System.out.println(contestants[c] + " may choose to hold or switch curtains.");
		sleep(1000);
		System.out.println(contestants[c] + " chooses to switch to curtain " + (i+1) + ".");
		values[0] = curtain[i];
		sleep(1000);
		if (values[0] == high) {
			change++;
			System.out.println(contestants[c] + " has won the grand prize of $" + high + "!");
		} else {
			System.out.println("I'm sorry " + contestants[c] + ", you chose the curtain "
							   + "with $" + values[0] + " but the grand prize was $" + high);
		}
		System.out.println("Thanks for playing!");
		System.out.println("Goodbye!\n");
		System.out.println("Results: ");
		System.out.println("Held and won: " + hold);
		System.out.println("Switched and won: " + change);
		System.exit(0);

	}
	
	public void generate(){
		int s;
		for (int i=0; i<3; i++) {
			s = r.nextInt(1500);
			curtain[i] = s;
			while (curtain[(i+1)%3] == s && curtain[(i+2)%3] == s) {
				s = r.nextInt(1500);
				curtain[i] = s;
			}
			if (s > high) {
				high = s;
			}
		}
	}
	
	public void	sleep(int i){
		try	{	
			Thread.sleep(i);
		}	catch (InterruptedException ie)	{
			System.out.println(ie.getMessage());
		}
	}
	
	public static void main(String[] args){
		try {
			Deal1 deal = new Deal1();
			deal.run();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}


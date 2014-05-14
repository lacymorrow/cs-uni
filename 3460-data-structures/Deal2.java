import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class Deal2 {
	private final static int LOOP_NUM = 1000;
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
	
	public Deal2() {
		in = new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public void run() throws IOException {
		int i;
		int n;
		int a;
		
		// STRATEGY 1
		for (a=0; a<LOOP_NUM; a++) {
			generate();
			values[0] = curtain[0];
			values[1] = curtain[1];
			if (values[0] < values[1]) {
				values[0] = values[1];
			}
			if (values[0] == high) {
				hold++;
			}
		}
			System.out.println("Strategy 1 - Fixed/Hold: " + hold + " wins.");
			hold = 0;
			
		// STRATEGY 2
		for (a=0; a<LOOP_NUM; a++) {
			generate();
			values[0] = curtain[0];
			values[1] = curtain[1];
			if (values[0] < values[1]) {
				values[0] = values[1];
			}
			values[0] = curtain[2];
			if (values[0] == high) {
				change++;
			}
		}
			System.out.println("Strategy 2 - Fixed/Switch: " + change + " wins.");
			change = 0;
			
		// STRATEGY 3
		for (a=0; a<LOOP_NUM; a++) {
			generate();
			i = r.nextInt(3);
			values[0] = curtain[i];
			n = r.nextInt(3);
			while (i == n) {
				n = r.nextInt(3);
				values[1] = curtain[n];
			}
			if (values[0] < values[1]) {
				values[0] = values[1];
			}
			if (values[0] == high) {
				hold++;
			}
		}
			System.out.println("Strategy 3 - Random/Hold: " + hold + " wins.");
			hold = 0;
			
		// STRATEGY 4
		for (a=0; a<LOOP_NUM; a++) {
			generate();
			i = r.nextInt(3);
			values[0] = values[1] = curtain[i];
			n = r.nextInt(3);
			while (i == n) {
				n = r.nextInt(3);
				values[1] = curtain[n];
			}
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
			if (values[0] < values[1]) {
				values[0] = values[1];
			}
			values[0] = curtain[i];
			if (values[0] == high) {
				change++;
			}
		}
		System.out.println("Strategy 4 - Random/Switch: " + change + " wins.");
		change = 0;
		
		System.out.println("Thanks for playing!");
		System.out.println("Goodbye!\n");
		System.exit(0);

	}
	
	public void generate(){
		int s;
		for (int i=0; i<3; i++) {
			s = r.nextInt(1000);
			curtain[i] = s;
			while (curtain[(i+1)%3] == s && curtain[(i+2)%3] == s) {
				s = r.nextInt(1000);
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
			Deal2 deal = new Deal2();
			deal.run();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}


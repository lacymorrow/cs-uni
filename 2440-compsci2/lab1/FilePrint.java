import java.util.Scanner; 
public class FilePrint {
	/**
	 * A simple program that reads from "standard in"
	 * and copies line by line to the display.
	 * @param args 
	 */ 
	public static void main(String[] args) {
		// Create Scanner with System.in 
		Scanner in = new Scanner(System.in); 
		//While there are more lines, print them... 
		while(in.hasNextLine()){ 
			System.out.println(in.nextLine()); 
		} 
	} // end method 
} // end class

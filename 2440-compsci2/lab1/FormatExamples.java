public class FormatExamples {

	/**
	 * This program expects 4 arguments at the command line:
	 * First argument: a whole number
	 * Second argument: a decimal number
	 * Third argument: a larger decimal number
	 * Fourth argument: a word
	 * Fifth argument: either the word 'true' or the word 'false'
	 * 
     * 
	 * @param args
	 */
	public static void main(String[] args) {

		int j = Integer.parseInt(args[0]);      // a static method for extracting an 'int' from a String
		double x = Double.parseDouble(args[1]); // extract a 'double' from a String 
		double y = Double.parseDouble(args[2]); 
		String word = args[3];                         // copy input to local String variable
		boolean yesNo = Boolean.parseBoolean(args[4]); // extract 'boolean' from a String

		
		// Print the word. '\n' is a linefeed character
		// which is interpreted literally and causes
		// output to advance to next line on the screen.
		// Necessary when using format() if you want the
		// output to continue onto the next line.
		System.out.format("%s\n",word);
		
		//Calculate a value and 
		//format result depending on boolean value read
		if(yesNo){
			double z = (x + y) * j;
			// Field width is 8, 2 places after decimal
			// 'f' indicates floating point output
			// used for java types double and float
			System.out.format("%8.2f\n", z);
		}
		else {
			// Note that although the expression is of
			// type double, the 'd' format specifier will
			// produce integer output (base 10)--no decimal
			// point.
			System.out.format("%d\n", (x+y)* j);
		}
		// The following produces the same as
		// System.out.println("done!");
		System.out.format("done!\n");
	}
	
}



/*
 * Sleep Deprivation Experiment
 * Lacy Morrow
 * 2-22-2011
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Prog4 {
	private final static int[][] STATE_TABLE = {
		{ 1, 2, 3, 4 },
		{ 1, 3, 2, 4 },
		{ 3, 2, 1, 4 },
		{ 2, 1, 3, 4 },
		{ 4, 4, 4, 4 }
	
	};
	
	private BufferedReader in;

	public Prog4() {
		in = new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public void run() throws IOException {
		char ch;
		int state;

		for(;;) {
			System.out.print("Enter your string:  ");
			ch = (char) in.read();
			state = 0;

			while (ch != '\n') {
				state = 
STATE_TABLE[state][charToColumn(ch)];
				ch = (char) in.read();
			}
			if (state == 1) {
				System.out.println("Result: 1\n");				
			} else if (state == 2) {
				System.out.println("Result: 4\n");				
			} else if (state == 3) {
				System.out.println("Result: 9\n");				
			} else {
				System.out.println("Error\n");
			}
		}
	}

	public int charToColumn(char ch) {
		int column = 3;
		switch(ch) {
			case '1':
				column = 0;
				break;
			case '4':
				column = 1;
				break;
			case '9':
				column = 2;
				break;
		}
		return column;
	}

	public static void main(String[] args){
		try {
			Prog4 fsm = new Prog4();
			fsm.run();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}


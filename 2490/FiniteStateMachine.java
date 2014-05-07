import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine {
	private final static int[][] STATE_TABLE = {
		{ 1, 10, 14 },
		{ 1,  2, 14 },
		{ 6,  3, 14 },
		{ 4, 12, 14 },
		{ 1,  5, 14 },
		{ 6,  3, 14 },
		{ 7,  2, 14 },
		{ 1,  8, 14 },
		{ 6,  9, 14 },
		{ 4, 12, 14 },
		{ 1, 11, 14 },
		{ 1, 12, 14 },
		{ 13,12, 14 },
		{ 1,  2, 14 }
	};
	
	private BufferedReader in;

	public FiniteStateMachine() {
		in = new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public void run() throws IOException {
		char ch;
		int state;
		boolean accept = false;
		for(;;) {
			System.out.print("Enter your string:  ");
			ch = (char) in.read();
			state = 0;

			while (ch != '\n') {
				if (state == 5 || state == 9 || state == 13) {
					accept = true;
				}
				state = 
STATE_TABLE[state][charToColumn(ch)];
				ch = (char) in.read();
			}
			if (accept == true) {
				System.out.println("Accept\n");
			} else {
				System.out.println("Reject\n");
			}
		}
	}

	public int charToColumn(char ch) {
		int column = 2;
		switch(ch) {
			case 'a':
				column = 0;
				break;
			case 'b':
				column = 1;
				break;
		}
		return column;
	}

	public static void main(String[] args){
		try {
			FiniteStateMachine fsm = new 
FiniteStateMachine();
			fsm.run();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}


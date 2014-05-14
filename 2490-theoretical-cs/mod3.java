import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class mod3 {
	private final static int[][] STATE_TABLE = {
		{ 1, 2, 3 },
		{ 2, 0, 3 },
		{ 0, 1, 3 }
	};
	
	private BufferedReader in;

	public mod3() {
		in = new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public void run() throws IOException {
		char ch;
		int state;
		boolean accept;
		for(;;) {
			accept = false;
			System.out.print("Enter your string:  ");
			ch = (char) in.read();
			state = 0;

			while (ch != '\n') {
				state = 
STATE_TABLE[state][charToColumn(ch)];
				ch = (char) in.read();
			}
			if (state == 0) {
				accept = true;
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
			mod3 fsm = new mod3();
			fsm.run();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}


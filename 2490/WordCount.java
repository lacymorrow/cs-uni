// Finite State Machine
// Counts occurrences of tablet, leaden, delta, node and not
// Andy Dalton and Dee Parks, 9/29/06

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WordCount {

    // State Table
    private final static int [][] STATE_TABLE =
    {
        // a,  t,  i,  c,  e,  m,  h,  other
        { 1, 16,  0,  0,  6,  12,  0,  0,},  // State 0
        { 1,  2,  0,  0,  6,  12,  0,  0,},  // State 1a
        { 1,  3,  0,  0,  6,  12, 17,  0,},  // State 2t
        { 1, 16,  4,  0,  6,  12, 17,  0,},  // State 3t
        { 1, 16,  0,  5,  6,  12,  0,  0,},  // State 4i
        { 1, 16,  0,  0,  6,  12,  0,  0,},  // State 5c*
		{ 1, 16,  0,  0,  6,   7,  0,  0,},  // State 6e
        {13, 16,  0,  0,  8,  12,  0,  0,},  // State 7m
        { 1,  9,  0,  0,  6,  12,  0,  0,},  // State 8e
        { 1, 16, 10,  0,  6,  12, 17,  0,},  // State 9t
        { 1, 16,  0, 11,  6,  12,  0,  0,},  // State 10i
        { 1, 16,  0,  0,  6,  12,  0,  0,},  // State 11c*
        {13, 16,  0,  0,  6,  12,  0,  0,},  // State 12m
        { 1, 14,  0,  0,  6,  12,  0,  0,},  // State 13a
        { 1,  3,  0,  0,  6,  12, 15,  0,},  // State 14t
        { 1, 16,  0,  0, 18,  12,  0,  0,},  // State 15h*
        { 1, 16,  0,  0,  6,  12, 17,  0,},  // State 16t
        { 1, 16,  0,  0, 18,  12,  0,  0,},  // State 17h
        { 1, 16,  0,  0,  6,  19,  0,  0,},  // State 18e
        { 1, 16,  0,  0, 20,  12,  0,  0,},  // State 19m
        { 1,  9,  0,  0,  9,   7,  0,  0,},  // State 20e*
    };

    // Table constants
    private final static int a_COLUMN   = 0;
    private final static int t_COLUMN   = 1;
    private final static int i_COLUMN   = 2;
    private final static int c_COLUMN   = 3;
    private final static int e_COLUMN   = 4;
    private final static int m_COLUMN   = 5;
    private final static int h_COLUMN   = 6;
    private final static int ERR_COLUMN = 7;

    // Special states
    private final static int START = 0;
    private final static int attic_ACCEPT = 5;
    private final static int emetic_ACCEPT = 11;
    private final static int math_ACCEPT = 15;
    private final static int theme_ACCEPT = 20;



    private BufferedReader in;


    public WordCount() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        int input;
        int state;
        int atticCount = 0;
        int emeticCount = 0;
        int mathCount = 0;
        int themeCount = 0;


        input = in.read();
        state = START;
            
        while (input != -1) {
           char ch = (char) input;
           state = STATE_TABLE[state][charToColumn(ch)];
           input = in.read();
           if( state == attic_ACCEPT)
               atticCount++;
           else if( state == emetic_ACCEPT)
               emeticCount++;
           else if( state == math_ACCEPT)
               mathCount++;
           else if( state == theme_ACCEPT)
               themeCount++;
        }

        // display counts
        System.out.println("Occurrence counts:");
        System.out.println("attic: " + atticCount);
        System.out.println("emetic: "  + emeticCount);
        System.out.println("math: " + mathCount);
        System.out.println("theme: " + themeCount);
    }


    public int charToColumn(char ch) {
        int column = ERR_COLUMN;

        switch( ch ) {
        case 'a':
            column = a_COLUMN;
            break;
        case 't':
            column = t_COLUMN;
            break;
        case 'i':
            column = i_COLUMN;
            break;
        case 'c':
            column = c_COLUMN;
            break;
        case 'e':
            column = e_COLUMN;
            break;
        case 'm':
            column = m_COLUMN;
            break;
        case 'h':
            column = h_COLUMN;
				break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            WordCount fsm = new WordCount();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}


/**
 * This class implements a demo interpreter.
 * It is the top level class in this project.
 * The Interpreter communicates via text input/output
 * in the text terminal.
 * 
 * This class uses an object of class InputReader to read input
 * from the user, and an object of class Interpreter to generate responses.
 * It contains a loop that repeatedly reads input and generates
 * output until the users wants to leave.
 * 
 * @author     Lacy Morrow
 * @version    1.0
 */
public class DemoInterpreter
{
    private InputReader reader;
    private Interpreter responder;
    
    /**
     * Creates a technical support system.
     */
    public DemoInterpreter()
    {
        reader = new InputReader();
        responder = new Interpreter();
    }

    /**
     * Start the technical support system. This will print a welcome message and enter
     * into a dialog with the user, until the user ends the dialog.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            String[] input = reader.getInput();
            if(input[0].equals("bye")) {
                System.out.println(responder.interpret(input));
                finished = true;
            }
            else {
                System.out.println(responder.interpret(input));
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("Microsoft Super (virtual) Txt Message Decoder");
        System.out.println();
        System.out.println("Our best product since MS-DOS");
        System.out.println("Enter any cryptic txt to decode.");
        System.out.println("Please type 'bye' to exit the system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Thanks for using the system. Powering off...");
    }
}

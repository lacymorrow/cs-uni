import java.util.HashSet;

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
            HashSet<String> input = reader.getInput();

            if(input.contains("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Nice talking to you. Bye...");
    }
}

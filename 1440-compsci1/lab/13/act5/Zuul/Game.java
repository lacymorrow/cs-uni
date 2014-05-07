/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Lacy Morrow
 * @version 1.0
 */


public class Game 
{
    private Player player;
    private Castle castle;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player();
        castle = new LacyCastle();
    }

    public void setCastle(Castle castle) {
        this.castle = castle;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean gameOver = false;
        while (! gameOver) {
            Command command = Command.getCommand();
            gameOver = command.perform(player, castle);
            if (player.isDead())
               gameOver = true;
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to the Medieval World of Zuul!");
        System.out.println("Medieval World of Zuul is a new, moderately exciting, text-based adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(castle.getCurrentRoom().getLongDescription());
    }

}

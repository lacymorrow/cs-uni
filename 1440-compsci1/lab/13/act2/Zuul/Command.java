/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Command
{
    // a constant array that holds all valid command words
    // last one should not have a comma after it!
    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    public static Command getCommand() 
    {
        String inputLine = "";   // will hold the full input line
        String word1;
        String word2;

        System.out.print("> ");     // print prompt

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        if(Command.isCommand(word1))
            return new Command(word1, word2);
        else
            return new Command(null, word2);
    }

    /**
     * Check whether a given String is a valid command word. 
     * Return true if it is, false if it isn't.
     */
    private static boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /*
     * Print all valid commands to System.out.
     */
    public static void showCommands() 
    {
        for(int i = 0; i < validCommands.length; i++) {
            System.out.print(validCommands[i] + "  ");
        }
        System.out.println();
    }

    private String commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return true if this command was not understood.
     */
    private boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * Return true if the command has a second word.
     */
    private boolean hasSecondWord()
    {
        return (secondWord != null);
    }

    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public boolean perform(Player player, Castle castle) 
    {
        if(this.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord.equals("help"))
            printHelp(player, castle);
        else if (commandWord.equals("quit"))
            return true;
        else if (commandWord.equals("go")) 
            goRoom(player, castle);
        
        return false;
    }
    
    

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp(Player player, Castle castle) 
    {
        System.out.println("You are lost. You are alone. You wander around the castle.");
        System.out.println();
        System.out.println("Your command words are:");
        Command.showCommands();
        System.out.println(player.livesLeft());
        System.out.println(castle.getCurrentRoom().getLongDescription());
    }



    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Player player, Castle castle) 
    {
        if(! this.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = secondWord;

        // Try to leave current room.
        Room nextRoom = castle.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("Ouch! There is no door "+direction+", you lose a life.");
            player.loseLife();
        }
        else {
            System.out.println(nextRoom.getLongDescription());
            castle.setCurrentRoom(nextRoom);
        }
    }
}


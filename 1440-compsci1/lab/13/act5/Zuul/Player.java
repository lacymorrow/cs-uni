
/**
 * Creates an instance of a player with a set amount of lives
 */
public class Player
{
    public final int maxLives;
    private int lives;

    /**
     * Constructor for objects of class Player
     */
    public Player(int lives)
    {
        maxLives = lives;
        this.lives = maxLives;
    }
    public Player() {
        maxLives = 3;
        this.lives = maxLives;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean isDead() {
        return (lives == 0);
    }
    public void addLife() { 
        addLife(1); 
    }
    public void addLife(int numLives) { 
        lives += numLives;
        lives = Math.min(lives, maxLives);
    }
    public void loseLife() {
        if (lives > 0) lives--;
    }
    public String livesLeft() { 
        String returnString = "You have " + lives;
        if (lives == 1) returnString += " life left.";
        else            returnString += " lives left.";
        return returnString; 
    }
}

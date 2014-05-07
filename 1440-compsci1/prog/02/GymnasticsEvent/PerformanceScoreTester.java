import java.util.Random;

/**
 * PerformanceScoreTester: students can use this to help them
 *         test their PerformanceScore class.  This creates
 *         a PerformanceScore object that is made up of
 *         several Scores, generated randomly. The parameter is
 *         the number of scores.
 * 
 * @author:  Alice McRae
 * @version 1:  March 22, 2009
 */

public class PerformanceScoreTester
{
    private static final String [] namePart1 = {"John", "Philip", "Greg",
        "Jack", "Harold", "Mathe", "Ander", "Michael", "Chan", "Burke",
        "Land", "Mack", "Neil", "Rice", "Kran", "Lee", "Sim", "Frie", 
        "Martin", "Logan", "Frank", "King", "Burger", "Turner", "Madi"};
        
    private static final String [] namePart2 = {"", "s", "son", "burg", "man"};
    Random rand;
    PerformanceScore scores;
 
    /**
     * Constructor for objects of class PerformanceScore.
     * @param numberOfScores The number of Scores to make up
     *            the PerformanceScore.  
     *            
     *   This uses your constructor, your addScore(), getScores(),
     *   technicalMeritRating(), and artisticMeritRating()
     *   methods.
     */
    
    public PerformanceScoreTester(int numberOfScores)
    {
       rand = new Random();
       scores = new PerformanceScore();
       makePerformanceScore(numberOfScores);
       checkRatings();
    }

    // 
    private void makePerformanceScore(int numberOfScores)
    {
         String name;
         double score1;
         for (int i = 0; i < numberOfScores; i++) {
             name = makeName();
             scores.addScore('t', makeRating(), name);
             scores.addScore('a', makeRating(), name);
         }
    }
     
    // prints out the results from your methods
    private void checkRatings()
    {
       System.out.println (scores.getScores());
       System.out.println ("Technical: " + scores.technicalMeritRating());
       System.out.println ("Artistic: " + scores.artisticMeritRating());
    }
    
    // makes up a random rating, perhaps with one digit after decimal
    // point.  round-off error could defeat that part.
    private double makeRating()
    {
        return (rand.nextInt(71) + 30) / 10.0;
      
    }
    
    // makes up a random name
    private String makeName()
    {
       return namePart1[rand.nextInt(namePart1.length)] + 
              namePart2[rand.nextInt(namePart2.length)] + "," + 
              (char)(rand.nextInt(26) + 'A');
    }
}
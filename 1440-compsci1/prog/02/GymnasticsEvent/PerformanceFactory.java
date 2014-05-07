/**
 * PerformanceFactory: students can use this to help them
 *         create multiple performances.  Create a new Performance
 *         Factory and call the makePerformance method.  Use the 'get'
 *         option that will place the returned Performance on the
 *         object bar.  The PerformanceFactory uses your Performance
 *         class to construct the Performance.  You can test your methods
 *         on the Performance.  This makePerformance() method may be
 *         called several times to get multiple Performances to feed
 *         to an Event object later on.  
 * 
 * @author:  
 * @version 1:  March 22, 2009
 */

import java.util.Random;

public class PerformanceFactory
{
    // instance variables - replace the example below with your own
    private static final String [] COUNTRY = {"Spain", "Great Brittain",
        "United States", "Canada", "Cuba", "Russia", "Italy", "China",
        "Peru", "Paraguay", "Brazil", "Greece", "France", "Sweden",
        "Finland", "Scotland", "Switzerland", "Portugal", "India",
        "Thailand", "Australia", "Iceland", "Chile", "South Africa",
        "Nepal", "Togo", "Guinnea", "Egypt", "Saudi Arabia", "Israel",
        "Tanzania", "Turkey", "Kuwait", "Austria", "Norway", "Chile",
        "Korea", "Japan", "Honduras", "Mexico", "Bolivia", "Botswana"};
        
    private static final String [] JUDGE = {"Adams", "Andrews", "Arnette",
        "Baker", "Burns", "Bolivar", "Bronson", "Chen", "Corson",
        "Cranston", "Davis", "Dolores", "Dru", "Elia", "Emerson",
        "Ecles", "Fargo", "Friendly", "Fidel", "Gregorio", "Guzman",
        "Galileo", "Hanson", "Hugo", "Hu", "Iglesias", "Inman", "Io",
        "Janson", "Jue", "Jacks", "Knox", "Kao", "Kung", "Lin", "Lawson",
        "Leroy", "Marx", "Madison", "Morse", "Nano", "Newton", "Nero",
        "Ollson", "O'Malley", "Oro", "Philips", "Pio", "Ptolomy", 
        "Qin", "Quito", "Quick", "Rio", "Ruiz", "Ran", "Stephens", 
        "Surry", "Suez", "Tito", "Turner", "Tau", "Uz", "Ulam", "Ullman",
        "Veracruz", "Vaca", "Vance", "Williams", "Warner", "Wagner", "Xu",
        "Xing", "Xau", "Yang", "Yin", "Young", "Zito", "Zorro", "Ziegler"};
     
     private static final String [] CONTESTANT = {"Arthur", "Abrams", "Alma",
         "Bianca", "Bavia", "Brahms", "Canto", "Carlos", "Coleman",
         "Devorca", "Danzon", "Devi", "Edison", "Emma", "Elroy",
         "Fidelio", "Franco", "Fernando", "Grange", "Gnome", "Gray",
         "Harmon", "Halle", "Hung", "Iago", "Inez", "Irving", "Jazz",
         "Julio", "Johnson", "Klay", "Korey", "Kingman", "Laskar",
         "Lazlo", "Lawrence", "Margo", "Mia", "Museo", "Nils", "Norman",
         "Nyles", "Opal", "Ormon", "Ottoman", "Perry", "Rodrigues", 
         "Swanson", "Tyson", "Underwood"};
         
     private Random rand;

    /**
     * Constructor for objects of class PerformanceFactory
     */
    public PerformanceFactory()
    {
        rand = new Random();
    }

    /**
     * makePerformance - creates a random Performance with between 4 and
     *               10 ratings each
     * 
     * @param   - no parameters   
     * @return  - the random Performance
     */
    public Performance makePerformance()
    {       
        Performance p = new Performance(new Competitor
                         (CONTESTANT[rand.nextInt(CONTESTANT.length)],
                          COUNTRY[rand.nextInt(COUNTRY.length)]));
        String judge;
        int numScores = rand.nextInt(6) + 4;
        for (int i = 0; i < numScores; i++) {
            judge = JUDGE[rand.nextInt(JUDGE.length)];
            p.addScore('t', makeRating(), judge);
            p.addScore('a', makeRating(), judge);
        }
        return p;
     } 
     
     
    /**
     * 
     * makeRating - creates a double value between 7.0 and 10.0
     *              that likely has one digit after the decimal point
     * 
     * @param   - no parameters   
     * @return  - the random double that is chosen
     */
    private double makeRating()
    {
        return (rand.nextInt(71) + 30) / 10.0;
    }
}

/**
 * Creates Performance with competitor and performance rating
 */
public class Performance
{
    private PerformanceScore scores;
    private Competitor competitor;

    /**
     * Constructor for objects of class Performance
     */
    public Performance(Competitor competitor)
    {
        this.competitor = competitor;
        scores = new PerformanceScore();
    }

    public Competitor getCompetitor()
    {
        return competitor;
    }
    
    public void listScores(){
        System.out.println(scores.getScores());
    }
    
    public void addScore(char scoreType, double score, String judgeName){
        scores.addScore(scoreType, score, judgeName);
    }
    
    public double performanceRating(){
        return (scores.technicalMeritRating() + scores.artisticMeritRating())/2;
    }
}

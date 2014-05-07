/**
 * A single Score object
 */
public class Score
{
    private double rating;
    private String judgeName;

    /**
     * Constructor for objects of class Score
     */
    public Score(double rating, String judgeName)
    {
        this.rating = rating;
        this.judgeName = judgeName;
    }

    public double getRating()
    {
        return rating;
    }
    
    public String getJudgeName()
    {
        return judgeName;
    }
    
    public void setRating(double rate)
    {
        if (rate >=0 && rate <= 10)
            rating = rate;
    }
    
    public void setJudgeName(String jName)
    {
        judgeName = jName;
    }
}

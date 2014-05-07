import java.util.ArrayList;
/**
 * Averages technical and artistic scores
 */
public class PerformanceScore
{
    private ArrayList<Score> technicalMerit;
    private ArrayList<Score> artisticMerit;
    
    /**
     * Constructor for objects of class PerformanceScore
     */
    public PerformanceScore()
    {
        technicalMerit = new ArrayList<Score>();
        artisticMerit = new ArrayList<Score>();
    }

    public void addScore(char scoreType, double score, String judgeName)
    {
        if(scoreType == 't'){
            technicalMerit.add(new Score(score, judgeName));
        } else if(scoreType == 'a'){
            artisticMerit.add(new Score(score, judgeName));
        }
    }
    
    public String getScores(){
        String scoreStr = "Technical Scores\n";
        for (Score tScore : technicalMerit){
            scoreStr += tScore.getJudgeName()+": "+tScore.getRating()+"\n";
        }
        scoreStr += "\nArtistic Scores\n";
        for (Score aScore : artisticMerit){
            scoreStr += aScore.getJudgeName()+": "+aScore.getRating()+"\n";
        }
        return scoreStr;
    }
    
    private double maxRating(ArrayList<Score> list){
        double max = 0;
        for (Score score : list){
            if(score.getRating()>max)
                max = score.getRating();
        }
        return max;
    }
    
    private double minRating(ArrayList<Score> list){
        double min = 10.0;
        for (Score score : list){
            if(score.getRating()<min)
                min = score.getRating();
        }
        return min;
    }
    
    public double technicalMeritRating(){
        double avg = 0;
        int count = 0;
        for (Score score : technicalMerit){
            if(score.getRating() != minRating(technicalMerit) && score.getRating() != maxRating(technicalMerit)){
                avg += score.getRating();
                count++;
            }
        }
        return avg/count;
    }
    
    public double artisticMeritRating(){
        double avg = 0;
        int count = 0;
        for (Score score : artisticMerit){
            if(score.getRating() != minRating(artisticMerit) && score.getRating() != maxRating(artisticMerit)){
                avg += score.getRating();
                count++;
            }
        }
        return avg/count;
    }
    
    public void printScores(){
        System.out.print(getScores());
    }
}

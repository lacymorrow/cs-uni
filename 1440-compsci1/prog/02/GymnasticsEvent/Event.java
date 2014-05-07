import java.util.ArrayList;
/**
 * Creates an event with n number of performances.
 * 
 * @author Lacy Morrow
 * @version 1.0
 */
public class Event
{
    private ArrayList<Performance> performances;
    private String eventName;

    /**
     * Constructor for objects of class Event
     */
    public Event(String name)
    {
        eventName = name;
        performances = new ArrayList<Performance>();
    }

    public void addPerformance(Performance performance)
    {
        performances.add(performance);
    }
    
    public void printSummary(){
        /**
         * prints each competitor's name with his country and 
         * his/her performance rating
         */
        System.out.println("Event: "+eventName+"\n------------------------");
        for(Performance item : performances){
            System.out.println("Competitor: "+item.getCompetitor().getCompetitorName() + ",  "+item.getCompetitor().getCountry()+"\nPerformance Rating: "+item.performanceRating()+"\n");
        }
    }
    
    public String winner(){
        /**
         * 
         * public winner returns a string containing the performanceRating, the name of the winner, and the country of the winner in the following format
         * Winner: name, country. Score: score
         */
        Performance max = performances.get(0);
        for(Performance item : performances){
            max = (item.performanceRating() > max.performanceRating())?item : max;
        }
        return "Winner: "+max.getCompetitor().getCompetitorName()+", "+max.getCompetitor().getCountry()+". Score: "+max.performanceRating();
    }
}

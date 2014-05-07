/**
 * EventTester: creates a random event.  Students should
 * use this class after they have finished writing all of the
 * Event class.  Call the constructor and give it the name of
 * the event, and the number of performances you desire.
 * @author Alice McRae 
 * @version: Version 1: November 17, 2009
 */

public class EventTester
{
    private Event event;
    private PerformanceFactory pf;

    /**
     * Constructor for objects of class EventTester
     * @param nameOfEvent : the event name (e.g. "Pole Vault")
     * @param numPerformances : the number of performances in this event
     *              
     *            
     *   This uses your constructor, your addScore(), getScores(),
     *   technicalMeritRating(), and artisticMeritRating()
     *   methods.
     */
    
    public EventTester(String nameOfEvent, int numPerformances)
    {
        // initialise instance variables
        event = new Event(nameOfEvent);
        pf = new PerformanceFactory();
        for (int i = 0; i < numPerformances; i++) {
            event.addPerformance(pf.makePerformance());
        }
        event.printSummary();
        System.out.println (event.winner());
        
    }

}
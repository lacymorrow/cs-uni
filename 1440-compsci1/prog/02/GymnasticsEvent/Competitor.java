
/**
 * A competitor with associated country
 */
public class Competitor
{
    private String competitorName;
    private String country;

    /**
     * Constructor for objects of class Competitor
     */
    public Competitor(String competitor, String country)
    {
        competitorName = competitor;
        this.country = country;
    }

    public String getCompetitorName()
    {
        return competitorName;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public void setCompetitorName(String competitor)
    {
        competitorName = competitor;
    }
    
    public void setCountry(String countryName)
    {
        country = countryName;
    }
}

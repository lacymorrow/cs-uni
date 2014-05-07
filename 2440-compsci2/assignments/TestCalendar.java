import java.util.Calendar;
import java.util.GregorianCalendar;
public class TestCalendar{
	public static void main(String args[]){
		GregorianCalendar cal = new GregorianCalendar();
		GregorianCalendar bday = new GregorianCalendar(1990,Calendar.SEPTEMBER,10);
		cal.add(Calendar.DAY_OF_MONTH,100);
		System.out.println("Date 100 days from today:\n"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR));
		System.out.println("Weekday: "+cal.get(Calendar.DAY_OF_WEEK)+"\n");
		System.out.println("Birthday: "+bday.get(Calendar.DAY_OF_WEEK));
		bday.add(Calendar.DAY_OF_MONTH,10000);
		System.out.println("Date 10000 days from birthday:\n"+bday.get(Calendar.MONTH)+"/"+bday.get(Calendar.DAY_OF_MONTH)+"/"+bday.get(Calendar.YEAR));
	}
}

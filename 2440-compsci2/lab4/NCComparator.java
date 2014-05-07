import java.util.Comparator;

public class NCComparator implements Comparator<YearData> {
   public int compare(YearData y1, YearData y2) {
      if (y1.getNetChange() < y2.getNetChange())
         return -1;
      else if (y1.getNetChange() > y2.getNetChange())
         return 1;
      else
         return 0;
   }
}

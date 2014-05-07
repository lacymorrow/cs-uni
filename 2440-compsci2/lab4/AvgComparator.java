import java.util.Comparator;

public class AvgComparator implements Comparator<YearData> {
   public int compare(YearData y1, YearData y2) {
      if (y1.getAverage() < y2.getAverage())
         return -1;
      else if (y1.getAverage() > y2.getAverage())
         return 1;
      else
         return 0;
   }
}

import java.util.Comparator;

public class AreaComparator implements Comparator<State> {
   public int compare(State y1, State y2) {
      if (y1.getArea() < y2.getArea())
         return 1;
      else if (y1.getArea() > y2.getArea())
         return -1;
      else
         return 0;
   }
}

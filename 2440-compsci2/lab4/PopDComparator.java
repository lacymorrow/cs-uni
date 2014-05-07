import java.util.Comparator;

public class PopDComparator implements Comparator<State> {
   public int compare(State y1, State y2) {
      if (y1.getPD() < y2.getPD())
         return 1;
      else if (y1.getPD() > y2.getPD())
         return -1;
      else
         return 0;
   }
}

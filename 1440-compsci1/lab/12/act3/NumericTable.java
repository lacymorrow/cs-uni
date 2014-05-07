/**
 * NumericTable
 * Creates multiple Line instances to generate a table of numbers
 *
 * @author Lacy Morrow
 * @version 1.0
 */
public class NumericTable{
    public static void main(String[] args){
        for(int i=0;i<=10;i++){
            Line line = new Line(i);
            System.out.println(line.getString());
        }
    }
}

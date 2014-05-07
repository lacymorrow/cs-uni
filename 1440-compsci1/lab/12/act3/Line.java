/**
 * Class Line
 * Generates a string of four numbers with 
 * proper spacing for n, n^2, n^3, n mod 3
 *
 * @author Lacy Morrow
 * @version 1.0
 */
public class Line{
    private String text;
    /**
     * Line
     * @param A single integer with which to generate string values
     */
    public Line(int num){
        text = ""+paddedField(num,2)+"  "+paddedField((int)Math.pow(num,2),3)+"  "+paddedField((int)Math.pow(num,3),4)+"  "+paddedField((num % 3),1);
    }
    /**
     * getString()
     * Accessor method which returns formatted string
     * @returns String properly formatted
     */
    public String getString(){
        return text;
    }
    private static String paddedField(int n, int width){
        String hold = ""+n;
        int a = hold.length();
        for(int i=0;i<width-a;i++){
            hold = " "+hold;
        }
        return hold;
    }
}

public class Calc{
	public static void main(String[] args){
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		System.out.format("%-10.3f\n",x+y);
		System.out.format("%-10.3f\n",x-y);
		System.out.format("%-10.3f\n",x*y);
		System.out.format("%-10.3f\n",x/y);
	}
}

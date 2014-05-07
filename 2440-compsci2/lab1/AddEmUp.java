import java.util.Scanner;
public class AddEmUp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		double sum = 0;
		while(in.hasNextDouble()){ 
			sum += in.nextDouble(); 
		}
		System.out.format("Sum: %-10.2f\n",sum); 
	}
}

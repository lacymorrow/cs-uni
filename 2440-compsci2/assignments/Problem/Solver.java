import java.util.Scanner;


public class Solver {
	public static void main(String[] args){
		double num1;
		double num2;
		String op;
		System.out.println("Enter an expression separated by spaces:");
		Scanner input = new Scanner(System.in);
		num1 = Double.parseDouble(input.next());
		op = input.next();
		num2 = Double.parseDouble(input.next());
		if(op.equals("*")){
			System.out.println(String.valueOf(num1 * num2));
		} else if(op.equals("x")){
			System.out.println(String.valueOf(num1 * num2));
		} else if(op.equals("/")){
			System.out.println(String.valueOf(num1 / num2));
		} else if(op.equals("+")){
			System.out.println(String.valueOf(num1 + num2));
		} else if(op.equals("-")){
			System.out.println(String.valueOf(num1 - num2));
		} else {
			System.out.println("Illegal Expression.");
		} 
	}
}


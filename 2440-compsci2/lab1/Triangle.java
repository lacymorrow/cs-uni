import java.util.Scanner;
public class Triangle{
        public static void main(String[] args){
		getInput();
        }
	public static void getInput(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number (or 'quit'): ");
		if(input.hasNextInt()){
			printTri(input.nextInt());
		} else {
			String text = input.next();
			if(text.equals("quit")){
				System.exit(0);
			} else {
				System.out.println("Incorrect value.");
				getInput();
			}
		}
	}
	public static void printTri(int x){
		//prints triangle
		for (int a=x;a>0;a--){
			for (int b=0;b<a;b++){
				System.out.print("*");
			}
			System.out.println();
		}
		getInput();
       }
}


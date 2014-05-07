import java.io.File;
import javax.swing.*;
import java.util.Scanner;
public class ClassScheduleFilter{
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser(); 
		File file = fc.getSelectedFile();
		Scanner in = new Scanner(file.getName());
		while(in.hasNextLine()){
			System.out.println(in.nextLine());
		}		
		 
	}
}

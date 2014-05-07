import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * USPopulationViews
 * 
 * @author Thomas Lacy Morrow
 * @version 2.11.2010
 *
 */
public class UnemploymentViews {
	static ArrayList<YearData> data = new ArrayList<YearData>();
	public static void main(String[] args){
		try {
			Scanner in = new Scanner(new File("UnemploymentRates.csv"));
			in.useDelimiter("[ ,\t\n]+");
			while(in.hasNext()){
				if(in.hasNextInt()){
					int i = in.nextInt();
					if(i>1000){
						data.add(new YearData(i));
					}
				} else if (in.hasNextDouble()){
					data.get(data.size()-1).add(in.nextDouble());
				} else {
					in.next();
				}
            }
			in.close();
			print();
		}catch(FileNotFoundException e){  
			System.out.println(e);
			System.exit(0);
		}
	}
	public static void print(){
		try {
			//sort by year
			PrintWriter outY = new PrintWriter(new File("UnemploymentByYear.txt"));
			Collections.sort(data);
			for(YearData a : data){
				outY.println(a.print());
				System.out.println(a.print());
			}
			outY.close();
			//sort by average
			PrintWriter outA = new PrintWriter(new File("UnemploymentByYearAverage.txt"));
			Collections.sort(data,new AvgComparator());
			for(YearData a : data){
				outA.println(a.print());
				System.out.println(a.print());
			}
			outA.close();
			//sort by net change
			PrintWriter outC = new PrintWriter(new File("UnemploymentByYearChange.txt"));
			Collections.sort(data,new NCComparator());
			for(YearData a : data){
				outC.println(a.print());
				System.out.println(a.print());
			}
			outC.close();
			System.exit(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

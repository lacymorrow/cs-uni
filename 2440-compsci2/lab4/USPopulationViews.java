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
public class USPopulationViews {
	static ArrayList<State> data = new ArrayList<State>();
	public static void main(String[] args){
		try {
			Scanner in = new Scanner(new File("StatesData.csv"));
			in.useDelimiter("[\n]+");
			while(in.hasNext()){
				String line = in.nextLine();
				if(line.indexOf("\"")>0){
					//fix decimals
					line = line.substring(0,line.indexOf("\""))+line.substring(line.indexOf("\""), line.indexOf("\"",line.indexOf("\"")+1)).replace(",", "").replace("\"", "")+line.substring(line.indexOf("\"",line.indexOf("\"")+1)+1,line.length());
					if(line.indexOf("\"")>0)
						line = line.substring(0,line.indexOf("\""))+line.substring(line.indexOf("\""), line.indexOf("\"",line.indexOf("\"")+1)).replace(",", "").replace("\"", "")+line.substring(line.indexOf("\"",line.indexOf("\"")+1)+1,line.length());
					data.add(new State(line.split(",")));
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
			//sort by population
			PrintWriter outY = new PrintWriter(new File("StatesByPopulation.txt"));
			Collections.sort(data);
			for(State a : data){
				outY.println(a.print());
				System.out.println(a.print());
			}
			outY.close();
			//sort by area
			PrintWriter outA = new PrintWriter(new File("StatesByArea.txt"));
			Collections.sort(data,new AreaComparator());
			for(State a : data){
				outA.println(a.print());
				System.out.println(a.print());
			}
			outA.close();
			//sort by population density
			PrintWriter outC = new PrintWriter(new File("StatesByPopDensity.txt"));
			Collections.sort(data,new PopDComparator());
			for(State a : data){
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

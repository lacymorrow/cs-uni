import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.Component;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * ClassScheduleFilter
 * Reads and processes a schedule file
 * 
 * @author Lacy Morrow 
 * @version 0.1
 */
public class ClassScheduleFilter{
    private static int i = -1;
    private static ArrayList<Dept> depts;
    public static void main(String[] args) {
        depts = new ArrayList<Dept>();
        JFileChooser fc = new JFileChooser();
        //gets file input
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
                readFile(fc.getSelectedFile());
        }   
    }
    public static void readFile(File file){
        try{
            Scanner in = new Scanner(file);
            
            //read each line
            while(in.hasNextLine()){
                String line = in.nextLine();
                boolean isDept = line.length() > 0 && line.charAt(0) != ' ' ;
                boolean isCourse = line.length() > 0 && Character.isDigit(line.charAt(1)); 
                if(isDept) {
                    //create new dept
                    i++;
                    depts.add(new Dept(line));
                } else if(isCourse){
                    //add course to dept
                    //fixes offset issue
                    int a = Character.isDigit(line.charAt(56)) ? 0 : 2;
                    String inst = (line.length()>94+a)? line.substring(94+a,line.length()) : "Staff";
                    String hours = line.substring(56+a,57+a);
                    depts.get(i).addCourse(line.substring(1,6),line.substring(21,45),hours,inst);//Integer.parseInt(line.substring(1,6))
                } else {
                    //unimportant line
                }
            }
            print();
        } catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
    }
    public static void print(){
        //prints each dept data
        for(int i = 0;i<depts.size();i++){
            depts.get(i).print();
        }
    }
}

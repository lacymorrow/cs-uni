import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
/**
 * Calculate the Flesch Readability Index of a chosen text file
 * and output results.
 *
 * @author Lacy Morrow 
 * @version 2.4.10
 */
public class Document {
	private static ArrayList<Word> words = new ArrayList<Word>();
	private static int sentences=0;
	private static int syllables = 0;
	private static File infile;
        private static File outfile;
	/**
	 * @param A text file to be read.
	 */
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
	      	//ask for input file
	      	if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	        	infile = fc.getSelectedFile();
	      	}else {
	        	System.exit(0);
	      	}
	      	//ask for output file
	      	if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
	        	outfile = fc.getSelectedFile();
	      	}else {
	        	System.exit(0);
	      	}
	      	try {
	        	Scanner count = new Scanner(infile);
			count.useDelimiter("[.:;?!]+");
			//count sentences
			while(count.hasNext()){
				count.next();
				sentences++;
			}
			count.close(); 
			Scanner in = new Scanner(infile);
	        	in.useDelimiter("[ \t\n,-.:;?!]+");
	        	//count words and syllables
			while(in.hasNext()){
	            		words.add(new Word(in.next()));
	       			syllables += words.get(words.size()-1).getSyllables();
			}
			in.close();
			displayDocStats();
			writeDocStats();
	      	}catch(FileNotFoundException e){
			System.out.println(e);
	         	System.exit(0);
	      	}
	}
	public Document(File inFile){
		JFileChooser fc = new JFileChooser();
                ArrayList<Word> words = new ArrayList<Word>();
		infile =inFile;
		//ask for output file
		if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
			outfile = fc.getSelectedFile();
		}else {
			System.exit(0);
		}
		try {
			Scanner	count =	new Scanner(infile);
                	count.useDelimiter("[.:;?!]+");
                	//count sentences
			while(count.hasNext()){
                        	count.next();
                        	sentences++;
                	}
                	count.close();
                 	Scanner in = new Scanner(infile);
                 	in.useDelimiter("[ \t\n,-:;?!]+");
                 	PrintWriter out = new PrintWriter(outfile);
                 	//count words and syllables
			while(in.hasNext()){
                 		words.add(new Word(in.next()));
				syllables += words.get(words.size()-1).getSyllables();
                 	}
                	in.close();
			displayDocStats();
                        writeDocStats();	
		}catch(FileNotFoundException e){  
			System.out.println(e);
			System.exit(0);
		}
	}
	public static void displayDocStats(){
		System.out.println("Readability: "+getFleschIndex());
		System.out.println("Educational Level: "+getEducation());
		System.out.println("words: "+getWordCount());
		System.out.println("syllables: "+getSyllableCount());
		System.out.println("sentences: "+getSentenceCount());	
	}
	public static void writeDocStats(){
		try{
			PrintWriter out = new PrintWriter(outfile);
			out.println("Readability: "+getFleschIndex());
                	out.println("Educational Level: "+getEducation());
               		out.println("words: "+getWordCount());
                	out.println("syllables: "+getSyllableCount());
                	out.println("sentences: "+getSentenceCount());
			out.close();
		}catch(FileNotFoundException e){
                        System.out.println(e);
                        System.exit(0);
                }
	}
	public static int getFleschIndex(){
		return (int)(206.835 - 84.6 * (getSyllableCount()/getWordCount()) - 1.015 * (getWordCount()/getSentenceCount()));
	}
	public static double getSentenceCount(){
		return (double)sentences;
	}
	public static double getSyllableCount(){
		return (double)syllables;
	}
	public static double getWordCount(){
		return (double)words.size();
	}
	public static String getEducation(){
		int n = getFleschIndex();
		if(n>90){
			return "5th Grade";
		} else if (n>80){
			return "6th Grade";
                } else if (n>70){
                        return "7th Grade";
                } else if (n>65){
                        return "8th Grade";
                } else if (n>60){
                        return "9th Grade";
                } else if (n>50){
                        return "High School";
                } else if (n>30){
                        return "College Student";
                } else if (n>0){
                        return "College Graduate";
                } else {
			return "Law School Graduate";
		}
	}

}


package wc;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class wc {
	private static ArrayList<String> list = new ArrayList<String>();
	private static TreeMap<String, Integer> frc = new TreeMap<String, Integer>( );
	
	public static void main(String arg[]) throws IOException
 {   
	 readfile(frc);
	 System.out.println(".");
	 
	 
	 
	 printAllCounts(frc);
	 
	 
	 
 }
 
 public static void printAllCounts(TreeMap<String, Integer> frc) throws IOException
 {
	
    FileWriter out = new FileWriter("out.txt");
	BufferedWriter ot = new BufferedWriter(out);
    for(String word : frc.keySet( ))
    {
      ot.write(word);
      System.out.print(word+" "); 
      ot.write(frc.get(word));
      System.out.println(frc.get(word));
    }

    
 }  

 
 
 
 
 public static void readfile(TreeMap<String, Integer> frc)
 {
	Scanner file = null;
	String word;
    int count;	
	
    try {
		file=new Scanner(new FileReader("/home/akash/wiki10gb"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

    while (file.hasNext( ))
    {
          word = file.next( );
  // System.out.print(word);
          count = count(word, frc) + 1;
        frc.put(word, count);
    }
	 
 }
 
 
 
 
 
 public static int count(String word,TreeMap<String,Integer> frc)
 {
	 
	 if (frc.containsKey(word))
     {  
	   return frc.get(word); 
     }
     else
     { 
        return 0;
     }
	 
	 
	 
	 
 }
	
	
	
	
}

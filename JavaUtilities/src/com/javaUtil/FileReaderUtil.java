package com.javaUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Read file and return read contents.
 * @author nazeef_shaikh 
 *
 */

public class FileReaderUtil{

	//------- Read file and return entire content of file in a string-------
	
	public String readFile(String fileName) {
			
		 File file = new File(fileName);
		 StringBuilder content=new StringBuilder("");  
		 
	     try {
	           
	          Scanner scanner = new Scanner(file);
	          int lineNum=0;
	          
	          
	          while (scanner.hasNextLine()) {
	        	    if(lineNum == 0)
	        	    	content.append(scanner.nextLine());
	        	    else
		        	    content.append("\n").append(scanner.nextLine());
	                lineNum++;
	          }
	     } 
	     catch (FileNotFoundException e) {
	            e.printStackTrace();
	     }
	        
		 return content.toString();
	}
	

	//------- Read file and return each line in array of strings-------
	
	public String[] readFileLineByLine(String fileName) {
		   
		return readFile(fileName).split("\n");
	}


	//-------Based on any delimiter Read file and return part in array of strings-------
	
	public String[] readFileLineByLine(String fileName, String delimiter) {
		
		return readFile(fileName).split(delimiter);
	}

}

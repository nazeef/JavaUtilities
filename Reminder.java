import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reminder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg=null,time=null,msgPrint="";
		String lines[]=readFileLineByLine("notes.txt");
		
		for(int i=0;i<lines.length;i++){
			time=lines[i].split(",")[0];
			msg=lines[i].split(",")[1];
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        int currTime=Integer.parseInt(timestamp.toString().split(" ")[1].split(":")[0]);
	        
	        if(time.contains(":")){
	        	time=time.split(":")[0];
	        }
	        int remTime=Integer.parseInt(time);
	        if(currTime==remTime || currTime+1==remTime){
	        	msgPrint+=lines[i]+"\n";
	        }

		}
		
		
		JOptionPane.showMessageDialog(null, ""+msgPrint, "Reminder:", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//------- Read file and return each line in array of strings-------
	
	public static String[] readFileLineByLine(String fileName) {
			   
			return readFile(fileName).split("\n");
	}
	//------- Read file and return entire content of file in a string-------
	
	public static String readFile(String fileName) {
				
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

}

package frameWindow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InstaSearch {
	String result;
	public InstaSearch(){
		
	}
	
	public String instaSearch(String keyword){
		
		result = "";
		result = "<html>";
		Path currentRelativePath = Paths.get("");
		String pwd = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + pwd);
		
		listFile(pwd, keyword);
		
		return result+"Search Completed:</html>";	
	}
	
	public void listFile(String pathname, String keyword) {
	    File f = new File(pathname);
	    File[] listfiles = f.listFiles();
	    for (int i = 0; i < listfiles.length; i++) {
	        if (listfiles[i].isDirectory()) {
	            File[] internalFile = listfiles[i].listFiles();
	            for (int j = 0; j < internalFile.length; j++) {
	            	
	            	if(internalFile[j].getName().contains(".java") || internalFile[j].getName().contains(".txt") || internalFile[j].getName().contains(".properties")){
	            		System.out.println(internalFile[j]);  // check for txt files
	            		search(internalFile[j], keyword);
	            	}
	                if (internalFile[j].isDirectory()) {
	                    String name = internalFile[j].getAbsolutePath();
	                    listFile(name,keyword);
	                }

	            }
	        } else {
	        	if(listfiles[i].getName().contains(".java") || listfiles[i].getName().contains(".txt") || listfiles[i].getName().contains(".properties")){
	        		System.out.println(listfiles[i]);
	        		search(listfiles[i], keyword);
	        	}
	        }

	    }

	}

	private void search(File file, String keyword) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int lineNumber = 0, isFirstMatch = 0;
		    
		    while ((line = br.readLine()) != null) {
		       lineNumber++;
		       
		       if(line.contains(keyword)){
		    	   if(isFirstMatch == 0){  //  prints file name for first match
		    		   result+= "<h3>"+file+"</h3>";
		    		   isFirstMatch++;
		    	   }
		    	   System.out.println(file.getAbsolutePath()+" --> "+lineNumber+" --> "+line);
		    	   result+= lineNumber+" -->"+line+"<br/>";
		       }	       
		       
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

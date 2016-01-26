package com.javaUtil;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Utility for string functions and array related functions.
 * @author nazeef
 *
 */
public class StringUtil {
	
	//-------------- Join array into one string with a delimiter---------------------------------------------------------------------
	
	public String join(String[] arr,String delimiter){
		
		int i=0;
		StringBuilder newString=new StringBuilder("");
		
		if(arr==null)                        //   if array is null
			return "";
		
		for( i=0;i<arr.length-1;i++){
			newString.append(arr[i]).append(delimiter);	
		}
		newString.append(arr[i]);	
		
		return newString.toString();		
	}
	
	
	//-------------- Insert new string at multiple positions in source string-----------------------------------------------------------
	
	public String insertStringAtPositions(String str, String strToBeInserted, int... positionArgs  ){
		
		int lastPos=0 , i=0;
		if(str == null || positionArgs.length == 0)
			return str;
		
		if(strToBeInserted == null)
			strToBeInserted = " ";
		
		int positions[] = arrayRemoveDuplicates( positionArgs);
		
		String[] arr=new String[positions.length+1];         // array to accomodate substrings
		//System.out.println("--------------------"+positions[0]+"--------------------"+positions[2]);
		if(positions[0]<0 || positions[positions.length-1] > str.length()-1 ){       // basic array index positions validation
		//	System.out.println("Invalid positions!");
			return "";
		}
		
		for( i=0;i<positions.length;i++){
			arr[i] = str.substring(lastPos, positions[i]);
			lastPos =  positions[i];
		}
		
		arr[i] = str.substring(lastPos, str.length());            // last substring till end of string
		
		return join(arr,strToBeInserted);
			
	}
	

	
	//-------------- Remove duplicates from int array---------------------------------------------------------------------------------------------
	
	public int[] arrayRemoveDuplicates(int[] arr){
		
		Set<Integer> arraySet = new TreeSet<Integer>();
		
		for(int i=0;i<arr.length;i++) {                      // put elements of array in a set
			arraySet.add(arr[i]);
		}
		
		int[] newArr = new int[arraySet.size()];
		int index = 0;
		
		for( Integer i : arraySet ) {
		  newArr[index++] = i; 								// autounboxing done here	 
		}
		
		return newArr;	
	}
	
	
	//     ----------------------------------------------------------------------------------------------------------------------------------
}

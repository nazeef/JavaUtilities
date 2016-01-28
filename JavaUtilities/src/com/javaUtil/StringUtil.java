package com.javaUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Utility for string functions and array related functions.
 * @author nazeef
 *
 */
public class StringUtil {
	
	//-------------- Join array into one string with a delimiter---------------------------------------------------------------------
	
	public static String join(String[] arr,String delimiter){
		
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
	
	public static String insertStringAtPositions(String str, String strToBeInserted, int... positionArgs  ){
		
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
	
	public static int[] arrayRemoveDuplicates(int[] arr){
		
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
	
	
	//     ----------------Find max element from list of elements of any data type------------------------------------------------------------------------------------------------------------------
	
	
	public static <T extends Comparable<T>> T max(T element1, T element2, T... elements) {
		
		List<T> elementList = new ArrayList<T>();
		
		if(element1 != null)                         // if not null add to arraylist
			elementList.add(element1);
		if(element2 != null)
			elementList.add(element2);
		
		if(elements != null){		                 // if only 2 parameters passed check
		    for (T element : elements) {
		        if (element != null) 
		        	elementList.add(element);       // else add to arraylist
		    }
		}
	    Collections.sort(elementList);
		
	    if(elementList.size() > 0)
	    	return elementList.get(elementList.size()-1);
	    else
	    	return null;
	}
	
//  ----------------Find min element from list of elements of any data type------------------------------------------------------------------------------------------------------------------
	
	
	public static <T extends Comparable<T>> T min(T element1, T element2, T... elements) {
		
		List<T> elementList = new ArrayList<T>();
		
		if(element1 != null)
			elementList.add(element1);                // if not null add to arraylist
		if(element2 != null)
			elementList.add(element2);
		
		if(elements != null){		                 // if only 2 parameters passed check
		    for (T element : elements) {
		        if (element != null) 
		        	elementList.add(element);       // else add to arraylist
		    }
		}
	    Collections.sort(elementList);
		
	    if(elementList.size() > 0)
	    	return elementList.get(0);
	    else
	    	return null;
	}
	
	//---------- print array elements of int array------------------------------------------------------
	
	public static void printArray(int[] arr){
		
		if(arr == null)                                  // null check
			return;
		
		//System.out.println();
		for(int counter=0;counter<arr.length;counter++){
			System.out.print(arr[counter]+"\t");
		}
		System.out.println();
	}
	
	//---------- print 2d array elements ------------------------------------------------------
	
	public static void printArray(int[][] arr){
			
			if(arr == null)                               // null check
				return;
			
			for(int rowCounter=0;rowCounter<arr.length;rowCounter++){
				for(int colCounter=0;colCounter<arr[0].length;colCounter++){
					
					System.out.print(arr[rowCounter][colCounter] + "\t");
				}
				System.out.println();
			}
	}
	
	//---------- print array elements of any data type------------------------------------------------------
	
	public static<T> void printArray(T[] arr){
			
			if(arr == null)                                  // null check
				return;
			
			for(int counter=0;counter<arr.length;counter++){
				System.out.print(arr[counter]+"\t");
			}
			System.out.println();
		}

}

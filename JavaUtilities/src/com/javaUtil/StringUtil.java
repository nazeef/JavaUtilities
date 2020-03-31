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
		
	//     -------------------Convert time to 24hr format-----------------------------------------------------------------------------------

	public static String convertTimeTo24HourFormat(String time){
		
		String hr= time.split(":")[0];
        	int hour= Integer.parseInt(hr);
        
	        if(time.charAt(8)=='P' || time.charAt(8)=='p'){             // If PM
	            
	            if(hour<12)                                             // check noon
	            	hour+= 12;
	            return hour+time.substring(2,8);     
	        }
	        else if(time.charAt(8)=='A' || time.charAt(8)=='a'){        // If AM
	        	
	            if(hour==12)											// check midnight
	            	hour = 0;
	            return "0"+hour+time.substring(2,8);
	        }
	        else{                                                      // wrong format.
	        	return time;
	        }
	}	
	
	// ------------------------------  Power set of String- returns all substrings----------------------
	
	public static String[] powerSet(String string){
		
		if(string == null)
			return null;
		
		List<String> list = new ArrayList<String>();
		
		int length = string.length();
		
		for( int outerCounter = 0 ; outerCounter < length ; outerCounter++ )
	      {
	         for( int innerCounter = 1 ; innerCounter <= length - outerCounter ; innerCounter++ )
	         {
	            list.add(string.substring(outerCounter, outerCounter + innerCounter));
	         }
	     }
		
		String substrings[] = list.toArray(new String[list.size()]);
		
		return substrings;		
	}
	
	//-------------Print entire object ,   object.toString()--------------------------------------------------
	
	public static void printObject(Object myClassObject){
		for (Field field : myClassObject.getClass().getDeclaredFields()) {
		    field.setAccessible(true);
		    String name = field.getName();
		    Object value=null;
			try {
				value = field.get(myClassObject);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.printf("%s: %s%n", name, value);
		}
		
	}
	
	//-------------Shift a string to left or right
	// Left -1 , Right -2
	private static String shift(String str, int numOfPlaces, int leftOrRight) {

		char[] newStr= new char[str.length()];

		if(leftOrRight == 1){   // Left shift
			for(int i=0;i<str.length();i++){
				if((i-numOfPlaces) >= 0){
					newStr[i-numOfPlaces]=str.charAt(i);
				}else{
					newStr[str.length() + (i-numOfPlaces)]=str.charAt(i);
				}	
			}
		}
		else if(leftOrRight == 2){   // Right shift
			for(int i=0;i<str.length();i++){
				if((i+numOfPlaces) < str.length()){
					newStr[i+numOfPlaces]=str.charAt(i);
				}else{
					newStr[(i+numOfPlaces) - str.length()]=str.charAt(i);
				}	
			}
		}
		return String.valueOf(newStr);
	}
	
}

/*
 * https://www.geeksforgeeks.org/quick-sort/
 * 
 * 
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.
 */
package dataStructures.gog.sorting;

import java.util.Arrays;

public class QuickSort_PartitionSort_Main {

	public static void main(String args[]) 
    { 
        int arr[] = {4,3,1,2}; 
        //int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr); 
  
        Util.PrintUtil.println("sorted array"); 
        printArray(arr); 
    } 
	
	 static void printArray(int arr[]) 
	    { 
	        Util.PrintUtil.println(Arrays.toString(arr));
	    } 
}
class QuickSort
{
	public void sort(int[] input)
	{
		quickSort(input, 0, input.length-1);
	}
	public void quickSort(int[] input,int lower,int upper)
	{
		
		Util.PrintUtil.println("entering quickSort(int[] input,int lower,int upper) = quickSort("+Arrays.toString(input)+","+lower+","+upper+")");
		if(lower < upper)
		{
			Util.PrintUtil.println("calling partition(input, lower, upper) = partition("+input+", "+lower+", "+upper+")");
			int patitionIndex = partition(input, lower, upper);
			Util.PrintUtil.println(" return value of partitionIndex "+patitionIndex);
			quickSort(input, lower, patitionIndex-1);
			quickSort(input, patitionIndex+1, upper);
		}
		Util.PrintUtil.println("Exit quickSort(int[] input,int lower,int upper) = quickSort("+Arrays.toString(input)+","+lower+","+upper+")");
	}
	
	/* This function takes last element as pivot, places
	   the pivot element at its correct position in sorted
	    array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right
	   of pivot */
	public int partition(int[] input,int lower,int upper)
	{
		//always working as pivot element to be last
		Util.PrintUtil.println("	entry partition  ->  lower "+lower+" upper "+upper+" -> "+Arrays.toString(input));
		int pivotIndex = upper;
		int returnPartionIndex = lower-1;
		
		for(int j=lower;j<upper;j++)
		{
			Util.PrintUtil.print("		is input["+j+"] < pivotValue "+input[j] + " < "+input[pivotIndex]);
			if(input[j] < input[pivotIndex])
			{
				//swap 
				Util.PrintUtil.println(" YES swap is required ");
				returnPartionIndex++;
				int temp = input[j];
				input[j] =input[returnPartionIndex];
				input[returnPartionIndex] = temp;
				Util.PrintUtil.println("			swapped occurred -> lower "+lower+" upper "+upper+" j "+j+" swapper "+returnPartionIndex+Arrays.toString(input));
			}
			else
			{
				Util.PrintUtil.println(" NO so swap is  NOT required ");
			}
		}
		
		++returnPartionIndex;
		Util.PrintUtil.println("		swapping before end  "+input[returnPartionIndex]+" "+input[upper]);
		int temp = input[returnPartionIndex]; 
        input[returnPartionIndex] = input[upper]; 
        input[upper] = temp; 
        Util.PrintUtil.println("	exit partition  ->  lower "+lower+" upper "+upper+" returnPartionIndex "+returnPartionIndex+Arrays.toString(input));
		return returnPartionIndex;
		
	}
}
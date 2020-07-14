/*
 * 
 * https://www.geeksforgeeks.org/selection-sort/
 * 
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.

arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 

efficency
all the complexity in
worst O(n^2)
best O(n^2)
avg O(n^2)
space O(1)
 
 */

package dataStructures.gog.sorting;

import java.util.Arrays;

public class SelectionSort_Main {
	public static void main(String args[])
	{

		int input[] = {5,4,3,2,1};
		System.out.println("Given array -> "+Arrays.toString(input));
		new SelectionSort().sortWithMinFirst(input);
		System.out.println("Sorted array -> "+Arrays.toString(input));
	
		
		
		
		int inputWithMaxFirst[] = {1,2,3,5,4};
		System.out.println("Given array -> "+Arrays.toString(inputWithMaxFirst));
		new SelectionSort().sortWithMaxFirst(inputWithMaxFirst);
		System.out.println("Sorted array -> "+Arrays.toString(inputWithMaxFirst));
	}
}
class SelectionSort
{
	public void sortWithMinFirst(int input[])
	{
		for(int outer = 0 ; outer < input.length ; outer ++)
		{
			int smallest = input[outer];// use this in case you are sorting linked list
			int smallestIndex = outer; //use this in case you are using array is used i.e. constant access time and there is space complexity
			boolean newSmallestFound = false;
			for (int inner = (outer+1) ; inner < input.length ; inner++)
			{
				if(input[inner] < smallest)
				{
					//update the smallest value
					smallest = input[inner];
					smallestIndex = inner;
					newSmallestFound = true;
				}
			}
			
			// swap smallest
			if(newSmallestFound)
			{
				int temp = input[outer];
				input[outer] = input[smallestIndex];
				input[smallestIndex] = temp;
			}
		}
	}
	
	
	
	public void sortWithMaxFirst(int input[])
	{
		for(int outer = (input.length - 1) ; outer >= 0 ; outer --)
		{
			int largest = input[outer];
			int largestIndex = outer;
			boolean newLargestFound = false;
			for (int inner = (outer-1) ; inner >= 0 ; inner--)
			{
				if(input[inner] > largest)
				{
					//update the largest value
					largest = input[inner];
					largestIndex = inner;
					newLargestFound = true;
				}
			}
			
			// swap largest
			if(newLargestFound)
			{
				int temp = input[outer];
				input[outer] = input[largestIndex];
				input[largestIndex] = temp;
			}
		}
	}
}
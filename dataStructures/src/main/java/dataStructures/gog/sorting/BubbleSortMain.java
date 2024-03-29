/*
 * 
 * https://www.geeksforgeeks.org/bubble-sort/
 * https://www.studytonight.com/data-structures/bubble-sort
 * 
 * worst case		-> O(n^2)
 * best case		-> O(n)		 array is sorted
 * average case		-> O(n^2)
 * space			-> O(1)      only 1 temp variable need for swapping
 * 
 * improvements
 * 
 * Bubble Sort
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
Example:
First Pass:
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.

Third Pass:
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 */

package dataStructures.gog.sorting;

import java.util.Arrays;

public class BubbleSortMain {
	public static void main(String args[])
	{
		
		int arr[] = {5,1,4,2,8};
		p.o.println(Arrays.toString(arr));
		new BubbleSortAlgo().bubbleSort(arr);
		p.o.println(Arrays.toString(arr));
		
		
		
		int arr1[] = {25,57,48,37,12,92,86,33};
		p.o.println(Arrays.toString(arr1));
		new BubbleSortAlgo().bubbleSort(arr1);
		p.o.println(Arrays.toString(arr1));
	}
}

class BubbleSortAlgo
{
	void bubbleSort(int arr[])
	{
		int arrLength = arr.length,  temp = -1;
		boolean improvement_Switched = true;
		//for(int pass = 0 ; pass < (arrLength-1) ; pass ++) //without improvement
		for(int pass = 0 ; pass < (arrLength-1) && improvement_Switched ; pass ++) //with improvement
		{
			improvement_Switched = false;
			p.o.println("\t"+(pass+1)+"pass Entry -> "+Arrays.toString(arr));
			for(int inner = 0 ; inner < (arrLength-1); inner ++)
			{
				boolean display_swapped = false;///just for display purpose
				int display_swapIndex = 0 ; ///just for display purpose
				p.o.print("\t\t"+Arrays.toString(arr));
				if(arr[inner] > arr[inner+1])												// current element is greater than next elem in array
				{
					temp = arr[inner];
					arr[inner] = arr[inner+1];
					arr[inner+1] = temp;
					display_swapped = true;
					display_swapIndex = inner;
					improvement_Switched = true;
				}
				if(display_swapped)
				p.o.println(" --> "+Arrays.toString(arr)+ " swapped "+display_swapped+" as "+arr[display_swapIndex+1]+" > "+arr[display_swapIndex]);
				else
					p.o.println(" --> "+Arrays.toString(arr));
			}
			p.o.println("\t"+(pass+1)+"pass Exit  -> "+Arrays.toString(arr)+"\n");
		}
	}
}

/*
 * 
 * https://www.geeksforgeeks.org/merge-sort/
 * 
 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
The following diagram from wikipedia shows the complete merge sort process for an example array {38, 27, 43, 3, 9, 82, 10}. If we take a closer look at the diagram, we can see that the array is recursively divided in two halves till the size becomes 1. Once the size becomes 1, the merge processes comes into action and starts merging arrays back till the complete array is merged.
 */

package dataStructures.gog.sorting;

import java.util.Arrays;

public class MergeSortMain {
	// Driver method 
    public static void main(String args[]) 
    { 
    	
        int arr[] =  {38,27,43,3,9,82,10};//{25,57,48,37,12,92,86,33};//{ 12, 11, 13, 5, 6, 7 }; 
  
        p.o.println("Given Array"); 
        p.o.println(Arrays.toString(arr));
  /*
        MergeSortCopied ob = new MergeSortCopied(); 
        ob.sort(arr, 0, arr.length-1);
        
        */
        MergeSort ob = new MergeSort(); 
        ob.sort(arr);
  
        p.o.println("\nSorted array"); 
        p.o.println(Arrays.toString(arr));
        
        
        
        /*
        
        int arr1[] = { 25,57,48,37,12,92,86,33 }; 
        
        p.PrintUtil.println("Given Array"); 
        p.PrintUtil.println(Arrays.toString(arr1));
  
        new MergeSort().sort(arr1);
  
        p.PrintUtil.println("\nSorted array"); 
        p.PrintUtil.println(Arrays.toString(arr1));
        
        */
    } 
    
    
 }

class MergeSort
{
	void sort(int input[])
	{
		sort(input, 0 , input.length -1 );
	}
	void sort(int input[], int left ,int right)
	{
		if( left < right)
		{
			int middle = (right+left)/2;
			
			sort(input,left,middle);
			sort(input,middle+1,right);
			
			mergeArray(input, left, middle, right);
		}
	}
	
	// merge two arrays arr[0 to middle ] and arr[middle+1 to right]
	void mergeArray(int input[],int left , int middle , int right)
	{
		// 1 - make two temp array a1 and a2
		// 2 - copy to temp array
		// 3-  compare and add from temp to input
		// 4 - add remaining to input
		
		
		
		// 1 - make two temp array a1 and a2
		
		// these are for better code readability only they can be calculated on the fly
		int sizeOf_A1 = middle-left+1;
		int sizeOf_A2 = right - middle;
		int startof_A1 = left ;
		int startof_A2 = middle+1 ;
		//copy input array to two different array
		int[] A1 = new int[sizeOf_A1];
		int[] A2 = new int[sizeOf_A2];
		
		
		
		
		// 2 - copy to temp array
		
		for(int current = 0 ; current < sizeOf_A1 ; current++)
			A1[current] = input[startof_A1+current];
		
		for(int current = 0 ; current < sizeOf_A2 ; current++)
			A2[current] = input[current+startof_A2];
		
		
		
		
		// 3-  compare and add from temp to input
		int current_A1=0,current_A2=0,current_merge=startof_A1;
		while( (current_A1 < sizeOf_A1) && (current_A2 < sizeOf_A2) )
		{
			// search and assign arr[current_merge]
			if(A1[current_A1] <= A2[current_A2])
			{
				input[current_merge ++ ] = A1[current_A1 ++];
				//current_A1 ++;
			}
			else
			{
				input[current_merge ++ ] = A2[current_A2 ++];
				//current_A2++;
			}
		}
		
		// 4 - add remaining to input
		while(current_A1 < sizeOf_A1)
		{
			input[current_merge ++ ] = A1[current_A1 ++];
			// current_A1 ++;current_merge++;
		}
		
		while(current_A2 < sizeOf_A2)
		{
			input[current_merge ++ ] = A2[current_A2 ++];
			////current_A2 ++;current_merge++;
		}
		
		p.o.println(" left "+left+",  middle "+middle+" ,  right "+right+"  --> "+Arrays.toString(input));
	}
	
}



//class MergeSortCopied { 
//    // Merges two subarrays of arr[]. 
//    // First subarray is arr[l..m] 
//    // Second subarray is arr[m+1..r] 
//    void merge(int arr[], int left, int middle, int right) 
//    { 
//        // Find sizes of two subarrays to be merged 
//        int sizeOf_A1 = middle - left + 1; 
//        int sizeOf_A2 = right - middle; 
//  
//        /* Create temp arrays */
//        int A1[] = new int[sizeOf_A1]; 
//        int A2[] = new int[sizeOf_A2]; 
//  
//        /*Copy data to temp arrays*/
//        for (int i = 0; i < sizeOf_A1; ++i) 
//            A1[i] = arr[left + i]; 
//        for (int j = 0; j < sizeOf_A2; ++j) 
//            A2[j] = arr[middle + 1 + j]; 
//  
//        /* Merge the temp arrays */
//  
//        // Initial indexes of first and second subarrays 
//        int current_A1 = 0, current_A2 = 0; 
//  
//        // Initial index of merged subarry array 
//        int current_Merge = left; 
//        while (current_A1 < sizeOf_A1 && current_A2 < sizeOf_A2) { 
//            if (A1[current_A1] <= A2[current_A2]) { 
//                arr[current_Merge] = A1[current_A1]; 
//                current_A1++; 
//            } 
//            else { 
//                arr[current_Merge] = A2[current_A2]; 
//                current_A2++; 
//            } 
//            current_Merge++; 
//        } 
//  
//        /* Copy remaining elements of L[] if any */
//        while (current_A1 < sizeOf_A1) { 
//            arr[current_Merge] = A1[current_A1]; 
//            current_A1++; 
//            current_Merge++; 
//        } 
//  
//        /* Copy remaining elements of R[] if any */
//        while (current_A2 < sizeOf_A2) { 
//            arr[current_Merge] = A2[current_A2]; 
//            current_A2++; 
//            current_Merge++; 
//        } 
//    } 
//  
//    // Main function that sorts arr[l..r] using 
//    // merge() 
//    void sort(int arr[], int left, int right) 
//    { 
//        if (left < right) { 
//            // Find the middle point 
//            int middle = (left + right) / 2; 
//  
//            // Sort first and second halves 
//            sort(arr, left, middle); 
//            sort(arr, middle + 1, right); 
//  
//            // Merge the sorted halves 
//            merge(arr, left, middle, right); 
//        } 
//    } 
//  
//    /* A utility function to print array of size n */
//    static void printArray(int arr[]) 
//    { 
//        int n = arr.length; 
//        for (int i = 0; i < n; ++i) 
//            p.PrintUtil.print(arr[i] + " "); 
//        p.PrintUtil.println(); 
//    
//    }
//}

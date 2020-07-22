package dataStructures.gog.sorting;

import java.util.Arrays;

import dataStructures.gog.ds.heaps.Heap;
import dataStructures.gog.ds.heaps.HeapInterface;
import dataStructures.gog.ds.trees.BinaryTree_Array;

public class HeapSort_Array<T> {
	public void sort(T[] inputs)
	{
		
		HeapInterface<T> heapInt = new Heap<T>(inputs.length,(a,b) -> (BinaryTree_Array.castAndCompareTo(a, b)));
		for(T i : inputs)
			heapInt.addToHeap(i);
		int temp = 0;
		while( heapInt.peak() != null)
		{
			inputs[temp ++] = heapInt.popRoot();
		}
			
	}
	
	
	public void reverseSort(T[] inputs)
	{
		
		HeapInterface<T> heapInt = new Heap<T>(inputs.length,(a,b) -> (-1 * BinaryTree_Array.castAndCompareTo(a, b)));
		for(T i : inputs)
			heapInt.addToHeap(i);
		int temp = 0;
		while( heapInt.peak() != null)
		{
			inputs[temp ++] = heapInt.popRoot();
		}
			
	}
	public static void main (String args[])
	{
		
		Integer[] inputs = {25,57,48,37,12,92,86,33};
		HeapSort_Array<Integer> sorter = new HeapSort_Array<Integer>();
		sorter.sort(inputs);
		System.out.println(Arrays.deepToString(inputs));
		
		sorter.reverseSort(inputs);
		System.out.println(Arrays.deepToString(inputs));
	}
}

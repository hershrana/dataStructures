package dataStructures.gog.searching;

import java.util.Arrays;
import java.util.function.BiFunction;

import dataStructures.gog.sorting.BinaryTreeSort_Array;

public class BinarySearch<T> implements Search<T> {
	BiFunction<T,T, Integer> compareLambda;
	public BiFunction<T,  T, Integer>  getCompareLambda() {
		return compareLambda;
	}

	public void setCompareLambda(BiFunction<T,T, Integer>   compareLambda) {
		this.compareLambda = compareLambda;
	}
	
	public BinarySearch(BiFunction<T,T, Integer>   compareLambda) {
		super();
		this.compareLambda = compareLambda;
	}
	public BinarySearch() {
		super();
		this.compareLambda = (BiFunction<T, T, Integer>) p.u.castAndCompareToLambda;
	}
	@Override
	public int search(T searchFor, T[] input) {

			
		return 0;
	}

	public T[] getSortedArray(T[] arrayToSort)
	{
		p.o.printMandatory("Binary Search expects the array to be sorted for our example we will sort array and this will lead to change in indices ");
		T[] sortedArray;
		boolean sorted = true;
		for(int i = 1 ; i < arrayToSort.length && sorted; i ++)
			if(compareLambda.apply(arrayToSort[i-1], arrayToSort[i]) < 0)
			{
				sorted = false;
			}
		if(sorted)
		{
			sortedArray = arrayToSort;
		}
		else
		{
			sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
			new  BinaryTreeSort_Array<T>(compareLambda).sortGeneric(sortedArray);
			p.o.println("Array is sorted "+Arrays.toString(sortedArray));
		}
		return sortedArray;
	}
	@Override
	public Object searchAndReturn(T searchFor, T[] input) {
		// TODO Auto-generated method stub
		input = getSortedArray(input);
		int low = 0 , high = input.length ,mid = (low+high)/2, maxIndex = input.length-1;
		while(low <= high && (low <= maxIndex))
		{
			int compareResult = compareLambda.apply(searchFor, input[mid]);
			if( compareResult == 0)
			{
				p.o.println(searchFor +" = "+ input[mid] + " matched exiting");
				return input[mid];
			}
			else if (compareResult < 0 )
			{
				p.o.println(searchFor +" < "+ input[mid] + " hence lowering high");
				high = mid - 1;
				mid = (low+high)/2;
			}
			else
			{
				p.o.println(searchFor +" > "+ input[mid] + " hence incerasing low");
				low = mid + 1;
				mid = (low+high)/2;
			}
		}
		return null;
	}

}

package dataStructures.gog.sorting;

import java.util.Arrays;
import java.util.function.BiFunction;

import dataStructures.gog.ds.trees.BinarySearchTree_Array;

public class BinaryTreeSort_Array<T> extends BinarySearchTree_Array<T>{

	


	public BinaryTreeSort_Array() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinaryTreeSort_Array(BiFunction<T, T, Integer> comparatorLambda) {
		super(comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public BinaryTreeSort_Array(int MAXSTACK, BiFunction<T, T, Integer> comparatorLambda) {
		super(MAXSTACK, comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public BinaryTreeSort_Array(int MAXSTACK) {
		super(MAXSTACK);
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String args[])
	{
		Integer[] ips = {4,1,33,9,45,2,12};
		System.out.println("Given Array : "+Arrays.toString(ips));
		BinaryTreeSort_Array<Integer> bst = new BinaryTreeSort_Array<Integer>();
		bst.sortGeneric(ips);
		System.out.println(bst.inOrderTraversal());
		System.out.println("Sorted Array : "+Arrays.toString(ips));
		
	}
	

	public void sortGeneric(T[] input)
	{
		//populate BST
		for(int i=0;i<input.length;i++)
			insert(input[i]);
		custom<T> ret = new custom<T>(input,0);
		sortInOrderTraversal(ret,rootIndex);
		//do inorder traversal
		
	}
	
	public custom<T> sortInOrderTraversal(custom<T> custom,int startWithArrayIndex)
	{
		if(getArray()[startWithArrayIndex] == null)
			return custom;
		if(startWithArrayIndex >= getArray().length-1)
			return custom;
		if(! getArray()[startWithArrayIndex].isInUse())
			return custom;
		// visit left
		
		sortInOrderTraversal(custom,getNextLeftIndex(startWithArrayIndex));
		
		//visit root
		if(getArray()[startWithArrayIndex] != null)
		{
			custom.sortedArray[ custom.indexToFill ++ ] = getInfoAtIndex(startWithArrayIndex);
		}
		
		
		//visit right
		sortInOrderTraversal(custom,getNextRightIndex(startWithArrayIndex));
		
		return custom;
	}
	
}
class custom<T>
{
	T[] sortedArray;
	int indexToFill = 0;
	public custom(T[] sortedArray, int indexToFill) {
		super();
		this.sortedArray = sortedArray;
		this.indexToFill = indexToFill;
	}
}

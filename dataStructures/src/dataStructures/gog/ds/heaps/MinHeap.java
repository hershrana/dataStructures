package dataStructures.gog.ds.heaps;

import java.util.Arrays;
import java.util.function.BiFunction;

import dataStructures.common.interfaces.tree.BinaryNode;
import dataStructures.gog.ds.trees.BinarySearchTree_Array;
import dataStructures.gog.ds.trees.BinaryTree_Array_Node;

public class MinHeap<T> extends BinarySearchTree_Array<T> implements HeapInterface<T> {

	
	public MinHeap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MinHeap(BiFunction<T, T, Integer> comparatorLambda) {
		super(comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public MinHeap(int MAXSTACK, BiFunction<T, T, Integer> comparatorLambda) {
		super(MAXSTACK, comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public MinHeap(int MAXSTACK) {
		super(MAXSTACK);
		// TODO Auto-generated constructor stub
	}

	@Override
	public T getInfoAtIndex(int atIndex) {
		// TODO Auto-generated method stub
		return super.getInfoAtIndex(atIndex);
	}

	@Override
	public BinaryTree_Array_Node<T> getRootNode() {
		// TODO Auto-generated method stub
		return super.getRootNode();
	}

	@Override
	public int getIndexAtValue(T searchValue) {
		// TODO Auto-generated method stub
		return super.getIndexAtValue(searchValue);
	}

	@Override
	public void setRightAtValue(T rightValue, T parentValue) {
		// TODO Auto-generated method stub
		super.setRightAtValue(rightValue, parentValue);
		
	}

	@Override
	public void setleftAtValue(T leftValue, T parentValue) {
		// TODO Auto-generated method stub
		super.setleftAtValue(leftValue, parentValue);
		
	}

	@Override
	public void setRight(T rightValue, int parentIndex) {
		// TODO Auto-generated method stub
		super.setRight(rightValue, parentIndex);
		
	}

	@Override
	public void setLeft(T leftValue, int parentIndex) {
		// TODO Auto-generated method stub
		super.setLeft(leftValue, parentIndex);
	}

	@Override
	public StringBuffer inOrderTraversal() {
		// TODO Auto-generated method stub
		return super.inOrderTraversal();
	}

	@Override
	public StringBuffer preOrderTraversal() {
		// TODO Auto-generated method stub
		return super.preOrderTraversal();
	}

	@Override
	public StringBuffer postOrderTraversal() {
		// TODO Auto-generated method stub
		return super.postOrderTraversal();
	}
	
	@SuppressWarnings("unchecked")
	public void setArrayBeforeHeaping(T[] array) {
		super.setArray(new BinaryTree_Array_Node[array.length]);
		int index = 0;
		
		for(T element: array)
		{
			this.getArray()[index++] = new BinaryTree_Array_Node<T>(element);
		}
	}

	@Override
	public void heapify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHeap(BinaryNode<T> startWith) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isHeapFromIndex(int startWith) {
		// TODO Auto-generated method stub
		System.out.println("isHeapFromIndex @"+startWith);
		if(startWith >= getArray().length)
			return true;
		if(getArray()[startWith] == null)
			return true;
		if(! getArray()[startWith].isInUse())
			return true;
		
		int rightNodeIndex = getNextRightIndex(startWith);
		int leftNodeIndex = getNextLeftIndex(startWith);
		/*if(getArray()[rightNodeIndex] == null)
			return true;
		if(! getArray()[rightNodeIndex].isInUse())
			return true;
		if(getArray()[leftNodeIndex] == null)
			return true;
		if(! getArray()[leftNodeIndex].isInUse())
			return true; */
		isHeapFromIndex(leftNodeIndex);
		isHeapFromIndex(rightNodeIndex);
		int lowestNodeIndex;
		
		System.out.println("Root ->"+getInfoAtIndex(startWith));
		System.out.println("Left ->"+getInfoAtIndex(leftNodeIndex));
		System.out.println("Right ->"+getInfoAtIndex(rightNodeIndex));
		if( getComparator().apply(getInfoAtIndex(leftNodeIndex), getInfoAtIndex(rightNodeIndex)) < 0 )
		{
			lowestNodeIndex = leftNodeIndex;
		}
		else
		{
			lowestNodeIndex = rightNodeIndex;
		}
		
		if( getComparator().apply(getInfoAtIndex(startWith), getInfoAtIndex(lowestNodeIndex)) < 0 )
		{
			lowestNodeIndex = startWith;
		}

		if(lowestNodeIndex != startWith)
		{
			System.out.println(" perform swap root with "+lowestNodeIndex);
			BinaryTree_Array_Node<T> temp = getArray()[startWith];
			getArray()[startWith] = getArray()[lowestNodeIndex];
			getArray()[lowestNodeIndex] = temp; 
			isHeapFromIndex(lowestNodeIndex);
		}
		else
		{
			System.out.println("no swap required "+lowestNodeIndex);
			//return true;
		}
		
		return true;
			
	}
	
	public boolean isHeap(T startWith) {
		// TODO Auto-generated method stub
		return isHeapFromIndex(getIndexAtValue(startWith));
	}
	
	@Override
	public BinaryNode<T> createHeap(T newRootNode) {
		// TODO Auto-generated method stub
		return createTree(newRootNode);
	}
	
	//driver program
	public static void main(String args[])
	{
		Integer[] inputs = {35,33,42,10,14,19,27,44,26,31};
		MinHeap<Integer> minHeap = new MinHeap<Integer>(inputs.length);
		//,10,14,19,27,44,26,31};
		minHeap.setArrayBeforeHeaping(inputs);
		//for(int input:inputs)
 		//minHeap.insert(input);
		//new BinaryTreeSort_Array<Integer>(10).sortGeneric(inputs);
		//System.out.println("BinaryTreeSort"+Arrays.deepToString(inputs));
		//System.out.println(Arrays.toString(minHeap.getArray()));
		//System.out.println(minHeap.inOrderTraversal());
		String beforeMinHeap =Arrays.toString(minHeap.getArray());
		System.out.println(minHeap.isHeapFromIndex(0));
		String afterMinHeap =Arrays.toString(minHeap.getArray());
		System.out.println("beforeMinHeap ->"+beforeMinHeap);
		System.out.println("afterMinHeap  ->"+afterMinHeap);
		System.out.println(minHeap.inOrderTraversal());
		//System.out.println(Arrays.toString(minHeap.getArray()));
	}

	@Override
	public boolean addToHeap(T elementToAdd) {
		
		return false;
	}

	

}

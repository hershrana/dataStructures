package dataStructures.gog.ds.heaps;

import java.util.Arrays;
import java.util.function.BiFunction;

import dataStructures.common.interfaces.tree.BinaryNode;
import dataStructures.gog.ds.trees.BinarySearchTree_Array;
import dataStructures.gog.ds.trees.BinaryTree_Array_Node;

public class Heap<T> extends BinarySearchTree_Array<T> implements HeapInterface<T> {

	int tailIndex =-1;
	public Heap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heap(BiFunction<T, T, Integer> comparatorLambda) {
		super(comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public Heap(int MAXSTACK, BiFunction<T, T, Integer> comparatorLambda) {
		super(MAXSTACK, comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public Heap(int MAXSTACK) {
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
		if(! isValidElement(startWith))
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
		if(isValidElement(leftNodeIndex))
			isHeapFromIndex(leftNodeIndex);
		if(isValidElement(rightNodeIndex))
			isHeapFromIndex(rightNodeIndex);
		int lowestNodeIndex;
		
		System.out.println("Root ->"+getInfoAtIndex(startWith));
		System.out.println("Left ->"+getInfoAtIndex(leftNodeIndex));
 		System.out.println("Right ->"+getInfoAtIndex(rightNodeIndex));
 		if( !isValidElement(rightNodeIndex) && ! isValidElement(leftNodeIndex))
 		{
 			return true;
 		}
		if( isValidElement(rightNodeIndex) && ! isValidElement(leftNodeIndex))
		{
			 leftNodeIndex=rightNodeIndex;
		}
		if ( ! isValidElement(rightNodeIndex) && isValidElement(leftNodeIndex))
		{
			 rightNodeIndex = leftNodeIndex;
		}
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
			if(! checkForArrayInBounds(lowestNodeIndex))
				return true;
			System.out.println(" perform swap root with "+lowestNodeIndex);
			BinaryTree_Array_Node<T> temp = getArray()[startWith];
			getArray()[startWith] = getArray()[lowestNodeIndex];
			getArray()[lowestNodeIndex] = temp; 
			//isHeapFromIndex(lowestNodeIndex);
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
		BiFunction<Integer, Integer, Integer> biFunction_MinHeap = (a,b) -> (a.compareTo(b));
		BiFunction<Integer, Integer, Integer> biFunction_MaxHeap = (a,b) -> (b.compareTo(a));
		
//		BiFunction<Integer, Integer, Integer> biFunction_MinHeap = (a,b) -> (castAndCompareTo(a,b));
//		BiFunction<Integer, Integer, Integer> biFunction_MaxHeap = (a,b) -> (castAndCompareTo(b,a));
		
//		Heap<Integer> minHeap = new Heap<Integer>(inputs.length,biFunction_MinHeap);
//		
//		Heap<Integer> maxHeap = new Heap<Integer>(inputs.length,biFunction_MaxHeap);
//		//MinHeap<Integer> minHeap = new MinHeap<Integer>(inputs.length);
//		//,10,14,19,27,44,26,31};
//		minHeap.setArrayBeforeHeaping(inputs);
//		maxHeap.setArrayBeforeHeaping(inputs);
//		
//
//		//for(int input:inputs)
// 		//minHeap.insert(input);
//		//new BinaryTreeSort_Array<Integer>(10).sortGeneric(inputs);
//		//System.out.println("BinaryTreeSort"+Arrays.deepToString(inputs));
//		//System.out.println(Arrays.toString(minHeap.getArray()));
//		//System.out.println(minHeap.inOrderTraversal());
//		String beforeMinHeap =Arrays.toString(minHeap.getArray());
//		String beforeMaxHeap =Arrays.toString(maxHeap.getArray());
//		minHeap.isHeapFromIndex(0);
//		maxHeap.isHeapFromIndex(0);
//		String afterMinHeap =Arrays.toString(minHeap.getArray());
//		String afterMaxHeap =Arrays.toString(maxHeap.getArray());
//		System.out.println("beforeMinHeap ->"+beforeMinHeap);
//		System.out.println("afterMinHeap   -> "+afterMinHeap);
//		
//		System.out.println("\nbeforeMaxHeap ->"+beforeMaxHeap);
//		System.out.println("afterMaxHeap   -> "+afterMaxHeap);

		
		Heap<Integer> minHeapAddDemo = new Heap<Integer>(inputs.length,biFunction_MinHeap);
		for(Integer i : inputs)
			minHeapAddDemo.addToHeap(i);
		System.out.println("\nminHeapAddDemo"+Arrays.toString(minHeapAddDemo.getArray()));
		
		
		Heap<Integer> maxHeapAddDemo = new Heap<Integer>(inputs.length,biFunction_MaxHeap);
		for(Integer i : inputs)
			maxHeapAddDemo.addToHeap(i);
		System.out.println("\nmaxHeapAddDemo"+Arrays.toString(maxHeapAddDemo.getArray()));
		
		//System.out.println(Arrays.toString(minHeap.getArray()));
		StringBuffer popRoot = new StringBuffer();
		for (int i = 0 ; i <10 ; i++)
			popRoot.append(minHeapAddDemo.popRoot()+" , ");
		
		StringBuffer popRooMaxt = new StringBuffer();
		for (int i = 0 ; i <10 ; i++)
			popRooMaxt.append(maxHeapAddDemo.popRoot()+" , ");

		
		System.out.println("min pop -> "+popRoot);
		System.out.println(minHeapAddDemo);
		
		System.out.println("max pop -> "+popRooMaxt);
		System.out.println(maxHeapAddDemo);
	}

	@Override
	public boolean addToHeap(T elementToAdd) {
		//
		int insertedAt = ++ tailIndex;
		getArray()[insertedAt] = new BinaryTree_Array_Node<T>(elementToAdd);
		int parentIndex = getParentIndex(tailIndex);
		boolean swap =true;
		while (swap)
		{
			parentIndex = getParentIndex(insertedAt);
			if( ! checkForArrayInBounds(parentIndex))
			{
				break;
			}
			swap =false;
			//compare current and child
			if(getComparator().apply(getInfoAtIndex(insertedAt), getInfoAtIndex(parentIndex)) < 0)
			{
				/// swap
				BinaryTree_Array_Node<T> temp = getArray()[parentIndex];
				getArray()[parentIndex] = getArray()[insertedAt];
				getArray()[insertedAt] = temp; 
				insertedAt = parentIndex;
				swap =true;
			}
		}
		return true;
	}

	@Override
	public T popRoot() {
		T retVal = getArray()[rootIndex].getInfo();
		//adjust heap
			//swap tail to root
			getArray()[rootIndex] = getArray()[tailIndex];
			getArray()[tailIndex --] = null;
			isHeapFromIndex(rootIndex);
			//heapify
		return retVal;
	}

	@Override
	public T peak() {
		return getArray()[rootIndex].getInfo();
	}
	
	
	public String toString()
	{
		return Arrays.toString(getArray());
	}

}

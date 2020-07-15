package dataStructures.gog.ds.trees;

import java.util.Arrays;
import java.util.function.BiFunction;


/*class BinaryTree_Array_Node<T>
{
	T info;
	boolean inUse =false;
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
		this.inUse = true;
	}
	public boolean isInUse() {
		return inUse;
	}
	public BinaryTree_Array_Node(T info) {
		super();
		this.info = info;
		this.inUse = true;
	}
	
	public BinaryTree_Array_Node() {
		super();
	}
	public String toString()
	{
		return info.toString();
	}
}*/
public class BinaryTree_Array<T> {
	int numberOfInputs = 10;
	int calc_MAXSTACK;
	BinaryTree_Array_Node<T>[] array ;
	
	public BinaryTree_Array_Node<T>[] getArray() {
		return array;
	}

	public T getInfoAtIndex(int atIndex) {
		return array[atIndex].getInfo();
	}
	
	public void setArray(BinaryTree_Array_Node<T>[] array) {
		this.array = array;
	}

	public BiFunction<T, T, Integer> getComparator() {
		return comparator;
	}

	public void setComparator(BiFunction<T, T, Integer> comparator) {
		this.comparator = comparator;
	}
	// code modularity
	BiFunction<T, T, Integer> comparator;
	
	//extra variable for code 
	public int rootIndex = 0;
	public int rightOffset = 2;
	public int leftOffset = 1;
	private int calculateArraySize()
	{
		int n = (2*numberOfInputs)+2;
		return (2*n)+2;
	}
	
	@SuppressWarnings("unchecked")
	public BinaryTree_Array(int MAXSTACK,BiFunction<T, T, Integer> comparatorLambda)
	{
		comparator = comparatorLambda;
		this.numberOfInputs = MAXSTACK;
		calc_MAXSTACK = calculateArraySize();
		this.array = new BinaryTree_Array_Node[calc_MAXSTACK];
	}
	
	@SuppressWarnings("unchecked")
	public BinaryTree_Array(BiFunction<T, T, Integer> comparatorLambda)
	{
		comparator = comparatorLambda;
		calc_MAXSTACK = calculateArraySize();
		this.array = new BinaryTree_Array_Node[calc_MAXSTACK];
	}
	
	@SuppressWarnings("unchecked")
	public BinaryTree_Array(int MAXSTACK)
	{
		comparator = (obj1,obj2) -> castAndCompareTo(obj1,obj2);
		this.numberOfInputs = MAXSTACK;
		calc_MAXSTACK = calculateArraySize();
		this.array = new BinaryTree_Array_Node[calc_MAXSTACK];
	}
	
	@SuppressWarnings("unchecked")
	public BinaryTree_Array()
	{
		comparator = (obj1,obj2) -> castAndCompareTo(obj1,obj2);
		calc_MAXSTACK = calculateArraySize();
		this.array = new BinaryTree_Array_Node[calc_MAXSTACK];
	}
	
	public BinaryTree_Array_Node<T> makeTree(T info)
	{
		array[rootIndex] = new BinaryTree_Array_Node<T>(info);
		return array[rootIndex];
	}
	
	public BinaryTree_Array_Node<T> getRootNode()
	{
		return array[rootIndex];
	}
	
	public int getIndexAtValue(T searchValue)
	{
		int parentIndex = 0;
		while(! array[parentIndex].equals(searchValue))
		{
			parentIndex++;
		}
		return parentIndex;
	}
	public void setRightAtValue(T rightValue,T parentValue)
	{
		//search and find parent index
		setRight(rightValue, getIndexAtValue(parentValue));
		
		
	}
	public void setleftAtValue(T leftValue,T parentValue)
	{
		setLeft(leftValue, getIndexAtValue(parentValue));
	}
	
	public void setRight(T rightValue,int parentIndex)
	{
		// (2 * index) +1
		int newRightIndex = 2 * parentIndex + rightOffset;
		if(newRightIndex > numberOfInputs)
		{
			System.out.println("Cannot insert "+rightValue+" as MAXSTACK is reached "+numberOfInputs);
			return;
		}
		if(array[newRightIndex] == null)
			array[newRightIndex] = new BinaryTree_Array_Node<T>(rightValue);
		else if(! array[newRightIndex].isInUse())
		{
			array[newRightIndex].setInfo(rightValue);
		}
		else
		{
			System.out.println("Cannot insert "+rightValue+" as node is already in use");
		}
	}
	public void setLeft(T leftValue,int parentIndex)
	{
		// (2 * index) +1
				int newLeftIndex = 2 * parentIndex + leftOffset;
				if(newLeftIndex > numberOfInputs)
				{
					System.out.println("Cannot insert "+leftValue+" as MAXSTACK is reached "+numberOfInputs);
					return;
				}
				if(array[newLeftIndex] == null)
					array[newLeftIndex] = new BinaryTree_Array_Node<T>(leftValue);
				else if(! array[newLeftIndex].isInUse())
				{
					array[newLeftIndex].setInfo(leftValue);
				}
				else
				{
					System.out.println("Cannot insert "+leftValue+" as node is already in use");
				}
	}
	
	
	
	
	
	@SuppressWarnings("rawtypes")
	public static Integer castAndCompareTo(Object obj1, Object obj2) {
		if (obj1 != null && obj2 != null) {
			if (obj1.getClass().equals(obj2.getClass())) {
				if (obj1 instanceof String) {
					return ((String) obj1).compareTo((String) obj2);
				}
				Object val1 =obj1 , val2 = obj2;
				if(obj1 instanceof BinaryTree_Array_Node)
				{
					val1 = ((BinaryTree_Array_Node) obj1).getInfo();
					val2 = ((BinaryTree_Array_Node) obj2).getInfo();
				}
				if (val1 instanceof Integer) {
					return ((Integer) val1).compareTo((Integer) val2);
				}

				if (val1 instanceof Character) {
					return ((Character) val1).compareTo((Character) val2);
				}
			}
		}

		return -9;
	}
	
	public String toString()
	{
		return Arrays.toString(array);
	}
	
	public int getNextRightIndex(int currentIndex)
	{
		return (2*currentIndex)+rightOffset;
	}
	
	public int getNextLeftIndex(int currentIndex)
	{
		return (2*currentIndex)+leftOffset;
	}
	
	public StringBuffer inOrderTraversal()
	{
		return new StringBuffer("INORDER -> ").append(inOrderTraversal(rootIndex,new StringBuffer()));
	}
	
	
	public StringBuffer preOrderTraversal()
	{
		return preTraversal(rootIndex, new StringBuffer());
	}
	
	public StringBuffer postOrderTraversal()
	{
		return postTraversal(rootIndex, new StringBuffer());
	}
	
	
	
	public StringBuffer inOrderTraversal(int startWith,StringBuffer sb)
	{
		if(sb == null)
			sb = new StringBuffer();
		if(startWith >= array.length-1)
		{
			return sb;
		}
		// visit left
		inOrderTraversal(getNextLeftIndex(startWith), sb);
		// visit  root
		if(array[startWith] != null && array[startWith].isInUse())
			sb.append( array[startWith].getInfo() +" ," );
		else
		{
			//sb.append( "_" );
		}
			
		// visi  right
		inOrderTraversal(getNextRightIndex(startWith), sb);
		return sb;
	}
	
	
	public StringBuffer preTraversal(int startWith,StringBuffer sb)
	{
		if(sb == null)
			sb = new StringBuffer();
		if(startWith >= array.length-1)
		{
			return sb;
		}
		
		// visit  root
		if(array[startWith] != null && array[startWith].isInUse())
			sb.append( array[startWith].getInfo() +" ," );
		else
		{
			//sb.append( "_" );
		}
		// visit left
		preTraversal(getNextLeftIndex(startWith), sb);

			
		// visi  right
		preTraversal(getNextRightIndex(startWith), sb);
		return sb;
	}
	public StringBuffer postTraversal(int startWith,StringBuffer sb)
	{
		if(sb == null)
			sb = new StringBuffer();
		if(startWith >= array.length-1)
		{
			return sb;
		}
		

		// visit left
		postTraversal(getNextLeftIndex(startWith), sb);

			
		// visi  right
		postTraversal(getNextRightIndex(startWith), sb);
		
		
		// visit  root
		if(array[startWith] != null && array[startWith].isInUse())
			sb.append( array[startWith].getInfo() +" ," );
		else
		{
			//sb.append( "_" );
		}
		return sb;
	}
}
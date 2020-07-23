package dataStructures.gog.ds.trees;

import java.util.function.BiFunction;

public class BinarySearchTree_Array<T> extends BinaryTree_Array<T> {
	
	
	public BinarySearchTree_Array() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTree_Array(BiFunction<T, T, Integer> comparatorLambda) {
		super(comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTree_Array(int MAXSTACK, BiFunction<T, T, Integer> comparatorLambda) {
		super(MAXSTACK, comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTree_Array(int MAXSTACK) {
		super(MAXSTACK);
		// TODO Auto-generated constructor stub
	}

	public int insert(T insertValue)
	{
		int currentIndex = rootIndex;
		Util.PrintUtil.println("Inserting "+insertValue);
		while(currentIndex <= calc_MAXSTACK && array[currentIndex] !=null)
		{
			
			if( comparator.apply(insertValue, array[currentIndex].getInfo()) < 0)
			{
				currentIndex = getNextLeftIndex(currentIndex);
				Util.PrintUtil.println("traversing left to index "+currentIndex);
			}
			else
			{
				currentIndex = getNextRightIndex(currentIndex);
				Util.PrintUtil.println("traversing right to index "+currentIndex);
			}
			
		}
		Util.PrintUtil.println("Inserted "+insertValue+" @index="+currentIndex);
		array[currentIndex] = new BinaryTree_Array_Node<T>(insertValue);
		return currentIndex;
	}
}

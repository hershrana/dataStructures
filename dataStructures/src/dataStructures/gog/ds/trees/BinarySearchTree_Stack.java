package dataStructures.gog.ds.trees;

import java.util.function.BiFunction;

public class BinarySearchTree_Stack<T> extends BinaryTree_Stack<T> {
	
	
	public BinarySearchTree_Stack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTree_Stack(BiFunction<T, T, Integer> comparatorLambda) {
		super(comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTree_Stack(int MAXSTACK, BiFunction<T, T, Integer> comparatorLambda) {
		super(MAXSTACK, comparatorLambda);
		// TODO Auto-generated constructor stub
	}

	public BinarySearchTree_Stack(int MAXSTACK) {
		super(MAXSTACK);
		// TODO Auto-generated constructor stub
	}

	public int insert(T insertValue)
	{
		int currentIndex = rootIndex;
		System.out.println("Inserting "+insertValue);
		while(currentIndex <= numberOfInputs && array[currentIndex] !=null)
		{
			
			if( comparator.apply(insertValue, array[currentIndex].getInfo()) < 0)
			{
				currentIndex = getNextLeftIndex(currentIndex);
				System.out.println("traversing left to index "+currentIndex);
			}
			else
			{
				currentIndex = getNextRightIndex(currentIndex);
				System.out.println("traversing right to index "+currentIndex);
			}
			
		}
		array[currentIndex] = new BinaryTree_Stack_Node<T>(insertValue);
		return currentIndex;
	}
}

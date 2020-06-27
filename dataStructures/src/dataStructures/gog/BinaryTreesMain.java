package dataStructures.gog;

import java.util.function.BiFunction;

//https://www.geeksforgeeks.org/threaded-binary-tree-insertion/
//
public class BinaryTreesMain {
	public static void main(String args[]) throws Exception  {
		// caller class for testing
		
		BinaryTree<Integer> bInt = new BinaryTree<Integer>();
		bInt.insert(20);
		bInt.insert(10);
		bInt.insert(30);
		bInt.insert(5);
		bInt.insert(16);
		bInt.insert(14);
		bInt.insert(17);
		bInt.insert(13);
		
		BinaryTree<Integer> bIntLambda = new BinaryTree<Integer>((Integer a,Integer b) -> a.compareTo(b));
		System.out.println("Lambda Outputs");
		bIntLambda.insert(20);
		bIntLambda.insert(10);
		bIntLambda.insert(30);
		bIntLambda.insert(5);
		bIntLambda.insert(16);
		bIntLambda.insert(14);
		bIntLambda.insert(17);
		bIntLambda.insert(13);
	}
}



class BinaryTree<T> {
	Node<T> rootNode = null;
	BiFunction<T, T, Integer> comparator;
	
	BinaryTree()
	{
		comparator = (obj1,obj2) -> compareTo(obj1,obj2);
	}
	BinaryTree(BiFunction<T, T, Integer> input)
	{
		comparator = input;
	}

	class Node<TV> {
		TV value;
		Node<TV> right, left;

		// True if left pointer points to predecessor
		// in Inorder Traversal
		boolean isRightThreaded;

		// True if right pointer points to predecessor
		// in Inorder Traversal
		boolean isLeftThreaded;
		
		Node (TV initalValue)
		{
			value = initalValue;
			isRightThreaded = true;
			isLeftThreaded = true;
		}
		
		
		public String toString()
		{
			String lc="_",rc="_",rt="n",lt="n";
			if(left!=null)
				lc = String.valueOf(left.value);
			if(right!=null)
				rc = String.valueOf(right.value);
			if(isLeftThreaded)
				lt="y";
			if(isRightThreaded)
				rt="y";
			return "[Nv="+value+" -> {Lc="+lc+",lt-"+lt+",Rc ="+rc+",rt-"+rt+"}]";
		}
		
	}



	public Node<T> insert(T insertValue) throws Exception {
		if(rootNode == null)
		{
			rootNode = new Node<T>(insertValue);
			return rootNode;
		}
		// find parent node where insert is needed
		Node<T> parentNode = null;
		Node<T> currentPointer = rootNode;
		

		int compareOutput;
		while(currentPointer != null)
		{
			parentNode = currentPointer;
			
			//compareOutput = compareTo(insertValue,currentPointer.value);
			compareOutput = comparator.apply(insertValue, currentPointer.value);//(insertValue,currentPointer.value);
			if(compareOutput == 0)
			{
				System.out.println("Duplicate Key -> "+insertValue);
				return currentPointer;
			}
			else if(compareOutput < 0)
			{
				if(! currentPointer.isLeftThreaded )
				{
					currentPointer = currentPointer.left;
				}
				else
					break;
			}
			else
			{
				if(! currentPointer.isRightThreaded)
				{
					currentPointer = currentPointer.right;
				}
				else
					break;
			}
			
		}
		
		// insert and update the pointers
		Node<T> newChildNode = new Node<T>(insertValue);

		
		//if(compareTo(insertValue,parentNode.value) < 0)
		if(comparator.apply(insertValue,parentNode.value) < 0)
		{
			newChildNode.left = parentNode.left;
			parentNode.isLeftThreaded = false;
			newChildNode.right = parentNode;
			// add child node to left of parent
			parentNode.left = newChildNode;
			System.out.println("Add Left  "+parentNode);
			
		}
		else
		{
			newChildNode.right = parentNode.right;
			parentNode.isRightThreaded = false;
			newChildNode.left = parentNode;
			// add child node to right of parent
			parentNode.right = newChildNode;
			System.out.println("Add Right "+parentNode);
		}

		

		return newChildNode;
	}
	
	
	
	public static Integer compareTo(Object obj1, Object obj2) {
		if (obj1 != null && obj2 != null) {
			if (obj1.getClass().equals(obj2.getClass())) {
				if (obj1 instanceof String) {
					return ((String) obj1).compareTo((String) obj2);
				}

				if (obj1 instanceof Integer) {
					return ((Integer) obj1).compareTo((Integer) obj2);
				}

				if (obj1 instanceof Character) {
					return ((Character) obj1).compareTo((Character) obj2);
				}
			}
		}

		return -9;
	}
}
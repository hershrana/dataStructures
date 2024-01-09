package dataStructures.gog.ds.trees;

import java.util.Arrays;

public class AVL_Trees<T> extends BinarySearchTree_Array<T> {
	int rightWeight = -1;
	int leftWight = 1;
	public AVL_Trees(int i) {
		super(i);
	}
	
	public StringBuffer getPrint(int index)
	{
		return new StringBuffer("index -> "+index+" ; value -> "+getInfoAtIndex(index));
	}
	public void copyDownRightSubtree(int index)
	{
		setRight(getInfoAtIndex(index), index,true);
	}
	public void copyDownLeftSubtree(int index)
	{
		setLeft(getInfoAtIndex(index), index,true);
	}
	public void copyValueUpParent(T valueToCopy,int indexOfValueToBePromoted, boolean isLeft)
	{
		if(isValidElement(indexOfValueToBePromoted))
		{
		int copyToParentIndex = getParentIndex(indexOfValueToBePromoted);
		overrideValueAt(valueToCopy, copyToParentIndex);
		
		if(isLeft)
		{
		int calNextLeftChild = getNextLeftIndex(indexOfValueToBePromoted);
		if(isValidElement(calNextLeftChild))
			{
				copyValueUpParent(getInfoAtIndex(calNextLeftChild),calNextLeftChild,isLeft);
			}
			else
			{
				removeElement(indexOfValueToBePromoted);
			}
		}
		else
		{
			int calNextRightChild = getNextRightIndex(indexOfValueToBePromoted);
			if(isValidElement(calNextRightChild))
			{
				copyValueUpParent(getInfoAtIndex(calNextRightChild),calNextRightChild,isLeft);
			}
			else
			{
				removeElement(indexOfValueToBePromoted);
			}
		}
		
		}
		else
		{
			p.o.println("copyUpParent failed as the element is not valid "+getPrint(indexOfValueToBePromoted));
		}
	}
	public boolean balanceNode(int startIndex)
	{
		
		int bF = getBalanceFactor(startIndex);
		p.o.println("starting balancing node "+getPrint(startIndex) );
		p.o.println(" balance factor is "+bF);
		if(bF > -1) // left unbalanced
		{
			// perform right rotation
			rightRotate(startIndex);
			p.o.println("node is left unabalanced hence needs right rotation");
		}
		if(bF < 1) //right unbalanced
		{
			//perform left rotation
			p.o.println("node is right balance hence needs left rotaion");
			leftRotate(startIndex);
		}
		return false;
	}
	public boolean rightRotate(int firstUnabalancedNode)
	{
		if(isValidElement(firstUnabalancedNode))
		{
			//make current index as right child
			T value = getInfoAtIndex(getNextLeftIndex(firstUnabalancedNode));
			copyDownRightSubtree(firstUnabalancedNode);
			//make current left child as parent
			copyValueUpParent(value,firstUnabalancedNode,true);
		}
		return false;
	}
	
	public boolean leftRotate(int firstUnabalancedNode)
	{
		if(isValidElement(firstUnabalancedNode))
		{
			//make current index as right child
			T value = getInfoAtIndex(getNextRightIndex(firstUnabalancedNode));
			copyDownLeftSubtree(firstUnabalancedNode);
			//make current left child as parent
			copyValueUpParent(value,firstUnabalancedNode,false);
		}
		return false;
	}
	public boolean isNodeBalanced(int startIndex)
	{
		int bF = getBalanceFactor(startIndex);
		if(  -1 >= bF && bF  <= 1)
			return true;
		else
			return false;
	}
	public int insert(T insertValue)
	{
		int ret =  super.insert(insertValue);
		p.o.println(getBalanceFactor(ret));
		return ret;
	}
	public int getBalanceFactor (int startIndex)
	{
		int retValue = 0;
		if(! isValidElement(startIndex))
		{
			p.o.println("Invalid element hence returning 0");
			return 0;
		}
		p.o.println("Visiting index "+startIndex+" value "+getInfoAtIndex(startIndex));
		// perfrom inorder traversal
		
		retValue+=  getBalanceFactor(getNextLeftIndex(startIndex));
		
		if(isValidElement(getNextLeftIndex(startIndex)))
			retValue+=leftWight;
		
		if(isValidElement(getNextRightIndex(startIndex)))
			retValue+=rightWeight;
		
		retValue+= getBalanceFactor(getNextRightIndex(startIndex));
		 p.o.println("balance at index "+startIndex+" value  "+getInfoAtIndex(startIndex)+" is "+retValue);
		return retValue;
	}
	
	public static void main(String args[])
	{
		
		//p.o.whiteList(BinaryTree_Array.class );
//		AVL_Trees<Integer> leftUnablancedTree = new AVL_Trees<Integer>(4);
//		Integer leftUnbalancedInput[] = {3,2,1};//{4,3,2,1};//{1,2,3,4};
//		addToTree(leftUnbalancedInput, leftUnablancedTree);
//		
//		p.o.println(Arrays.deepToString(leftUnablancedTree.getArray()));
//		p.o.println(leftUnablancedTree.getBalanceFactor(0));
//		p.o.whiteList();
//		p.o.println("unbalanced tree start "+leftUnablancedTree);
//		p.o.println(leftUnablancedTree.balanceNode(0));
//		p.o.println("unbalanced tree end "+leftUnablancedTree);
//
//		p.o.println(leftUnablancedTree.inOrderTraversal());
//		p.o.println(leftUnablancedTree.getBalanceFactor(0));
		
		
		
		
//		AVL_Trees<Integer> rightUnablancedTree = new AVL_Trees<Integer>(4);
//		Integer rightUnbalancedInput[] = {1,2,3,4};//{4,3,2,1};//{1,2,3,4};
//		addToTree(rightUnbalancedInput, rightUnablancedTree);
//		
//		p.o.println(Arrays.deepToString(rightUnablancedTree.getArray()));
//		p.o.println(rightUnablancedTree.getBalanceFactor(0));
//		p.o.whiteList();
//		p.o.println("unbalanced tree start "+rightUnablancedTree);
//		p.o.deWhiteList();
//		p.o.println(rightUnablancedTree.balanceNode(0));
//		p.o.whiteList();
//		p.o.println("unbalanced tree end "+rightUnablancedTree);
//		p.o.deWhiteList();
//		p.o.println(rightUnablancedTree.inOrderTraversal());
		
		AVL_Trees<Integer> rightUnablancedTree = new AVL_Trees<Integer>(4);
		Integer rightUnbalancedInput[] = {5,3,1};//{4,3,2,1};//{1,2,3,4};
		addToTree(rightUnbalancedInput, rightUnablancedTree);
		
		p.o.println(Arrays.deepToString(rightUnablancedTree.getArray()));
		p.o.println(rightUnablancedTree.getBalanceFactor(0));
		p.o.whiteList();
		p.o.println("unbalanced tree start "+rightUnablancedTree);
		p.o.deWhiteList();
		p.o.println(rightUnablancedTree.balanceNode(0));
		p.o.whiteList();
		p.o.println("unbalanced tree end "+rightUnablancedTree);
		p.o.deWhiteList();
		p.o.println(rightUnablancedTree.inOrderTraversal());
		
	}
	
	public static void addInt(Integer[] arr,AVL_Trees<Integer> bInt)
	{
		int c =0;
		//bInt.setArray(new BinaryTree_Array_Node[]);
		for(int i:arr)
		{
			bInt.getArray()[c++] = new BinaryTree_Array_Node<Integer>(i);
		}
	}
	
	public static void addToTree(Integer[] arr,AVL_Trees<Integer> bInt)
	{
		//bInt.setArray(new BinaryTree_Array_Node[10]);
		for(int i:arr)
		{
			bInt.insert(i);
		}
	}
}

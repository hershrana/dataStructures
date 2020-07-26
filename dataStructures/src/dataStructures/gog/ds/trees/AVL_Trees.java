package dataStructures.gog.ds.trees;

import java.util.Arrays;

public class AVL_Trees<T> extends BinarySearchTree_Array<T> {
	int rightWeight = -1;
	int leftWight = 1;
	public AVL_Trees(int i) {
		super(i);
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
		p.o.whiteList();
		AVL_Trees<Integer> bInt = new AVL_Trees<Integer>(5);
		//p.o.whiteList("dataStructures.gog.ds.trees.BinarySearchTree_Array");
		Integer inp[] = {1,2,3,4};
		addToTree(inp, bInt);
		
		p.o.println(Arrays.deepToString(bInt.getArray()));
		p.o.println(bInt.getBalanceFactor(0));
		p.o.println(bInt.inOrderTraversal());
		;
		
	}
	
	public static void addInt(Integer[] arr,AVL_Trees<Integer> bInt)
	{
		int c =0;
		bInt.setArray(new BinaryTree_Array_Node[arr.length]);
		for(int i:arr)
		{
			bInt.getArray()[c++] = new BinaryTree_Array_Node<Integer>(i);
		}
	}
	
	public static void addToTree(Integer[] arr,AVL_Trees<Integer> bInt)
	{
		bInt.setArray(new BinaryTree_Array_Node[10]);
		for(int i:arr)
		{
			bInt.insert(i);
		}
	}
}

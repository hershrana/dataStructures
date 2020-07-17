package dataStructures.common.interfaces.tree;

import dataStructures.gog.ds.trees.BinaryTree_Array_Node;

public interface BinaryTreeInterface<T> {

	public T getInfoAtIndex(int atIndex);
	public BinaryTree_Array_Node<T> getRootNode();
	public int getIndexAtValue(T searchValue);
	public void setRightAtValue(T rightValue,T parentValue);
	public void setleftAtValue(T leftValue,T parentValue);
	public void setRight(T rightValue,int parentIndex);
	public void setLeft(T leftValue,int parentIndex);
	public StringBuffer inOrderTraversal();
	public StringBuffer preOrderTraversal();
	public StringBuffer postOrderTraversal();
}

package dataStructures.gog.ds.trees;

import dataStructures.common.interfaces.tree.BinaryNode;

public class BinaryTree_Array_Node<T> implements BinaryNode<T>
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
}
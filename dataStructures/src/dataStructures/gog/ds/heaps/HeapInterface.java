package dataStructures.gog.ds.heaps;

import dataStructures.common.interfaces.tree.BinaryNode;
import dataStructures.common.interfaces.tree.BinaryTreeInterface;

public interface HeapInterface<T> extends BinaryTreeInterface<T>{
	public void heapify();
	public boolean isHeap(BinaryNode<T> startWith);
	public BinaryNode<T> createHeap(T newRootNode);
	public boolean addToHeap(T elementToAdd);
	public void setArrayBeforeHeaping(T[] array);
}

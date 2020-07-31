package hersh.dsa.ds.implementations.lists;

import java.util.function.BiFunction;

import hersh.dsa.ds.implementations.lists.nodes.DoublyLinkedList_Node;
import hersh.dsa.ds.implementations.lists.nodes.SinglyLinkedList_Node;
import hersh.dsa.ds.interfaces.AbstractNode;
import hersh.dsa.ds.interfaces.List;

public class DoublyLinkedList<T> implements List<T> {
	DoublyLinkedList_Node<T> head,tail,lastOperated;
	private BiFunction<T, T, Boolean> infoEqualsLambda = (a,b) -> (a.equals(b));
	int elemsSize  = -1;;
	public DoublyLinkedList() {
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public AbstractNode<T> insertAtTail(T info) {
		DoublyLinkedList_Node<T> nodeToBeAdded =  new DoublyLinkedList_Node<T>(info);
		if(tail == null)
		{
			head = nodeToBeAdded;
			tail = nodeToBeAdded;
			lastOperated = nodeToBeAdded;
			elemsSize++;
			return nodeToBeAdded;
		}
		else
		{
			
			nodeToBeAdded.setPrevious(tail);
			tail = nodeToBeAdded;
		}
		return null;
	}

	@Override
	public boolean delete(T info) {
		DoublyLinkedList_Node<T>  temp = head;
		while(temp != null)
		{
			if(infoEqualsLambda.apply(info, temp.getInfo()))
			{
				temp.getPrevious().setNext(temp.getNext());
				temp.getNext().setPrevious(temp.getPrevious());
				lastOperated = temp.getPrevious();
				elemsSize --;
				System.gc();
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public boolean delete(AbstractNode<T> nodeToBeDeleted) {
		if(nodeToBeDeleted != null)
		{
			DoublyLinkedList_Node<T> nodeToBeAddedDLL = (DoublyLinkedList_Node<T>) nodeToBeDeleted;
			nodeToBeAddedDLL.getPrevious().setNext(nodeToBeAddedDLL.getNext());
			nodeToBeAddedDLL.getNext().setPrevious(nodeToBeAddedDLL.getPrevious());
			lastOperated = nodeToBeAddedDLL.getPrevious();
			elemsSize --;
			System.gc();
			return true;
		}
		return false;
	}

	@Override
	public AbstractNode<T> search(T info) {
		DoublyLinkedList_Node<T>  temp = head;
		while(temp != null)
		{
			if(infoEqualsLambda.apply(info, temp.getInfo()))
			{
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	@Override
	public AbstractNode<T> update(T currentInfo, T newInfoToUpdate) {
		 AbstractNode<T>  searchNode = search(currentInfo);
			if(searchNode != null)
			{
				searchNode.setInfo(newInfoToUpdate);
			}
			return searchNode;
	}

	@Override
	public String traverse()
	{
		return traverse(null);
	}
	@Override
	public String traverse(AbstractNode<T> startWithNode) {
		StringBuffer sb = new StringBuffer();
		DoublyLinkedList_Node<T> currentPointer = head;
		if(startWithNode != null)
			currentPointer = (DoublyLinkedList_Node<T>) startWithNode;
		while(currentPointer != null)
		{
			sb.append(" "+currentPointer.getInfo()+" ,");
			currentPointer = currentPointer.getNext();
		}
	  return 	sb.deleteCharAt(sb.length()-1).toString();
	}

	@Override
	public AbstractNode<T> getHead() {
		return head;
	}

	@Override
	public BiFunction<T, T, Boolean> getInfoEqualsLambda() {
		// TODO Auto-generated method stub
		return infoEqualsLambda;
	}

	@Override
	public void setInfoEqualsLambda(BiFunction<T, T, Boolean> infoEqualsLambda) {
		this.infoEqualsLambda =  infoEqualsLambda;
		
	}

	@Override
	public T[] getArrayReprensentation() {
		T[] tempArr = (T[]) new Object[elemsSize];
		DoublyLinkedList_Node<T> temp = head;
		int count = 0;
		while(temp!=null)
		{
			tempArr[count++] = temp.getInfo();
			temp = temp.getNext();
		}
		return tempArr;
	}

	@Override
	public AbstractNode<T> insertAfterValue(T addAfterInfo, T infoToAdd) {
		DoublyLinkedList_Node<T> searched = (DoublyLinkedList_Node<T>) search(addAfterInfo);
		DoublyLinkedList_Node<T> toAdd = new DoublyLinkedList_Node<T>(infoToAdd);
		if(searched !=null)
		{
			toAdd.setPrevious(searched);
			toAdd.setNext(searched.getNext());
			searched.getNext().setPrevious(toAdd);
			searched.setNext(toAdd);
			elemsSize++;
			lastOperated = toAdd;
			return toAdd;
		}
		return null;
	}

}

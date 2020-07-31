package hersh.dsa.ds.implementations.lists;

import java.util.function.BiFunction;

import hersh.dsa.ds.driver.DS_Driver_Main;
import hersh.dsa.ds.implementations.lists.nodes.SinglyLinkedList_Node;
import hersh.dsa.ds.interfaces.AbstractNode;
import hersh.dsa.ds.interfaces.List;

public class SinglyLinkedList<T> implements List<T>{
	protected  SinglyLinkedList_Node<T> rootNode;
	private  SinglyLinkedList_Node<T> tailNode, currentPointer;
	private BiFunction<T, T, Boolean> infoEqualsLambda = (a,b) -> (a.equals(b));
	private int totalElements = 0;
	@Override
	public AbstractNode<T> insertAtTail(T info) {
		SinglyLinkedList_Node<T> nodeToBeAdded = new SinglyLinkedList_Node<T>(info);
		if(rootNode!= null)
		{
			tailNode.setNext(nodeToBeAdded);
			tailNode = nodeToBeAdded;
		}
		else
		{
			rootNode = nodeToBeAdded;
			tailNode =  nodeToBeAdded;
		}
		totalElements ++;
		return nodeToBeAdded;
	}
	
	@Override
	public AbstractNode<T> insertAfterValue(T addAfterInfo , T infoToAdd) {
		SinglyLinkedList_Node<T> indexWithValue = (SinglyLinkedList_Node<T>) search(addAfterInfo);
		if(indexWithValue!= null)
		{
			totalElements ++;
			SinglyLinkedList_Node<T> toAdd = new SinglyLinkedList_Node<T>(infoToAdd);
			toAdd.setNext(indexWithValue.getNext());
			indexWithValue.setNext(toAdd);
			return toAdd;
		}
		
		return null;
	}

	@Override
	public boolean delete(T info) {
		if(rootNode == null)
		{
			p.o.println("root node is null , built ll using insert api");
			return false;
		}
		 SinglyLinkedList_Node<T> previousNode =null;
		 currentPointer = rootNode;
		 
		 if(infoEqualsLambda.apply(info, rootNode.getInfo()))
		 {
				p.o.println("root node is being deleted");
				rootNode = rootNode.getNext();
				totalElements--;
				return true;
		 }
		while(currentPointer != null)
		{
			if(infoEqualsLambda.apply(info, currentPointer.getInfo()) )
			{
				// delete curent node after taking care of pointers
				if(SinglyLinkedList_Node.abstractNodeEqualsLambda.apply(tailNode, currentPointer))
				{
					p.o.println("tail node is getting deleted");
					tailNode = previousNode;
				}
				previousNode.setNext(currentPointer.getNext());
				totalElements --;
				System.gc(); // request to collect grabage
				return true;
			}
			else
			{
				previousNode = currentPointer;
				currentPointer = currentPointer.getNext();
			}
		}
		return false;
	}

	@Override
	public boolean delete(AbstractNode<T> nodeToBeDeleted) {
		if(rootNode == null)
		{
			p.o.println("root node is null , built ll using insert api");
			return false;
		}
		SinglyLinkedList_Node<T> previousNode =null;
		currentPointer = rootNode;
		 if(SinglyLinkedList_Node.abstractNodeEqualsLambda.apply(nodeToBeDeleted, currentPointer) )
		 {
				p.o.println("root node is being deleted");
				rootNode = rootNode.getNext();
				totalElements--;
				return true;
		 }
		while(currentPointer != null)
		{
			if(SinglyLinkedList_Node.abstractNodeEqualsLambda.apply(nodeToBeDeleted, currentPointer) )
			{
				// delete curent node after taking care of pointers
				if(SinglyLinkedList_Node.abstractNodeEqualsLambda.apply(tailNode, currentPointer))
				{
					p.o.println("tail node is getting deleted");
					tailNode = previousNode;
				}
				previousNode.setNext(currentPointer.getNext());
				totalElements --;
				System.gc(); // request to collect grabage
				return true;
			}
			else
			{
				previousNode = currentPointer;
				currentPointer = currentPointer.getNext();
			}
		}
		return false;
	}

	@Override
	public AbstractNode<T> search(T info) {
		currentPointer = rootNode;
		while(currentPointer.getNext() != null)
		{
			if(infoEqualsLambda.apply(info, currentPointer.getInfo()) )
			{
				return currentPointer;
			}
			else
			{
				currentPointer = currentPointer.getNext();
			}
		}
		return null;
	}

	@Override
	public String traverse()
	{
		return traverse(null);
	}
	@Override
	public String traverse(AbstractNode<T> startWithNode) {
		StringBuffer sb = new StringBuffer();
		if(startWithNode != null)
			currentPointer = (SinglyLinkedList_Node<T>) startWithNode;
		else 
			currentPointer = rootNode;
		while(currentPointer != null)
		{
			sb.append(" "+currentPointer.getInfo()+" ,");
			currentPointer = currentPointer.getNext();
		}
	  return 	sb.deleteCharAt(sb.length()-1).toString();
	}
	
	@Override
	public AbstractNode<T> update(T currentInfo,T newInfoToUpdate) {
		 AbstractNode<T>  searchNode = search(currentInfo);
		if(searchNode != null)
		{
			searchNode.setInfo(newInfoToUpdate);
			return searchNode;
		}
	  return 	null;
	}
	
	@Override
	public T[] getArrayReprensentation() {
		Object[] retArrat = new Object[totalElements];
		int counter = 0;
		while(currentPointer.getNext() != null)
		{
			retArrat[counter ++] = currentPointer.getInfo();
		}
		
		return (T[]) retArrat;
	}

	@Override
	public AbstractNode<T> getHead() {
		return (AbstractNode<T>) rootNode;
	}

	public SinglyLinkedList_Node<T> getCurrentPointer() {
		return currentPointer;
	}

	public SinglyLinkedList_Node<T> getTailNode() {
		return tailNode;
	}
@Override
	public BiFunction<T, T, Boolean> getInfoEqualsLambda() {
		return infoEqualsLambda;
	}
	@Override
	public void setInfoEqualsLambda(BiFunction<T, T, Boolean> equalsLambda) {
		this.infoEqualsLambda = equalsLambda;
	}

	public String toString()
	{
		return traverse();
	}
	public static void main(String args[])
	{
		p.o.whiteList();
		DS_Driver_Main.main(args);
	}
}

package hersh.dsa.ds.implementations.lists;

import java.util.function.BiFunction;

import hersh.dsa.ds.implementations.lists.nodes.SinglyLinkedList_Node;
import hersh.dsa.ds.interfaces.AbstractNode;
import hersh.dsa.ds.interfaces.List;

public class SinglyLinkedList<T> implements List<T>{
	protected  SinglyLinkedList_Node<T> rootNode;
	private  SinglyLinkedList_Node<T> lastInsertedAtNode, currentPointer;
	private BiFunction<T, T, Boolean> equalsLambda = (a,b) -> (a.equals(b));
	private int totalElements = 0;
	@Override
	public AbstractNode<T> insert(T info) {
		SinglyLinkedList_Node<T> nodeToBeAdded = new SinglyLinkedList_Node<T>(info);
		if(rootNode!= null)
		{
			lastInsertedAtNode.setNext(nodeToBeAdded);
			lastInsertedAtNode = nodeToBeAdded;
		}
		else
		{
			rootNode = nodeToBeAdded;
			lastInsertedAtNode =  nodeToBeAdded;
		}
		totalElements ++;
		return nodeToBeAdded;
	}

	@Override
	public boolean delete(T info) {
		 SinglyLinkedList_Node<T> previousNode =null;
		while(currentPointer.getNext() != null)
		{
			if(equalsLambda.apply(info, currentPointer.getInfo()) )
			{
				// delete curent node after taking care of pointers
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
		SinglyLinkedList_Node<T> previousNode =null;
		while(currentPointer.getNext() != null)
		{
			if(SinglyLinkedList_Node.abstractNodeEqualsLambda.apply(nodeToBeDeleted, currentPointer) )
			{
				// delete curent node after taking care of pointers
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
			if(equalsLambda.apply(info, currentPointer.getInfo()) )
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
	public String traverse(AbstractNode<T> startWithNode) {
		StringBuffer sb = new StringBuffer();
		while(currentPointer.getNext() != null)
		{
			sb.append(" "+currentPointer.getInfo()+" ,");
			currentPointer = currentPointer.getNext();
		}
	  return 	sb.deleteCharAt(sb.length()).toString();
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

	@SuppressWarnings("unchecked")
	@Override
	public AbstractNode<T> getRootNode() {
		return (AbstractNode<T>) rootNode;
	}

	public SinglyLinkedList_Node<T> getCurrentPointer() {
		return currentPointer;
	}

	public SinglyLinkedList_Node<T> getLastInsertedAtNode() {
		return lastInsertedAtNode;
	}
@Override
	public BiFunction<T, T, Boolean> getEqualsLambda() {
		return equalsLambda;
	}
	@Override
	public void setEqualsLambda(BiFunction<T, T, Boolean> equalsLambda) {
		this.equalsLambda = equalsLambda;
	}

}

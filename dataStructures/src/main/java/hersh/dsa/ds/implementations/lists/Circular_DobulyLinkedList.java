package hersh.dsa.ds.implementations.lists;

import java.util.function.BiFunction;
import hersh.dsa.ds.implementations.lists.nodes.DoublyLinkedList_Node;
import hersh.dsa.ds.interfaces.AbstractNode;

public class Circular_DobulyLinkedList<T> extends DoublyLinkedList<T>{

	@Override
	public AbstractNode<T> insertAtTail(T info) {
		// TODO Auto-generated method stub
		p.o.println("Method not supported");
		return null;
		//return super.insertAtTail(info);
	}
	
	public AbstractNode<T> insert(T info) {
		boolean headOperation = false;
		if(head == null)
		{
			headOperation = true;
		}
		AbstractNode<T> ret = super.insertAtTail(info);
		if(headOperation)
		{
			head.setPrevious(tail);
			tail.setNext(head);
		}
		return ret;
	}

	@Override
	public boolean delete(T info) {
		// TODO Auto-generated method stub
		return super.delete(info);
	}

	@Override
	public boolean delete(AbstractNode<T> nodeToBeDeleted) {
		// TODO Auto-generated method stub
		return super.delete(nodeToBeDeleted);
	}

	@Override
	public AbstractNode<T> search(T info) {
		DoublyLinkedList_Node<T> t = head;
		do
		{
			if(getInfoEqualsLambda().apply(info, t.getInfo()))
				return t;
			t = t.getNext();
		}while (t!= null && ! getInfoEqualsLambda().apply(t.getInfo(), head.getInfo()));
		return null;
	}

	@Override
	public AbstractNode<T> update(T currentInfo, T newInfoToUpdate) {
		// TODO Auto-generated method stub
		return super.update(currentInfo, newInfoToUpdate);
	}

	@Override
	public String traverse() {
		// TODO Auto-generated method stub
		return super.traverse();
	}

	@Override
	public String traverse(AbstractNode<T> startWithNode) {
		// TODO Auto-generated method stub
		return super.traverse(startWithNode);
	}

	@Override
	public AbstractNode<T> getHead() {
		// TODO Auto-generated method stub
		return super.getHead();
	}

	@Override
	public BiFunction<T, T, Boolean> getInfoEqualsLambda() {
		// TODO Auto-generated method stub
		return super.getInfoEqualsLambda();
	}

	@Override
	public void setInfoEqualsLambda(BiFunction<T, T, Boolean> infoEqualsLambda) {
		// TODO Auto-generated method stub
		super.setInfoEqualsLambda(infoEqualsLambda);
	}

	@Override
	public T[] getArrayReprensentation() {
		// TODO Auto-generated method stub
		return super.getArrayReprensentation();
	}

	@Override
	public AbstractNode<T> insertAfterValue(T addAfterInfo, T infoToAdd) {
		// TODO Auto-generated method stub
		
		return super.insertAfterValue(addAfterInfo, infoToAdd);
	}

	public Circular_DobulyLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	public void adjustHeadTailCircular()
	{
		
	}

}

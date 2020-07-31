package hersh.dsa.ds.implementations.lists.nodes;

import hersh.dsa.ds.interfaces.AbstractNode;

public abstract class LinkedList_Node<T> implements AbstractNode<T> {
	T info =null;
	LinkedList_Node<T>  next = null;
	public LinkedList_Node<T> getNext() {
		return next;
	}
	public void setNext(LinkedList_Node<T> next) {
		this.next = next;
	}
	public LinkedList_Node() {
		super();
	}
	public LinkedList_Node(T info) {
		super();
		this.info = info;
	}

	@Override
	public T getInfo() {
		return info;
	}

	@Override
	public void setInfo(T info) {
		this.info = info;
	}

	@Override
	public int getHashCode() {
		return info.hashCode();
	}

	@Override
	public int getSecondHashCode() {		
		return Integer.valueOf(info.hashCode()).hashCode();
	}

	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		return result;
	}
	*/
	/*
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedList_Node<T> other = (LinkedList_Node<T>) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(next.info))
			return false;
		return true;
	} */
	
	@Override
	public String toString()
	{
		return info.toString();
	}
}

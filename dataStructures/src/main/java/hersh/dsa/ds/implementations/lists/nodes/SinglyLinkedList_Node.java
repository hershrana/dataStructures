package hersh.dsa.ds.implementations.lists.nodes;

public class SinglyLinkedList_Node<T> extends LinkedList_Node<T> {

	public SinglyLinkedList_Node(T info) {
	 super(info);
	}
	public SinglyLinkedList_Node() {
		}
	public SinglyLinkedList_Node<T> getNext() {
		return (SinglyLinkedList_Node<T>) next;
	}
	public void setNext(SinglyLinkedList_Node<T> next) {
		this.next = next;
	}
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
	} 
}

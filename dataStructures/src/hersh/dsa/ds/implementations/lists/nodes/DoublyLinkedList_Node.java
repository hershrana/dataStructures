/**
 * 
 */
package hersh.dsa.ds.implementations.lists.nodes;

/**
 * @author hbrana
 *
 */
public class DoublyLinkedList_Node<T> extends LinkedList_Node<T> {
	DoublyLinkedList_Node<T> previous,next;


	public DoublyLinkedList_Node<T> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedList_Node<T> next) {
		this.next = next;
	}

	public DoublyLinkedList_Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedList_Node<T> previous) {
		this.previous = previous;
	}

	public DoublyLinkedList_Node(T info) {
		super(info);
	}
	public DoublyLinkedList_Node() {
		super();
	}
	
}

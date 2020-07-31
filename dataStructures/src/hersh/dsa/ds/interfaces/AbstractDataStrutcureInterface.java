package hersh.dsa.ds.interfaces;

public interface AbstractDataStrutcureInterface<T> {
	public AbstractNode<T> insertAtTail(T info);
	public boolean delete(T info);
	public boolean delete(AbstractNode<T> nodeToBeDeleted);
	public AbstractNode<T> search(T info);
	public String traverse (AbstractNode<T> startWithNode);
	AbstractNode<T> update(T currentInfo, T newInfoToUpdate);
	String traverse();
	AbstractNode<T> getHead();
}

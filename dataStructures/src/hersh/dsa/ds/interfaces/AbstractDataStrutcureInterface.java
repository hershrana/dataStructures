package hersh.dsa.ds.interfaces;

public interface AbstractDataStrutcureInterface<T> {
	public AbstractNode<T> insert(T info);
	public boolean delete(T info);
	public boolean delete(AbstractNode<T> nodeToBeDeleted);
	public AbstractNode<T> search(T info);
	public String traverse (AbstractNode<T> startWithNode);
}
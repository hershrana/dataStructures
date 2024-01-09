package dataStructures.common.interfaces.tree;

public interface BinaryNode<T> {

	boolean inUse =false;
	public T getInfo() ;
	public void setInfo(T info);
	public boolean isInUse() ;
	
}

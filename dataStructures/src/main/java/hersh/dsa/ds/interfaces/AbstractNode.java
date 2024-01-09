package hersh.dsa.ds.interfaces;

import java.util.function.BiFunction;

public interface AbstractNode<T> {
	public T getInfo();
	public void setInfo(T info);
	public int getHashCode();
	public int getSecondHashCode();
	public BiFunction<AbstractNode, AbstractNode, Boolean> abstractNodeEqualsLambda = (a,b) -> (a.equals(b));
}

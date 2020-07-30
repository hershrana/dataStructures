package hersh.dsa.ds.interfaces;

import java.util.function.BiFunction;

public interface List<T> extends  AbstractDataStrutcureInterface<T> {
	public AbstractNode<T> getRootNode();
	public BiFunction<T, T, Boolean> getEqualsLambda() ;
	public void setEqualsLambda(BiFunction<T, T, Boolean> equalsLambda);
	public T[] getArrayReprensentation();
}

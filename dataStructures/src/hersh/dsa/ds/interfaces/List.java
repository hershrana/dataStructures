package hersh.dsa.ds.interfaces;

import java.util.function.BiFunction;

public interface List<T> extends  AbstractDataStrutcureInterface<T> {
	public AbstractNode<T> getHead();
	public BiFunction<T, T, Boolean> getInfoEqualsLambda() ;
	public void setInfoEqualsLambda(BiFunction<T, T, Boolean> infoEqualsLambda);
	public T[] getArrayReprensentation();
	AbstractNode<T> insertAfterValue(T addAfterInfo, T infoToAdd);
}

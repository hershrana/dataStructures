package dataStructures.gog.searching;

import java.util.function.BiFunction;

public class BinarySearch<T> implements Search<T> {
	BiFunction<? extends Object, ? extends Object, Integer> compareLambda;
	public BiFunction<? extends Object, ? extends Object, Integer>  getCompareLambda() {
		return compareLambda;
	}

	public void setCompareLambda(BiFunction<? extends Object, ? extends Object, Integer>  compareLambda) {
		this.compareLambda = compareLambda;
	}
	
	public BinarySearch(BiFunction<? extends Object, ? extends Object, Integer>  compareLambda) {
		super();
		this.compareLambda = compareLambda;
	}
	public BinarySearch() {
		super();
		this.compareLambda = p.u.castAndCompareToLambda;
	}
	@Override
	public int search(T searchFor, T[] input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object searchAndReturn(T searchFor, T[] input) {
		// TODO Auto-generated method stub
		return null;
	}

}

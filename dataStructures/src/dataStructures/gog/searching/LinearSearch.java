package dataStructures.gog.searching;

import java.util.function.BiFunction;

public class LinearSearch<T>  implements Search<T>{
	BiFunction<T, T, Boolean> comparator;

	
	public BiFunction<T, T, Boolean> getComparator() {
		return comparator;
	}

	public void setComparator(BiFunction<T, T, Boolean> comparator) {
		this.comparator = comparator;
	}

	
	public LinearSearch(BiFunction<T, T, Boolean> comparator) {
		super();
		this.comparator = comparator;
	}
	
	public LinearSearch() {
		super();
		this.comparator = (a,b) -> a.equals(b);
	}

	@Override
	public int search(T searchFor, T[] input) {
			// TODO Auto-generated method stub
		int index = 0;
		for( ; index < input.length ; index++)
		{
			if(comparator.apply(searchFor, input[index]))
				return index;
		}
		return -1;
	}

	@Override
	public Object searchAndReturn(T searchFor , T[] input) {
		// TODO Auto-generated method stub
		for(T ele : input)
			if(comparator.apply(searchFor, ele)) return ele;
		return null;
	}

}

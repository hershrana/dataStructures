package dataStructures.gog.searching;

import java.util.function.BiFunction;

public class LinearSearch<T>  implements Search<T>{
	BiFunction<T, T, Boolean> isEqualLambda;

	
	public BiFunction<T, T, Boolean> getisEqualLambda() {
		return isEqualLambda;
	}

	public void setisEqualLambda(BiFunction<T, T, Boolean> isEqualLambda) {
		this.isEqualLambda = isEqualLambda;
	}

	
	public LinearSearch(BiFunction<T, T, Boolean> isEqualLambda) {
		super();
		this.isEqualLambda = isEqualLambda;
	}
	
	public LinearSearch() {
		super();
		this.isEqualLambda = (a,b) -> a.equals(b);
	}

	@Override
	public int search(T searchFor, T[] input) {
			// TODO Auto-generated method stub
		int index = 0;
		for( ; index < input.length ; index++)
		{
			if(isEqualLambda.apply(searchFor, input[index]))
				return index;
		}
		return -1;
	}

	@Override
	public Object searchAndReturn(T searchFor , T[] input) {
		// TODO Auto-generated method stub
		for(T ele : input)
			if(isEqualLambda.apply(searchFor, ele)) return ele;
		return null;
	}

}

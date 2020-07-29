package dataStructures.gog.searching;

import java.util.function.BiFunction;

public class MainSearchDriverProgram {
public static void main(String argrs[])
{
	Integer[] inputs = {3,5,7,12,15,33,98};
	BiFunction<Integer, Integer, Boolean> intIsEqual = (a,b) -> (a.equals(b));
	linearSearch(inputs, intIsEqual);
	
}

static void linearSearch(Integer[] inputs,BiFunction<Integer, Integer, Boolean> isEqualLambda)
{
	p.o.whiteList();
	p.o.println("Sample linear search");
	Search<Integer> linearSearch = new LinearSearch<Integer>(isEqualLambda);
	p.o.println("Searching 12 found at index -> "+linearSearch.search(12, inputs));
	
	p.o.println("Searching 12 found at value -> "+linearSearch.searchAndReturn(12, inputs)); 
	
	p.o.deWhiteList();
}
}

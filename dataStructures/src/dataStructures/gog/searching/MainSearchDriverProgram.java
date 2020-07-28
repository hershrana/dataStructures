package dataStructures.gog.searching;

import java.util.function.BiFunction;

public class MainSearchDriverProgram {
public static void main(String argrs[])
{
	Integer[] inputs = {3,5,7,12,15,33,98};
	BiFunction<Integer, Integer, Boolean> intCompare = (a,b) -> (a.equals(b));
	linearSrearchEx(inputs, intCompare);
	
}

static void linearSrearchEx(Integer[] inputs,BiFunction<Integer, Integer, Boolean> intCompare)
{
	p.o.whiteList();
	p.o.println("Sample linear search");
	Search<Integer> linearSearch = new LinearSearch<Integer>(intCompare);
	p.o.println("Searching 12 found at index -> "+linearSearch.search(12, inputs));
	
	p.o.println("Searching 12 found at value -> "+linearSearch.searchAndReturn(12, inputs)); 
	
	p.o.deWhiteList();
}
}

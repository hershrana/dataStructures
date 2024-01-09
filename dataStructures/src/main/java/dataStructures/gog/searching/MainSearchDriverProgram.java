package dataStructures.gog.searching;

public class MainSearchDriverProgram {
public static void main(String argrs[])
{
	Integer[] inputs = {100,3,5,7,12,15,33,98,55};
	int searchElement = inputs[inputs.length-1];
	binarySearch(inputs,searchElement);
	linearSearch(inputs, searchElement);
	
}

static void binarySearch(Integer[] inputs, Integer searchElement)
{
	p.o.whiteList();
	p.o.println("Binary Search example");
	Search<Integer> binarySearch = new BinarySearch<Integer>((a,b) -> a.compareTo(b));
	p.o.whiteList(binarySearch.getClass());
	p.o.println("Searching "+searchElement+" found at value -> "+binarySearch.searchAndReturn(searchElement, inputs)); 
}

static void linearSearch(Integer[] inputs,Integer searchElement)
{
	p.o.whiteList();
	p.o.println("Sample linear search");
	Search<Integer> linearSearch = new LinearSearch<Integer>((a,b) -> a.equals(b));
	p.o.println("Searching "+searchElement+" found at index -> "+linearSearch.search(searchElement, inputs));
	
	p.o.println("Searching "+searchElement+" found at value -> "+linearSearch.searchAndReturn(searchElement, inputs)); 
	
	p.o.deWhiteList();
}
}

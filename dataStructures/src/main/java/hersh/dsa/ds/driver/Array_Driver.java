package hersh.dsa.ds.driver;

import hersh.dsa.ds.implementations.array.Array;

public class Array_Driver {
	public static void main(String args[])
	{
		arrayTest(10);
		
	}
	public static Object[] arrayTest(int max)
	{
		Array<Integer> arrayInt = new Array<Integer>(max);
		p.o.whiteList();
		p.o.whiteList(arrayInt.getClass());
		p.o.println("Int array created with size "+max);
		Integer[] testData = p.u.getRandomIntegerArray(max, max*100);
		for(int i : testData)
			arrayInt.autoAdd(i);
		p.o.println("Arrary created with "+arrayInt);
		
		testData = p.u.getRandomIntegerArray(20, max*100);
		for(int i : testData)
			arrayInt.autoAdd(i);
		p.o.println("Arrary with more elements added "+arrayInt);
		return arrayInt.getArray();
	}
}

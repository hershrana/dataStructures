package p;

import java.util.Calendar;
import java.util.function.BiFunction;

import dataStructures.gog.ds.trees.BinaryTree_Array_Node;

public class u {
	
public static BiFunction< Object, Object, Integer> castAndCompareToLambda = (a , b) -> castAndCompareTo(a, b);
 public static String isSorted(Integer[] check)
 {
	StringBuffer sb = new StringBuffer();
 	for(int j = 1 ; j < check.length ; j++)
 	{
 		if(check[j] < check[j-1])
 			sb.append((j-1)).append(" , ");
 	}
 	if(sb.length() == 0)
 		sb.append("true");
 	return sb.toString();
 }
 
	@SuppressWarnings("rawtypes")
	public static Integer castAndCompareTo(Object obj1, Object obj2) {
		if (obj1 != null && obj2 != null) {
			if (obj1.getClass().equals(obj2.getClass())) {
				if (obj1 instanceof String) {
					return ((String) obj1).compareTo((String) obj2);
				}
				Object val1 =obj1 , val2 = obj2;
				if(obj1 instanceof BinaryTree_Array_Node)
				{
					val1 = ((BinaryTree_Array_Node) obj1).getInfo();
					val2 = ((BinaryTree_Array_Node) obj2).getInfo();
				}
				if (val1 instanceof Integer) {
					return ((Integer) val1).compareTo((Integer) val2);
				}

				if (val1 instanceof Character) {
					return ((Character) val1).compareTo((Character) val2);
				}
			}
		}

		return 0;
	}
	
	public static int timeBaseRandomNumber (int numOfDigits)
	{
		long timeInMs = Calendar.getInstance().getTimeInMillis();
		StringBuffer sb = new StringBuffer("1");
		for(int i = 1 ; i < numOfDigits ; i++)
			sb.append("0");
		int modulo = Integer.valueOf(sb.toString());
		return (int)timeInMs%modulo;
	}
	
	public static int getRandomIntegerBetweenRange(int min, int max){
	    Double x = (Math.random()*((max-min)+1))+min;
	    return x.intValue();
	}
	
	public static int getRandomIntegerMaxRange(int max){
		int min = 0;
	    Double x = (Math.random()*((max-min)+1))+min;
	    return x.intValue();
	}
	
	
	public static Integer[] getRandomIntegerArray(int size, int max){
	 Integer[] array = new Integer[size];
	 for(int i=0 ; i < size ;i ++)
		 array[i] = p.u.getRandomIntegerMaxRange(max);
	 return array;
	}
}

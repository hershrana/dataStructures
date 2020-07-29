package p;

import java.util.function.BiFunction;

import dataStructures.gog.ds.trees.BinaryTree_Array_Node;

public class u {
	
public static BiFunction< ? extends Object, ? extends Object, Integer> castAndCompareToLambda = (a , b) -> castAndCompareTo(a, b);
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
}

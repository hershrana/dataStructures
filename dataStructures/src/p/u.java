package p;

public class u {
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
}

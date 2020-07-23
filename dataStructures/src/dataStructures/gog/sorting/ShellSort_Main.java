package dataStructures.gog.sorting;

import java.util.Arrays;

import Util.PrintUtil;


public class ShellSort_Main {
 //driver code
	public static void main(String [] args)
	{
		PrintUtil.whiteList();
		int[] inputs = {35, 14,33, 19,42, 27,10, 44,1};
		new ShellSort_Main().sort(inputs);
		PrintUtil.blackList();
		PrintUtil.println(Arrays.toString(inputs));
	}
	
	public void sort(int[] inputs)
	{
		int temp;
		// get a large gap mostly length of array/2 next iteration of gap is gap /2
		for(int gap = inputs.length/2 ; gap >= 1 ; gap /=2)
		{
			for(int inner = gap ; inner < inputs.length ; inner+=gap)
			{
				PrintUtil.println("gap->"+gap+" inner->"+inner);
				 temp = inputs[inner];
//				if(inputs[inner] > inputs[inner+gap])
//				{
//					//swap
//					temp = inputs[inner];
//					inputs[inner] = inputs[inner+gap] ;
//					inputs[inner+gap] =  temp;
//				}
			}
		}
		
	}
	
}

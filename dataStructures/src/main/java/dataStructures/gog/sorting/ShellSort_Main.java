package dataStructures.gog.sorting;

import java.util.Arrays;

import p.o;
import p.u;

public class ShellSort_Main {
	// driver code
	public static void main(String[] args) {
		o.whiteList();
		Integer[] inputs = { 35, 14, 33, 19, 42, 27, 10, 44, 1 };
		o.println(u.isSorted(inputs));
		new ShellSort_Main().sort(inputs);
		o.println(Arrays.toString(inputs));
		o.println(u.isSorted(inputs));
	}

	public void sort(Integer[] inputs) {
		o.println("Sort started               " + Arrays.toString(inputs));
		int temp;

		for (int gap = inputs.length / 2; gap > 0; gap /= 2) {
			o.println("New gap " + gap);
			for (int forwardCounter = gap; forwardCounter < inputs.length; forwardCounter++) {
				temp = inputs[forwardCounter];
				int reverseCounter;
				for (reverseCounter = forwardCounter; reverseCounter >= gap && inputs[reverseCounter-gap] > temp; reverseCounter -= gap)  // create hole
				{
						inputs[reverseCounter] = inputs[reverseCounter-gap];
						o.println("reverseCounter loop forwardCounter "+forwardCounter+" Reverse COunter"+reverseCounter+" "+Arrays.toString(inputs));
				}
					
					inputs[reverseCounter] = temp;
				
			}
		}
	}

}

package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;

public class SelectionSort {
	public static void selectionSort(ListADT<Integer> input) {
		for (int i = 0; i < input.size() - 1; i++) {
			int toSwap = findMin(input, i);
			input.swap(toSwap, i);
		}
	} 
	
	public static int findMin(ListADT<Integer> input, int start) {
		int min = input.getIndex(start);
		int index = start;
		for (int i = start + 1; i < input.size(); i++) {
			int compare = input.getIndex(i);
			if (min > compare) {
				min = compare;
				index = i;
			}
		}
		return index;
	}
}

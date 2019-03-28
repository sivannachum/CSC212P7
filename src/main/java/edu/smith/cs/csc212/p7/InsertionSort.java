package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

/**
 * Sort by making a new list, taking elements from the original list and placing them
 * in a sorted position in the new list one by one.
 * @author sivan
 *
 */
public class InsertionSort {
	public static ListADT<Integer> insertionSort(ListADT<Integer> input){
		ListADT<Integer> toReturn = new JavaList<>();
		for (int i = 0; i < input.size(); i++) {
			insertSorted(toReturn, input.getIndex(i));
		}
		return toReturn;
	}
	
	public static void insertSorted(ListADT<Integer> into, int value) {
		int index = -1;
		for (int i = 0; i < into.size(); i++) {
			if (value <= into.getIndex(i)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			into.addBack(value);
		}
		else {
			into.addIndex(index, value);
		}
	}
}

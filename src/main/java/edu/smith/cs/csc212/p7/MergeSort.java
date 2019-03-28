package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;

/**
 * Sort by breaking the input into smaller and smaller pieces until they are sorted (1 element).
 * Then combine the sorted pieces.
 * @author sivan
 *
 */
public class MergeSort {
	public static ListADT<Integer> mergeSortRecursive(ListADT<Integer> input){
		int size = input.size();
		if (size < 2) {
			return input;
		}
		int mid = size/2;
		ListADT<Integer> left = input.slice(0, mid);
		ListADT<Integer> right = input.slice(mid, size);
		left = mergeSortRecursive(left);
		right = mergeSortRecursive(right);
		return combine(left, right);
	}
	
	public static ListADT<Integer> mergeSortIterative(ListADT<Integer> input){
		DoublyLinkedList<ListADT<Integer>> queue = new DoublyLinkedList<ListADT<Integer>>();
		for (int i = 0; i < input.size(); i++) {
			ListADT<Integer> another = new JavaList<Integer>();
			another.addFront(input.getIndex(i));
			queue.addBack(another);
			
		}
		ListADT<Integer> curr = new JavaList<>();
		ListADT<Integer> next;
		while (!queue.isEmpty()) {
			curr = queue.removeFront();
			if (queue.isEmpty()) {
				break;
			}
			next = queue.removeFront();
			queue.addBack(combine(curr, next));
		}
		return curr;
	}
	
	public static ListADT<Integer> combine(ListADT<Integer> left, ListADT<Integer> right){
		int i = 0;
		int j = 0;
		int leftSize = left.size();
		int rightSize = right.size();
		ListADT<Integer> toReturn = new JavaList<>();
		while (i < leftSize && j < rightSize) {
			int leftContender = left.getIndex(i);
			int rightContender = right.getIndex(j);
			if (leftContender < rightContender) {
				toReturn.addBack(leftContender);
				i++;
			}
			else {
				toReturn.addBack(rightContender);
				j++;
			}
		}
		while (i < leftSize) {
			toReturn.addBack(left.getIndex(i));
			i++;
		}
		while (j < rightSize) {
			toReturn.addBack(right.getIndex(j));
			j++;
		}
		return toReturn;
	}
}

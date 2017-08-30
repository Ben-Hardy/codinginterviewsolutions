package chapter_two;

import java.util.ArrayList;

public class ChapterTwo {

	/*
	 * I'm just going to use Integer types for all these for simplicity's
	 * sake
	 */
	
	/*
	 * 2.1:
	 * Remove Dups: Write code to remove duplicates from an unsorted
	 * linked list
	 * 
	 * returns: the list with all duplicates removed
	 */
	public LinkedList<Integer> two_one(LinkedList<Integer> list) {
		ArrayList<Integer> dups = new ArrayList<Integer>();
		if (list.getSize() < 2) {
			return list;
		}
		else {
			list.goFirst();
			dups.add(list.getCur().getItem());
			int counter = 1;
			while (list.getCur().hasNext()) {
				if (dups.contains(list.getCur().getNext().getItem())) {
					list.removeNthElement(counter + 1);
				} else {
					dups.add(list.getCur().getNext().getItem());
				}
				counter++;
				
				if (list.getCur().hasNext())
					list.goNext();
			}	
		}
		return list;
	}
	
	
	/*
	 * 2.2:
	 * Return Kth to Last: Implement an algorithm to find the kth to last
	 * element of a singly linked list
	 */
	
	/*
	 * My solution is O(n - m) where n is the size of the list and m is the number
	 * of elements from the end. It takes advantage of the fact my linkedlist 
	 * implementation has a variable to keep track of size. If the implementation
	 * one is using doesn't have such a thing, then the algorithm would be O(n)
	 * since they'd need to iterate through the list to find the number of elements.
	 
	 * returns the kth to last node
	 */
	
	public LinkedNode<Integer> two_two(LinkedList<Integer> list, int k) {
		if (list.getSize() < k) {
			System.out.println("K is too big!");
			return null;
		}
		
		int counter = 1;
		list.goFirst();
		
		if (k == list.getSize()) {
			return list.getCur();
		}
		
		while (list.getCur().hasNext() && counter < (list.getSize() - (k - 1))) {
			list.goNext();
			counter++;
		}
		return list.getCur();
	}
	
	/*
	 * 2.3
	 * Implement an algorithm to delete a node in the middle (i.e any node but
	 * the first and last node, not necessarily the exact middle) of a 
	 * singly linked list, given only access to that node
	 */
	
	/*
	 * There's only really one solution to this. It's constant time because
	 * it's literally just a few assignments and reassignments.
	 */
	public boolean two_three(LinkedNode<Integer> node) {
		if (!node.hasNext()) {
			return false;
		}
		
		if (!node.getNext().hasNext()) {
			return false;
		}
		
		LinkedNode<Integer> temp = node.getNext();
		node.setNext(temp.getNext());
		node.setItem(temp.getItem());
		
		return true;
	}
	
	/*
	 * 2.4
	 * Write code to partition a linked list around a value x, such that
	 * all nodes less than x come before all nodes greater than or equal to x.
	 * If x is contained within the list, the values of x only need to be after
	 * the elements less than x. The partition element x can appear anywhere
	 * in the "right partition"; it does not need to appear between the left 
	 * and right partitions
	 */
	
	/*
	 * This one is pretty straight forward. It's O(n) since you have to access
	 * every element in the list to compare it to the partition value.
	 */
	
	public LinkedList<Integer> two_four(LinkedList<Integer> list, int partition) {
		LinkedList<Integer> newList = new LinkedList<Integer>();
		
		if (list.getSize() == 0) {
			return null;
		}
		list.goFirst();
		newList.append(list.getCur().getItem());
		while (list.getCur().hasNext()) {
			System.out.println(list.getCur().getNext().getItem());
			if (list.getCur().getNext().getItem() < partition) {
				newList.prepend(list.getCur().getNext().getItem());
			} else {
				newList.append(list.getCur().getNext().getItem());
			}
			list.goNext();
		}
		
		return newList;
	}
	
}

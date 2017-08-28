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
	LinkedList<Integer> twoPointOne(LinkedList<Integer> list) {
		ArrayList<Integer> dups = new ArrayList<Integer>();
		if (list.getSize() < 2) {
			return list;
		}
		else {
			LinkedNode<Integer> temp = list.getCur();
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
	
	
}

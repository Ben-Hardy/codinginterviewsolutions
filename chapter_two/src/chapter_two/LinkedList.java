package chapter_two;

public class LinkedList<T> {
	
	//
	private LinkedNode<T> head = null;
	private LinkedNode<T> tail = null;
	
	// cursor node to make traversal nice and easy!
	private LinkedNode<T> cursor = null;
	
	private int size = 0;
	
	public LinkedList() {
		
	}
	
	public void goFirst() {
		cursor = head;
	}
	
	public void goLast() {
		cursor = tail;
	}
	
	public void goNext() {
		if (cursor.hasNext()) {
			cursor = cursor.getNext();
		}
		else System.out.println("At end!");
	}
	
	public LinkedList(T firstItem) {
		LinkedNode<T> n = new LinkedNode<T>(firstItem);
		head = n;
		tail = n;
		cursor = n;
		size++;
	}
	
	public LinkedNode<T> getCur() {
		return cursor;
	}
	
	public int getSize() {
		return size;
	}
	
	public void append(T item) {
		LinkedNode<T> newNode = new LinkedNode<T>(item);
		
		if (size == 0) {
			head = newNode;
			tail = newNode;
			cursor = newNode;
			size++;
		} else {
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}
	}
	
	public void prepend(T item) {
		if (size == 0) {
			append(item);
		} else {
			LinkedNode<T> newNode = new LinkedNode<T>(item);
			newNode.setNext(head);
			head = newNode;
			size++;
		}
		
	}
	
	
	// removes item from list. If multiple entries of item, removes first
	// encountered entry
	public void remove(T item) {
		// handle if the head is the item to be removed
		if (head.getItem().equals(item)) {
			if (head.hasNext()) {
				head = head.getNext();
				size--;
			}
			else { // only one item in list. Empty the list!
				head = null;
				tail = null;
				cursor = null;
				size--;
			}
		}
		else {	
			// it's not the head, so we have to search through the list for the item
			LinkedNode<T> temp = cursor;
			cursor = head;
			while (cursor.hasNext()) {
				if (cursor.getNext().getItem().equals(item)) {
					cursor.setNext(cursor.getNext().getNext());
					size--;
					break;
				}
				this.goNext();
			}
			cursor = temp;
		}
			
	}

	public void removeNthElement(int n) {
		if (size < n || n <= 0)
			return;
		
		if (n == 1) {
			if (head.hasNext()) {
				if (cursor.equals(head))
					cursor = head.getNext();
				head = head.getNext();
				size--;
			} else {
				head = null;
				tail = null;
				cursor = null;
				size--;
			}
		} else {
			cursor = head;
			int counter = 1;
			while (counter < n - 1) {
				goNext();
				counter++;
			}
			cursor.setNext(cursor.getNext().getNext());
			size--;
		}
	}
	
	// made this specifically for if we do in-place deletions that
	// will cause the list size to not be synced. Basically caused by
	// two_three
	public void recalculateSize() {
		if (head == null) {
			size = 0;
			return;
		}
		size = 1;
		goFirst();
		while (cursor.hasNext()) {
			size++;
			this.goNext();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (size == 0) {
			return "[]";
		}
		else {
			s.append("[");
			LinkedNode<T> temp = head;
			s.append(temp.getItem().toString() + ", ");
			
			while (temp.hasNext()) {
				temp = temp.getNext();
				s.append(temp.getItem().toString() + ", ");
			}
			s.append("]");
			return s.toString();
			
			
		}
		
	}
}

package chapter_two;

public class LinkedNode<T> {
	private T item;
	private LinkedNode<T> next = null;
	
	public LinkedNode(T item) {
		this.item = item;
	}
	
	public T getItem() { 
		return this.item; 
	}
	
	public LinkedNode<T> getNext() {
		return this.next; 
	}
	
	
	public boolean hasNext() {
		return this.next != null;
	}
	
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
}

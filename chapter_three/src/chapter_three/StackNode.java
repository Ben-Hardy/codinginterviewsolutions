package chapter_three;

public class StackNode<T> {
	private T item;
	private StackNode<T> next;
	
	public StackNode(T item) {
		this.item = item;
		this.next = null;
	}
	
	public StackNode<T> getNext() {
		return next;
	}
	
	public void setNext(StackNode<T> next) {
		this.next = next;
	}
	
	public boolean hasNext() {
		return this.next != null;
	}
	
	public T getItem() {
		return this.item;
	}
}

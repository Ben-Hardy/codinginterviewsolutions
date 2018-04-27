package chapter_three;

public class Stack<T> {
	
	private StackNode<T> top;
	private int size;
	
	public Stack() {
		size = 0;
		top = null;
	}
	
	public void push(T item) {
		StackNode<T> node = new StackNode<T>(item);
		node.setNext(top);
		top = node;
		size++;
	}
	
	public T pop() {
		if (size == 0)
			return null;
		
		T item = top.getItem();
		top = top.getNext();
		size--;
		return item;
	}
	
	public Boolean isEmpty() {
		return size == 0;
	}
	

	public int getSize() {
		return size;
	}
	
	public T peek() {
		return top.getItem();
	}
	
	@Override
	public String toString() {
		
		if (size == 0)
			return null;
		StringBuilder sb = new StringBuilder();
		
		StackNode<T> temp = top;
		sb.append(temp.getItem().toString() + ", ");
		
		while (temp.hasNext()) {
			sb.append(temp.getNext().getItem().toString() + ", ");
			temp = temp.getNext();
		}
		
		return sb.toString();
		
	}
	
}

package chapter_three;

public class MyQueue<T> {
	
	// this stack will be used for adding to the queue. It will store
	// elements in reverse order
	protected Stack<T> enqueueStack;
	
	/*
	 * We will use this stack when we need to dequeue an element. To dequeue,
	 * we will pop all elements from the enqueue stack and push them onto this one,
	 * until we get the bottom element from that stack, we remove that, and then
	 * if needed, put everything back on the other stack. This is designed so that
	 * if there are sequential enqueues or dequeues we don't need to flip the stacks
	 * every time.
	 */
	protected Stack<T> dequeueStack;
	
	private int numItems;
	
	public MyQueue() {
		enqueueStack = new Stack<T>();
		dequeueStack = new Stack<T>();
		numItems = 0;
	}
	
	public void enqueue(T item) {
		if (enqueueStack.isEmpty() && !dequeueStack.isEmpty()) {
			flip();
		}
		enqueueStack.push(item);
		numItems++;
	}
	
	public T dequeue() {
		T item;
		
		if (!enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			flip();
		}
		item = dequeueStack.pop();
		numItems--;
		
		return item;
	}
	
	public int getSize() {
		return numItems;
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	/*
	 * Helper function to flip the stacks over
	 */
	public void flip() {
		T tempItem;
		if (enqueueStack.isEmpty() && !dequeueStack.isEmpty()) {
			while (!dequeueStack.isEmpty()) {
				tempItem = dequeueStack.pop();
				enqueueStack.push(tempItem);
			}
		}
		else if (!enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				tempItem = enqueueStack.pop();
				dequeueStack.push(tempItem);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Enqueue Stack: " + enqueueStack.toString() + "\n");
		sb.append("Dequeue Stack: " + dequeueStack.toString() + "\n");
		
		return sb.toString();
	}
	
	
}

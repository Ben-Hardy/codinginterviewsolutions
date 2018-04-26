package chapter_three;

import java.util.ArrayList;

public class SetOfStacks<T> {
	
	private int maxHeight;
	
	protected int numStacks;
	private int numItems;
	
	// Our set of stacks
	private ArrayList<Stack<T>> stacks;
	
	public SetOfStacks(int maxHeight) {
		if (maxHeight < 1) {
			System.out.println("Can't have height less than 1!");
			return;
		}
		this.maxHeight = maxHeight;
		numStacks = 1;
		numItems = 0;
		stacks = new ArrayList<Stack<T>>();
		Stack<T> initialStack = new Stack<T>();
		stacks.add(initialStack);
	}
	
	// adds an item to the stack, creating a new stack if necessary
	public void push(T item) {
		if (stacks.get(numStacks - 1).getSize() == maxHeight) {
			Stack<T> newStack = new Stack<T>();
			stacks.add(newStack);
			numStacks++;
		}
		stacks.get(numStacks - 1).push(item);
		numItems++;
	}
	
	public int getSize() {
		return numItems;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < numStacks; i++) {
			sb.append("Stack " + i + ": " + stacks.get(i).toString() + "\n");
		}
		
		return sb.toString();
	}

	/*
	 * removes the top element, removing redundant stacks if necessary.
	 */
	public T pop() {
		if (numItems == 0)
			return null;
		T item = stacks.get(numStacks-1).pop();
		numItems--;
		// Remove the stack if it is now empty
		if  (stacks.get(numStacks-1).getSize() == 0) {
			stacks.remove(numStacks - 1);
			numStacks--;
		}
		
		return item;
		
	}
}
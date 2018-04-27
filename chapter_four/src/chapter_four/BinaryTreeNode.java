package chapter_four;

public class BinaryTreeNode<T> {
	private T item;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T item) {
		this.item = item;
		left = null;
		right = null;
	}
	
	/* 
	 * If the left node exists, swap items with this node
	 */
	public void swapLeft() {
		if (!this.hasLeft())
			return;
		T tempItem = this.item;
		this.item = this.getLeft().getItem();
		this.getLeft().setItem(tempItem);
	}
	
	public void swapRight() {
		if (!this.hasRight())
			return;
		T tempItem = this.item;
		this.item = this.getRight().getItem();
		this.getRight().setItem(tempItem);
	}
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return item;
	}
	
	public void setRight(BinaryTreeNode<T> node) {
		right = node;
	}
	
	public void setLeft(BinaryTreeNode<T> node) {
		left = node;
	}
	
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	
	public boolean hasLeft() {
		return left != null;
	}
	
	public boolean hasRight() {
		return right != null;
	}
	
	@Override
	public String toString() {
		return item.toString();
	}
}

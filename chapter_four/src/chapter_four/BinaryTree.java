package chapter_four;

public class BinaryTree<T> {
	public BinaryTreeNode<T> root;
	private int height;
	
	public BinaryTree(T item) {
		root = new BinaryTreeNode<T>(item);
		height = 0;
	}
	
	public int numChildren(BinaryTreeNode<T> node) {
		if (!node.hasLeft() && !node.hasRight())
			return 0;
		else if (node.hasLeft() && !node.hasRight())
			return 1 + numChildren(node.getLeft());
		else if (!node.hasLeft() && node.hasRight())
			return 1 + numChildren(node.getRight());
		else
			return 2 + numChildren(node.getLeft()) + numChildren(node.getRight());
	}
	
	public void insert(T item) {
		if (!root.hasLeft())
			root.setLeft(new BinaryTreeNode<T>(item));
		else if (!root.hasRight())
			root.setRight(new BinaryTreeNode<T>(item));
		else {
			if (this.numChildren(root.getLeft()) <= this.numChildren(root.getRight())) {
				insertHelper(item, root.getLeft());
			}
			else
				insertHelper(item, root.getRight());
		}
	}
	
	private void insertHelper(T item, BinaryTreeNode<T> node) {
		
	}
}

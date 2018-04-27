package chapter_four;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeTests {

	@Test
	void BinaryTreeNodeTests() {
		BinaryTreeNode<Integer> n = new BinaryTreeNode<Integer>(1);
		assertEquals(n.getLeft(), null);
		assertEquals(n.hasLeft(), false);
		assertEquals(n.hasRight(), false);
		assertEquals(n.getRight(), null);
		assertEquals(n.getItem(), (Integer) 1);
		n.setLeft(new BinaryTreeNode<Integer>(2));
		n.setRight(new BinaryTreeNode<Integer>(3));
		assertEquals(n.hasLeft(), true);
		assertEquals(n.hasRight(), true);
		assertEquals(n.getLeft().getItem(), (Integer) 2);
		n.swapLeft();
		assertEquals(n.getItem(), (Integer) 2);
		assertEquals(n.getLeft().getItem(), (Integer) 1);
		n.swapRight();
		assertEquals(n.getItem(), (Integer) 3);
		assertEquals(n.getRight().getItem(), (Integer) 2);
	}
	
	@Test
	void BinaryTreeTests() { 
		BinaryTree<Integer> t = new BinaryTree<Integer>(1);
		assertEquals(0, t.numChildren(t.root));
		
	}


}

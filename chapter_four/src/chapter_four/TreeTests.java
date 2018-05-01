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
		// adds node to root's left branch
		t.insert(2);
		assertEquals(1, t.numChildren(t.root));
		assertEquals((Integer) 2, t.root.getLeft().getItem());
		// adds to root's right branch
		t.insert(3);
		assertEquals((Integer) 3, t.root.getRight().getItem());
		assertEquals(2, t.numChildren(t.root));
		// add's to left's left branch
		t.insert(4);
		assertEquals((Integer) 4, t.root.getLeft().getLeft().getItem());
		assertEquals(3, t.numChildren(t.root));
		assertEquals(1, t.numChildren(t.root.getLeft()));
		// add to right's left branch
		t.insert(5);
		assertEquals((Integer) 5, t.root.getRight().getLeft().getItem());
		// add to left's right branch
		t.insert(6);
		assertEquals((Integer) 6, t.root.getLeft().getRight().getItem());
		assertEquals(2, t.numChildren(t.root.getLeft()));
		// add to right's right branch
		t.insert(7);
		assertEquals(2, t.numChildren(t.root.getRight()));
		// add to left's left's left branch hahaha
		t.insert(8);
		assertEquals((Integer) 8, t.root.getLeft().getLeft().getLeft().getItem());
		assertEquals(7, t.numChildren(t.root));
		
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(1);
		for (int i = 1; i < 64; i++)
			t2.insert(i);
		
		assertEquals(63, t2.numChildren(t2.root));
		assertEquals(31, t2.numChildren(t2.root.getLeft()));
		assertEquals(30, t2.numChildren(t2.root.getRight()));
		
	}


}

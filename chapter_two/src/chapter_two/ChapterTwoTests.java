package chapter_two;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChapterTwoTests {
	
	@Test
	public void listAndNodeTests() {
		
		// NODE TESTS GO
		LinkedNode<Integer> n = new LinkedNode<Integer>(5);
		assertEquals(false, n.hasNext());
		assertEquals(n.getItem(), (Integer) 5);
		LinkedNode<Integer> m = new LinkedNode<Integer>(6);
		n.setNext(m);
		assertEquals(true, n.hasNext());
		assertEquals(false, n.getNext().hasNext());
		
		// LIST TESTS GO
		
		// empty construction test;
		LinkedList<Integer> l = new LinkedList<Integer>();
		assertEquals(0, l.getSize());
		
		l.append(1);
		assertEquals(1, l.getSize());
		assertEquals((Integer) 1, l.getCur().getItem());
		l.append(2);
		assertEquals(2, l.getSize());
		assertEquals((Integer) 1, l.getCur().getItem()); // cursor shouldn't move!
		assertEquals((Integer) 2, l.getCur().getNext().getItem()); // however it should have a next node now
		l.goFirst();
		assertEquals((Integer) 1, l.getCur().getItem());
		l.goLast();
		assertEquals((Integer) 2, l.getCur().getItem());
		l.append(3);
		assertEquals((Integer) 2, l.getCur().getItem()); // cursor didn't move even though tail points to something else
		l.goNext();
		assertEquals((Integer) 3, l.getCur().getItem());
		//l.goNext(); // shouldn't work. Will still be at end.
		assertEquals((Integer) 3, l.getCur().getItem()); // yay it didn't work
		l.append(4);
		assertEquals(4, l.getSize());

		l.remove(3);

		assertEquals(3, l.getSize());
		l.append(3);
		l.append(6);

		l.removeNthElement(3);

		l.removeNthElement(4);

		
		// creating a list with an item, AKA the overloaded constructor thingy
		LinkedList<Integer> list2 = new LinkedList<Integer>(1);
		assertEquals(1, list2.getSize());
		assertEquals((Integer) 1, list2.getCur().getItem());
		list2.remove(1);
		assertEquals(0, list2.getSize());
		assertEquals(null, list2.getCur());
		list2.append(1);
		list2.removeNthElement(1);
		assertEquals(0, list2.getSize());
		assertEquals(null, list2.getCur());
		list2.append(1);
		list2.append(2);
		list2.removeNthElement(1);
		assertEquals(1, list2.getSize());
		assertEquals((Integer)2, list2.getCur().getItem());
		list2.prepend(100);
		assertEquals(2, list2.getSize());
		
	}

	@Test
	public void two_one() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.append(1);
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(1);
		l.append(5);
		assertEquals(l.getSize(), 6);

		ChapterTwo c = new ChapterTwo();
		l = c.two_one(l);
		assertEquals(l.getSize(), 4); // should remove 2 duplicate 1s
		
		// test for small list
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.append(1);
		l2.append(1);
		assertEquals(l2.getSize(),2);
		l2 = c.two_one(l2);
		assertEquals(l2.getSize(),1);
	}
	
	@Test
	public void two_two() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		l.append(7);
		l.append(9);
		l.append(12);
		ChapterTwo c = new ChapterTwo();
		assertEquals((Integer)4, c.two_two(l, 5).getItem());
		assertEquals((Integer)12, c.two_two(l, 1).getItem());
		assertEquals((Integer)7, c.two_two(l, 3).getItem());
		assertEquals((Integer)1, c.two_two(l, 8).getItem());
		assertEquals(c.two_two(l, 9), null); 
	}
	
	@Test
	public void two_three() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		l.append(7);
		l.append(9);
		l.append(12);
		
		ChapterTwo c = new ChapterTwo();
		
		l.goFirst();
		l.goNext();
		l.goNext(); // at 3
		c.two_three(l.getCur()); // remove 3
		l.goFirst();
		l.goNext();
		l.goNext();
		// 3rd element should now be 4
		assertEquals(l.getCur().getItem(), (Integer)4);
		l.recalculateSize();
		assertEquals(l.getSize(), 7);
	}
	
	@Test
	public void two_four() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.append(3);
		l1.append(5);
		l1.append(8);
		l1.append(5);
		l1.append(10);
		l1.append(2);
		l1.append(1);
		
		ChapterTwo c = new ChapterTwo();
		@SuppressWarnings("unused")
		LinkedList<Integer> l2 = c.two_four(l1, 5);
	}
	
	@Test
	public void two_five() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		
		l1.append(7);
		l1.append(1);
		l1.append(6);
		l2.append(5);
		l2.append(9);
		l2.append(2);
		
		ChapterTwo c = new ChapterTwo();
		
		LinkedList<Integer> res = c.two_five(l1, l2);
		System.out.println(res.toString());
		
	}
	
	

}

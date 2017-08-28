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
		//System.out.println(l.toString());
		l.remove(3);
		//System.out.println(l.toString());
		assertEquals(3, l.getSize());
		l.append(3);
		l.append(6);
		//System.out.println(l.toString());
		l.removeNthElement(3);
		//System.out.println(l.toString());
		l.removeNthElement(4);
		//System.out.println(l.toString());
		
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
		
		
	}

	@Test
	public void two_one() {
		System.out.println("2.1 Tests!\n\nList before deduping:");
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.append(1);
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(1);
		l.append(5);
		System.out.println(l.toString());
		ChapterTwo c = new ChapterTwo();
		l = c.twoPointOne(l);
		System.out.println(l.toString());
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.append(1);
		l2.append(1);
		System.out.println(l2.toString());
		l2 = c.twoPointOne(l2);
		System.out.println(l2.toString());
		
	}
	
	

}

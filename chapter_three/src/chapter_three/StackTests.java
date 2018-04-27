package chapter_three;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTests {

	@Test
	public void nodeTest() {
		StackNode<Integer> n = new StackNode<Integer>(5);
		assertEquals(n.getNext(), null);
		assertEquals(n.getItem(), (Integer) 5);
		assertEquals(n.hasNext(), false);
		StackNode<Integer> m = new StackNode<Integer>(7);
		n.setNext(m);
		assertEquals(n.hasNext(), true);
	}
	
	@Test
	public void stackTest() {
		Stack<Integer> s = new Stack<Integer>();
		assertEquals(s.getSize(), 0);
		assertEquals(s.isEmpty(), true);
		s.push(1);
		assertEquals(s.getSize(), 1);
		assertEquals(s.isEmpty(), false);
		assertEquals(s.peek(), (Integer)1);
		assertEquals(s.pop(), (Integer)1);
		assertEquals(s.getSize(), 0);
		s.push(1);
		s.push(2);
		assertEquals(s.getSize(), 2);
		assertEquals(s.peek(), (Integer)2);
		assertEquals(s.toString(), "2, 1, ");
		s.pop();
		s.pop();
		assertEquals(s.toString(), null);
		assertEquals(s.isEmpty(), true);
		
		
	}

}

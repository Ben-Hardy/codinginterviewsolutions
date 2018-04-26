package chapter_three;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChapterThreeTest {

	@Test
	public void SetOfStackstest() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>(4);
		// stack should be empty
		assertEquals(0, s.getSize());
		
		// add an item. Simple!
		s.push(1);
		assertEquals(1, s.getSize());
		s.push(2);
		s.push(3);
		s.push(4);
		// Still one only the first stack
		assertEquals(4, s.getSize());
		assertEquals(1, s.numStacks);
		
		// Adding a 5th item will force a new stack!
		s.push(5);
		assertEquals(5, s.getSize());
		assertEquals(2, s.numStacks);
		// Yay two stacks!
		//System.out.println(s.toString());
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		//System.out.println(s.toString());
		assertEquals(10, s.getSize());
		assertEquals(3, s.numStacks);
		// TIME TO POP
		s.pop();
		// there will be fewer items but still 3 stacks!
		assertEquals(9, s.getSize());
		assertEquals(3, s.numStacks);
		//System.out.println(s.toString());
		// Now we will remove 9, which should return us to 2 stacks!
		s.pop();
		assertEquals(8, s.getSize());
		assertEquals(2, s.numStacks);
		//System.out.println(s.toString());
		
		for (int i = 9; i < 50; i++) {
			s.push(i);
		}
		System.out.println(s.toString());
		
	}

}

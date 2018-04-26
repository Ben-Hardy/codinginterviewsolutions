package chapter_three;

import java.util.ArrayList;

/*
 * As with other chapters, I'm just going to use Integers
 * for simplicity.
 */

public class ChapterThree {
	/*
	 * 3.1:
	 *  Describe how you could use a single array to implement three stacks
	 */
	
	/*
	 * One way would be to split it into 3 sections.
	 * If the array is size N, obviously the total capacity would have
	 * to be N between all 3 stack. But you wouldn't necessarily have to
	 * split up the array evenly. Have one stack start at index 0, and
	 * move a cursor forward one for each added element. Call that cursor
	 * cursor1. 
	 * 
	 * For the second stack, start it at index N - 1, and have its
	 * cursor move "left" (the second element will be at N - 2 and so on). 
	 * This stack will have cursor2.
	 * 
	 * The third stack can either start right before cursor2 or right after
	 * cursor1, or some place arbitrarily between the two. The downside of
	 * having it right before or after the other cursors is that when
	 * elements are pushed onto the stack, it would require moving the
	 * entire third stack over one, which would be a mandatory 
	 * (O(size(stack3)) operation every time. So picking an index between
	 * cursor1 and cursor2 would be better.
	 */
	
	/*
	 * 3.2:
	 * How would you design a stack which, in addition to push and pop, also has a function min
	 *  which returns the minimum element? Push, pop and min should all operate in O(1) time
	 */
	
	/*
	 * One question I have for this, is would min remove the item from the stack. If it is
	 * just storing the value of the minimum item, that's easy. Simply add a variable that
	 * stores the value of the minimum item, do a check every time an item is pushed, and
	 * update the variable according. Then min the function would just return the value of the
	 * variable.
	 * 
	 * If min removed the item from the stack, it would be much trickier, as we would need
	 * to pop off everything "above" min on the stack and push it onto a second stack, pop
	 * min, and then push everything back onto the stack, which could potentially be an
	 * expensive operation, especially if min is one of the first items pushed onto the
	 * stack.
	 */
	
	/*
	 * 3.3:
	 * Imagine a (literal) stack of plates If the stack gets too high, it might topple 
	 * There- fore, in real life, we would likely start a new stack when the previous stack 
	 * exceeds some threshold Implement a data structure SetOfStacks that mimics this. 
	 * SetOfStacks should be composed of several stacks, and should create a new stack once 
	 * the previous one exceeds capacity SetOfStacks push() and SetOfStacks pop() should behave 
	 * identically to a single stack (that is, pop() should return the same values as it would if 
	 * there were just a single stack)
	 */
	
	/*
	 * See SetOfStacks.java and the accompanying tests in ChapterThreeTest.java
	 */
	
	/*
	 * 3.4:
	 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of 
	 * different sizes which can slide onto any tower. The puzzle starts with disks 
	 * sorted in ascending order of size from top to bottom (e g , each disk sits on 
	 * top of an even larger one) You have the following constraints:
	 * (A) Only one disk can be moved at a time
	 * (B) A disk is slid off the top of one rod onto the next rod
	 * (C) A disk can only be placed on top of a larger disk
	 * Write a program to move the disks from the first rod to the last using Stacks
	 */
}

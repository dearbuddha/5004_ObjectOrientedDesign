package Recitation5;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains the unit tests for ArrayStack.
 * This stack implementation uses an array as a backing
 * store.
 * 
 * @author phil
 * @since 2020-01-24
 */
public class ArrayStackTest {

	/**
	 * Test the stack functions
	 */
	@Test
	public void testStack() {
        // creating the stack with the size 5.
        ArrayStack stack = new ArrayStack(5);

        // isEmpty function should return true
        assertTrue("Is Stack Empty? ", stack.isEmpty());

        // isFull function should return false.
        assertTrue("Is Stack Full", (!stack.isFull()));

        // size and capacity of the stack should return 0 and 5 respectively.
        assertEquals("Size of the stack", 0, stack.size());
        assertEquals("Capacity of the stack", 5, stack.capacity());

        // string representation with capacity 5, size 0
        String testval = "[capacity: 5, size: 0, values: []]";
        assertEquals("to string", testval, stack.toString());

        // stack has no top element
        assertEquals("peek", '\0', stack.peek());
        
        // insert 5 elements into the stack.
        stack.push('h');

        // string representation with capacity 5, size 0
        testval = "[capacity: 5, size: 1, values: [h]]";
        assertEquals("to string", testval, stack.toString());

        stack.push('e');
        stack.push('l');
        stack.push('l');
        stack.push('o');

        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Stack Empty? ", !stack.isEmpty());

        // ifFull function should return true, as 5 elements are entered.
        assertTrue("Is Stack Full", (stack.isFull()));

        // Size function should return 5.
        assertEquals("Size of the stack", 5, stack.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the stack", 5, stack.capacity());

        // stack has 'o' as top element
        assertEquals("peek", 'o', stack.peek());

        // string representation with capacity 5, size 0
        testval = "[capacity: 5, size: 5, values: [o, l, l, e, h]]";
        assertEquals("to string", testval, stack.toString());

        // insert the 6th element.
        // resize would happen to the stack at this point.
        stack.push('w');

        // isEmpty function should return false
        assertTrue("Is Stack Empty? ", !stack.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Stack Full", (!stack.isFull()));

        // size of the stack return 6.
        assertEquals("Size of the stack", 6, stack.size());

        // capacity of the stack should return 10.
        assertEquals("Capacity of the stack", 10, stack.capacity());

        // stack has 'o' as top element
        assertEquals("peek", 'w', stack.peek());

        // string representation with capacity 5, size 0
        testval = "[capacity: 10, size: 6, values: [w, o, l, l, e, h]]";
        assertEquals("to string", testval, stack.toString());

        // Pop all the items in the stack and check the character values.
        assertEquals("Pop item", 'w', stack.pop());
        assertEquals("Pop item", 'o', stack.pop());
        assertEquals("Pop item", 'l', stack.pop());
        assertEquals("Pop item", 'l', stack.pop());
        assertEquals("Pop item", 'e', stack.pop());
        assertEquals("Pop item", 'h', stack.pop());

        // isEmpty function should return true
        assertTrue("Is Stack Empty? ", stack.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Stack Full", (!stack.isFull()));

        // size of the stack should return zero.
        assertEquals("Size of the stack", 0, stack.size());
        
        // stack has no top element
        assertEquals("peek", '\0', stack.peek());
        

        // If another element is dequeued, null character should be returned.
        assertEquals("Pop item", '\0', stack.pop());
	}
}

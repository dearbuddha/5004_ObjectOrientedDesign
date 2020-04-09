package Recitation12;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * Tests the dequeue implementation using JUNIT.
 */
public class ArrayDequeTest {

	/**
	 * Test the deque functions
	 */
    @Test
    public void testDeque() {
        // creating the queue with the size 5.
        ArrayDeque<Character> deque = new ArrayDeque<>(5);

        // isEmpty function should return true
        assertTrue("Is Deque Empty? ", deque.isEmpty());

        // isFull function should return false.
        assertTrue("Is Deque Full", (!deque.isFull()));

        // size and capacity of the queue should return 0 and 5 respectively.
        assertEquals("Size of the deque", 0, deque.size());
        assertEquals("Capacity of the deque", 5, deque.capacity());
        
        // queue has no first element
        assertNull("peekFirst", deque.peekFirst());
        
        try {
	        // queue has no first element
	        assertNull("getFirst", deque.getFirst());
	        fail();
        } catch (NoSuchElementException e) {
        	// expected exception
        }
        
        // queue has no first element
        assertNull("pollFirst", deque.pollFirst());

        try {
	        // queue has no first element
	        assertNull("removeFirst", deque.removeFirst());
	        fail();
        } catch (NoSuchElementException e) {
        	// expected exception
        }
        
        // queue has no last element
        assertNull("peekLast", deque.peekLast());

        // queue has no last element
        assertNull("pollLast", deque.pollLast());

        try {
	        // queue has no last element
	        assertNull("removeFirst", deque.removeLast());
	        fail();
        } catch (NoSuchElementException e) {
        	// expected exception
        }

        // string representation with capacity 5, size 0
        String testval = "[capacity: 5, size: 0, values: []]";
        assertEquals("to string", testval, deque.toString());

        // test values
        Character[] val = new Character[] {'h', 'e', 'l', 'l', 'o', 'w'};
        
    	// insert 5 elements into the queue.
        //
        
        try {
        	// add 'h' last element
        	deque.addLast(val[0]);
        } catch (IllegalStateException e) {
        	fail();	// should succeed 
        }
        
        // queue has 'h' first element
        assertEquals("peekFirst", val[0], deque.peekFirst());
        
        try {
        	// queue has 'h' first element
        	assertEquals("peekFirst", val[0], deque.getFirst());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed 
        }
        
        // queue has 'h' last element
        assertEquals("peekLast", val[0], deque.peekLast());

        try {
        	// queue has 'h' last element
        	assertEquals("peekLast", val[0], deque.getLast());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed 
        }

        
        // string representation with capacity 5, size 0
        testval = "[capacity: 5, size: 1, values: [h]]";
        assertEquals("to string", testval, deque.toString());

        // add 'e' first element
        assertTrue(deque.offerFirst(val[1]));

        // string representation with capacity 5, size 0
        testval = "[capacity: 5, size: 2, values: [e, h]]";
        assertEquals("to string", testval, deque.toString());

        // add 'l', 'l', 'o'
        assertTrue(deque.offerLast(val[2]));
        assertTrue(deque.offerFirst(val[3]));
        assertTrue(deque.offerLast(val[4]));

        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Deque Empty? ", !deque.isEmpty());

        // ifFull function should return true, as 5 elements are entered.
        assertTrue("Is Deque Full", (deque.isFull()));

        // Size function should return 5.
        assertEquals("Size of the deque", 5, deque.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the deque", 5, deque.capacity());

        // queue has first element
        assertEquals("peekFirst", val[3], deque.peekFirst());
        
        try {
        	// queue has first element
        	assertEquals("getFirst", val[3], deque.getFirst());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed
        }
        
        // queue has last element
        assertEquals("peekLast", val[4], deque.peekLast());

        try {
        	// queue has first element
        	assertEquals("getLast", val[4], deque.getLast());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed
        }
        
        // string representation with capacity 5, size 5
        testval = "[capacity: 5, size: 5, values: [l, e, h, l, o]]";
        assertEquals("to string", testval, deque.toString());
        
        // test copy constructor and equals methods
        ArrayDeque<Character> deque2 = new ArrayDeque<>(deque);
        assertEquals("equals", deque, deque2);

        // insert the 6th element.
        // resize would happen to the queue at this point.
        assertTrue(deque.offerFirst(val[5]));
        
        // deque and copy no longer equal
        assertNotEquals("equals", deque, deque2);
        
        // isEmpty function should return false
        assertTrue("Is Deque Empty? ", !deque.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Deque Full", (!deque.isFull()));

        // size of the queue return 6.
        assertEquals("Size of the deque", 6, deque.size());

        // capacity of the queue should return 10.
        assertEquals("Capacity of the deque", 10, deque.capacity());

        try {
        	// queue has 'w' first element
        	assertEquals("getFirst", val[5], deque.getFirst());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed
        }
        
        try {
        	// deque has 'o' last element
        	assertEquals("getLast", val[4], deque.getLast());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed
        }

        assertEquals("peek 0", val[5], deque.peek(0));
        assertEquals("peek 5", val[4], deque.peek(5));
        assertEquals("peek 6", null, deque.peek(6));
        assertEquals("peek -1", val[4], deque.peek(-1));
        assertEquals("peek -6", val[5], deque.peek(-6));
        assertEquals("peek -7", null, deque.peek(-7));

        // string representation with capacity 10, size 6
        testval = "[capacity: 10, size: 6, values: [w, l, e, h, l, o]]";
        assertEquals("to string", testval, deque.toString());

        // Dequeue all the items in the queue and check the character values.
        try {
        	assertEquals("Remove first item", val[5], deque.removeFirst());
        } catch (NoSuchElementException e) {
        	fail();	// should succeed        	
        }
        assertEquals("Remove last item",  val[4], deque.pollLast());
        assertEquals("Remove first item", val[3], deque.pollFirst());
        assertEquals("Remove last item",  val[2], deque.pollLast());
        assertEquals("Remove first item", val[1], deque.pollFirst());
        assertEquals("Remove last item",  val[0], deque.pollLast());

        // isEmpty function should return true
        assertTrue("Is Deque Empty? ", deque.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Deque Full", (!deque.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the deque", 0, deque.size());

        // If another element is dequeued, null character should be returned.
        assertNull("Remove first item", deque.pollFirst());

        try {
        	assertNull("Remove first item",  deque.removeFirst());
        	fail();	// should not succeed
        } catch (NoSuchElementException e) {
        	// expect fail
        }

        
        assertNull("Remove last item",  deque.pollLast());

        try {
        	assertNull("Remove last item",  deque.removeLast());
        	fail();	// should not succeed
        } catch (NoSuchElementException e) {
        	// expect fail
        }
    }   
}

package Recitation6;

import org.junit.Test;
import static org.junit.Assert.*;

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
        ArrayDeque deque = new ArrayDeque(5);

        // isEmpty function should return true
        assertTrue("Is Deque Empty? ", deque.isEmpty());

        // isFull function should return false.
        assertTrue("Is Deque Full", (!deque.isFull()));

        // size and capacity of the queue should return 0 and 5 respectively.
        assertEquals("Size of the deque", 0, deque.size());
        assertEquals("Capacity of the deque", 5, deque.capacity());
        
        // queue has no first element
        assertEquals("peekFirst", '\0', deque.peekFirst());
        
        // queue has no last element
        assertEquals("peekLast", '\0', deque.peekLast());

        // string representation with capacity 5, size 0
        String testval = "[capacity: 5, size: 0, values: []]";
        assertEquals("to string", testval, deque.toString());

        // insert 5 elements into the queue.
        deque.addLast('h');
        
        // queue has 'h' first element
        assertEquals("peekFirst", 'h', deque.peekFirst());
        
        // queue has 'h' last element
        assertEquals("peekLast", 'h', deque.peekLast());

        // string representation with capacity 5, size 0
        testval = "[capacity: 5, size: 1, values: [h]]";
        assertEquals("to string", testval, deque.toString());

        deque.addFirst('e');

        // string representation with capacity 5, size 0
        testval = "[capacity: 5, size: 2, values: [e, h]]";
        assertEquals("to string", testval, deque.toString());

        deque.addLast('l');
        deque.addFirst('l');
        deque.addLast('o');

        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Deque Empty? ", !deque.isEmpty());

        // ifFull function should return true, as 5 elements are entered.
        assertTrue("Is Deque Full", (deque.isFull()));

        // Size function should return 5.
        assertEquals("Size of the deque", 5, deque.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the deque", 5, deque.capacity());

        // queue has no first element
        assertEquals("peekFirst", 'l', deque.peekFirst());
        
        // queue has no last element
        assertEquals("peekLast", 'o', deque.peekLast());

        // string representation with capacity 5, size 5
        testval = "[capacity: 5, size: 5, values: [l, e, h, l, o]]";
        assertEquals("to string", testval, deque.toString());

        // insert the 6th element.
        // resize would happen to the queue at this point.
        deque.addFirst('w');
        
        // isEmpty function should return false
        assertTrue("Is Deque Empty? ", !deque.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Deque Full", (!deque.isFull()));

        // size of the queue return 6.
        assertEquals("Size of the deque", 6, deque.size());

        // capacity of the queue should return 10.
        assertEquals("Capacity of the deque", 10, deque.capacity());

        // queue has 'w' first element
        assertEquals("peekFirst", 'w', deque.peekFirst());
        
        // deque has 'o' last element
        assertEquals("peekLast", 'o', deque.peekLast());

        // deque has 'w' element 0
        assertEquals("peek 0", 'w', deque.peek(0));

        // deque has 'o' element 5
        assertEquals("peek 5", 'o', deque.peek(5));
        
        // deque has 'o' element -1
        assertEquals("peek -1", 'o', deque.peek(-1));
        
        // deque has 'w' element -6
        assertEquals("peek -6", 'w', deque.peek(-6));

        // string representation with capacity 10, size 6
        testval = "[capacity: 10, size: 6, values: [w, l, e, h, l, o]]";
        assertEquals("to string", testval, deque.toString());

        // Dequeue all the items in the queue and check the character values.
        assertEquals("Remove first item", 'w', deque.removeFirst());
        assertEquals("Remove last item",  'o', deque.removeLast());
        assertEquals("Remove first item", 'l', deque.removeFirst());
        assertEquals("Remove last item",  'l', deque.removeLast());
        assertEquals("Remove first item", 'e', deque.removeFirst());
        assertEquals("Remove last item",  'h', deque.removeLast());

        // isEmpty function should return true
        assertTrue("Is Deque Empty? ", deque.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Deque Full", (!deque.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the deque", 0, deque.size());

        // If another element is dequeued, null character should be returned.
        assertEquals("Remove first item", '\0', deque.removeFirst());
        assertEquals("Remove last item",  '\0', deque.removeLast());
    }   
}

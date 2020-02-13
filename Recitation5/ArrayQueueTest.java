package demo;

import Recitation5.ArrayQueue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the queue implementation using JUNIT.
 */
public class ArrayQueueTest {

    @Test
    public void testQueue() {

        // creating the queue with the size 5.
        ArrayQueue queue = new ArrayQueue(5);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isFull function should return false.
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size and capacity of the queue should return 0 and 5 respectively.
        assertEquals("Size of the queue", 0, queue.size());
        assertEquals("Capacity of the queue", 5, queue.capacity());
        
        // queue has no first element
        assertEquals("peek", '\0', queue.peek());
        
        // string representation with capacity 5, size 0
        String testval = "[capacity: 5, size: 0, values: []]";
        assertEquals("to string", testval, queue.toString());

        // insert 5 elements into the queue.
        queue.enqueue('h');
        queue.enqueue('e');
        queue.enqueue('l');
        queue.enqueue('l');
        queue.enqueue('o');
        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true, as 5 elements are entered.
        assertTrue("Is Queue Full", (queue.isFull()));

        // Size function should return 5.
        assertEquals("Size of the queue", 5, queue.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the queue", 5, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", 'h', queue.peek());
        
        // string representation with capacity 5, size 5
        testval = "[capacity: 5, size: 5, values: [h, e, l, l, o]]";
        assertEquals("to string", testval, queue.toString());

        // insert the 6th element.
        // resize would happen to the queue at this point.
        queue.enqueue('w');

        // isEmpty function should return false
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue return 6.
        assertEquals("Size of the queue", 6, queue.size());

        // capacity of the queue should return 10.
        assertEquals("Capacity of the queue", 10, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", 'h', queue.peek());
        
        // string representation with capacity 10, size 6
        testval = "[capacity: 10, size: 6, values: [h, e, l, l, o, w]]";
        assertEquals("to string", testval, queue.toString());

        // Dequeue all the items in the queue and check the character values.
        assertEquals("Dequeue item", 'h', queue.dequeue());
        assertEquals("Dequeue item", 'e', queue.dequeue());
        assertEquals("Dequeue item", 'l', queue.dequeue());
        assertEquals("Dequeue item", 'l', queue.dequeue());
        assertEquals("Dequeue item", 'o', queue.dequeue());
        assertEquals("Dequeue item", 'w', queue.dequeue());

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the queue", 0, queue.size());

        // queue has no first element
        assertEquals("peek", '\0', queue.peek());
        
        
        // If another element is dequeued, null character should be returned.
        assertEquals("Dequeue item", '\0', queue.dequeue());
    }
}

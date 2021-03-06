package Recitation11.demo;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the multi-queue implementation using JUNIT.
 */
public class ArrayMultiQueueTest {

    @Test
    public void testQueue() {

        // creating the queue with the size 5.
        ArrayMultiQueue<Character> queue = new ArrayMultiQueue<>(1,3);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isFull function should return false.
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size and capacity of the queue should return 0 and 3 respectively.
        assertEquals("Size of the queue", 0, queue.size());
        assertEquals("Capacity of the queue", 3, queue.capacity());
        
        // queue has no first element
        assertNull("peek", queue.peek());
        
        // string representation with capacity 5, size 0
        String testval = 
        	 "[[capacity: 1, size: 0, values: []]"
        	+ "[capacity: 1, size: 0, values: []]"
        	+ "[capacity: 1, size: 0, values: []]]";
        assertEquals("to string", testval, queue.toString());
        
        // test values
        Character[] val = new Character[] {'h', 'e', 'l', 'l', 'o', 'w'};

        // insert 5 elements into the queue.
        queue.enqueue(val[0], 0);
        queue.enqueue(val[1], 0);
        queue.enqueue(val[2], 1);
        queue.enqueue(val[3], 1);
        queue.enqueue(val[4], 2);
        
        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true, as 5 elements are entered.
        assertTrue("Is Queue Full", (queue.isFull()));

        // Size function should return 5.
        assertEquals("Size of the queue", 5, queue.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the queue", 5, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 5, size 5
        testval = 
        	 "[[capacity: 2, size: 2, values: [h, e]]"
        	+ "[capacity: 2, size: 2, values: [l, l]]"
        	+ "[capacity: 1, size: 1, values: [o]]]";
        assertEquals("to string", testval, queue.toString());
        
        // test copy constructor and equals methods
        ArrayMultiQueue<Character> queue2 = new ArrayMultiQueue<>(queue);
        assertEquals("equals", queue, queue2);

        // insert the 6th element.
        // resize would happen to the queue at this point.
        queue.enqueue(val[5]);  // default lowest priority (2)

        // queue and copy no longer equal
        assertNotEquals("equals", queue, queue2);

        // isEmpty function should return false
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true
        assertTrue("Is Queue Full", queue.isFull());

        // size of the queue return 6.
        assertEquals("Size of the queue", 6, queue.size());

        // capacity of the queue should return 6.
        assertEquals("Capacity of the queue", 6, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 10, size 6
        testval = 
        	 "[[capacity: 2, size: 2, values: [h, e]]"
        	+ "[capacity: 2, size: 2, values: [l, l]]"
        	+ "[capacity: 2, size: 2, values: [o, w]]]";
        assertEquals("to string", testval, queue.toString());

        // Peek at items in queue and check the character values
        assertEquals("peek 0", val[0], queue.peek(0));
        assertEquals("peek 5", val[5], queue.peek(5));
        assertEquals("peek 6", null, queue.peek(6));
        assertEquals("peek -1", val[5], queue.peek(-1));
        assertEquals("peek -6", val[0], queue.peek(-6));
        assertEquals("peek -7", null, queue.peek(-7));


        // Dequeue all the items in the queue and check the character values.
        assertEquals("Dequeue item", val[0], queue.dequeue());
        assertEquals("Dequeue item", val[1], queue.dequeue());
        assertEquals("Dequeue item", val[2], queue.dequeue());
        assertEquals("Dequeue item", val[3], queue.dequeue());
        assertEquals("Dequeue item", val[4], queue.dequeue());
        assertEquals("Dequeue item", val[5], queue.dequeue());

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the queue", 0, queue.size());

        // queue has no first element
        assertNull("peek", queue.peek());
        
        
        // If another element is dequeued, null character should be returned.
        assertNull("Dequeue item", queue.dequeue());
    }
}

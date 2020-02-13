package Recitation4;

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

        // insert 5 elements into the queue.
        queue.enqueue('h');
        queue.enqueue('e');
        queue.enqueue('l');
        queue.enqueue('l');
        queue.enqueue('o');

        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // ifFull function should return true, as 5 elements are entered.
        assertTrue("Is Queue Full", (queue.isFull()));

        // Size function should return 5.
        assertEquals("Size of the queue", 5, queue.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the queue", 5, queue.capacity());

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

        // If another element is dequeued, null character should be returned.
        assertEquals("Dequeue item", '\0', queue.dequeue());

        // insert 5 elements into the queue.
        queue.enqueue('h');
        queue.enqueue('e');
        queue.enqueue('l');
        queue.enqueue('l');
        queue.enqueue('o');

        //  test toString() method
        String expected = "[capacity: 10, size: 5, values: [h, e, l, l, o]]";
        assertEquals("Expected String", expected, queue.toString());
    }
}

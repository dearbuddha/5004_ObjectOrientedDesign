package Recitation8;

import Recitation7.ArrayDeque;

/**
 * CS 5005 Recitation - Session 7
 * Queue of characters implemented as an array.
 */
public class ArrayQueue {
	/** Deque used as queue */
	private ArrayDeque deque;
	
    /**
     * Constructor for a queue with a default size of 4.
     */
    public ArrayQueue() {
    	deque = new ArrayDeque(4);
    }
    
    /**
     * Constructor, to initialize the capacity of the queue.
     * If the input capacity is less than 1, then capacity 
     * is reinitialized as one.
     *
     * @param capacity capacity of the queue.
     */
    public ArrayQueue(int capacity) {
    	deque = new ArrayDeque(capacity);
    }

    /**
     * Copy constructor performs shallow copy of other.
     * 
     * @param other another instance
     */
    public ArrayQueue(ArrayQueue other) {
    	deque = new ArrayDeque(other.deque.capacity());
    }
    
    /**
     * Inserts an element to the queue.
     * 
     * @param o element to be inserted.
     */
    public void enqueue(Object o) {
    	deque.addLast(o);
    }

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue or '\0' if empty
     */
    public Object dequeue() {
    	Object o = deque.removeFirst();
    	return o;
    }

    /**
     * Peeks the first element of the queue.
     *
     * @return first element of the queue or '\0' if empty
     */
    public Object peek() {
    	Object o = deque.peekFirst();
    	return o;
    }

    /**
     * Determines whether queue is empty or not.
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty() {
    	boolean empty = deque.isEmpty();
        return empty;
    }

    /**
     * Determines whether queue is full or not
     * 
     * @return true if the queue is full.
     */
    public boolean isFull() {
    	boolean full = deque.isFull();
    	return full;
    }

    /**
     * Number of elements the queue can occupy.
     * 
     * @return capacity of the queue.
     */
    public int capacity() {
    	int cap = deque.capacity();
        return cap;
    }

    /**
     * Number of elements in the queue.
     * 
     * @return size of queue.
     */
    public int size() {
    	int siz = deque.size();
        return siz;
    }

    /**
     * Determines whether this instance is equal
     * to another instance. A queue is equal to 
     * another queue if it has the same number of
     * elements and each corresponding element
     * equals() the other.
     * 
     * @param o an object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
    	if (o instanceof ArrayQueue) {
    		ArrayQueue other = (ArrayQueue)o;
    		return deque.equals(other.deque);
    	}
    	return false;
    }

    /**
     * Return string representation of queue. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]"
     * 
     * @return string representation of queue
     */
    public String toString() {
    	return deque.toString();
    }
}

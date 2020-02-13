package Recitation6;

/**
 * CS 5005 Recitation - Session 3
 * Queue of characters implemented as an array.
 */
public class ArrayQueue {
	/** Deque used as queue */
	private ArrayDeque deque;
	
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
     * Inserts an element to the queue.
     * 
     * @param c element to be inserted.
     */
    public void enqueue(char c) {
    	deque.addLast(c);
    }

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue or '\0' if empty
     */
    public char dequeue() {
    	char c = deque.removeFirst();
    	return c;
    }

    /**
     * Peeks the first character element of the queue.
     *
     * @return first element of the queue or '\0' if empty
     */
    public char peek() {
    	char c = deque.peekFirst();
    	return c;
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
     * Return string representation of queue. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]"
     * 
     * @return string representation of queue
     */
    public String toString() {
    	return deque.toString();
    }
}

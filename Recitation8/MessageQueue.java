/*
 * This file demonstrates how to create a wrapper
 * for ArrayQueue that accepts and returns only 
 * instances of Message. Methods of this class 
 * delegates to corresponding ArrayQueue methods
 */
package Recitation8;


/**
 * Queue of Message objects.
 */
public final class MessageQueue {
	/** Array queue for messages */
	private ArrayQueue queue;
	
    /**
     * Constructor for a queue with a default size of 4.
     */
    public MessageQueue() {
    	queue = new ArrayQueue();
    }
    
    /**
     * Constructor, to initialize the capacity of the queue.
     * If the input capacity is less than 1, then capacity 
     * is reinitialized as one.
     *
     * @param capacity capacity of the queue.
     */
    public MessageQueue(int capacity) {
    	queue = new ArrayQueue(capacity);
    }

    /**
     * Copy constructor performs shallow copy of other.
     * 
     * @param other another instance
     */
    public MessageQueue(MessageQueue other) {
    	queue = new ArrayQueue(other.queue);
    }
    
    /**
     * Inserts an element to the queue.
     * 
     * @param m to be inserted.
     */
    public void enqueue(Message m) {
    	queue.enqueue(m);
    }

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front message of queue or null if empty
     */
    public Message dequeue() {
    	Message m = (Message)queue.dequeue();
    	return m;
    }

    /**
     * Peeks the first message of the queue.
     *
     * @return first message of the queue or null if empty
     */
    public Message peek() {
    	Message m = (Message)queue.peek();
    	return m;
    }

    /**
     * Determines whether queue is empty or not.
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty() {
    	boolean empty = queue.isEmpty();
        return empty;
    }

    /**
     * Determines whether queue is full or not
     * 
     * @return true if the queue is full.
     */
    public boolean isFull() {
    	boolean full = queue.isFull();
    	return full;
    }

    /**
     * Number of elements the queue can occupy.
     * 
     * @return capacity of the queue.
     */
    public int capacity() {
    	int cap = queue.capacity();
        return cap;
    }

    /**
     * Number of elements in the queue.
     * 
     * @return size of queue.
     */
    public int size() {
    	int siz = queue.size();
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
    	if (o instanceof MessageQueue) {
    		MessageQueue m = (MessageQueue)o;
    		return queue.equals(m.queue);
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
    	return queue.toString();
    }
}

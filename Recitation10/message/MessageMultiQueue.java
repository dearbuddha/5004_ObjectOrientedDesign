/*
 * This file demonstrates how to create a wrapper
 * for ArrayQueue that accepts and returns only 
 * instances of Message. Methods of this class 
 * delegates to corresponding ArrayQueue methods
 */
package message;

import demo.*;

/**
 * Queue of Message objects ordered by priority
 * and then by insertion order. Priorities range
 * from 0 (highest) to #priorities-1 (lowest)
 */
public final class MessageMultiQueue implements Queue<Message> {
	/** Array queue for messages */
	private ArrayQueue<Message>[] queue;
	
    /**
     * Constructor for a queue with a default 
     * capacity of 4, with one priority.
     */
    public MessageMultiQueue() {
    	this(4);
    }
    
    /**
     * Constructor, to initialize the capacity 
     * of the queue. If the input capacity is less 
     * than 1, then capacity defaults to 4, with
     * one priority.
     *
     * @param capacity capacity of the queue.
     */
    public MessageMultiQueue(int capacity) {
    	this(capacity,1);
    }

    /**
     * Constructor, to initialize the capacity of 
     * the queue. If the input capacity is less than 
     * 1, then capacity is reinitialized as one.
     * If number of priorities less than 1, one
     * priority is used.
     *
     * @param capacity capacity of the queue.
     * @param numPriorities number of priorities
     */
    @SuppressWarnings("unchecked")
	public MessageMultiQueue(int capacity, int numPriorities) {
    	// at least one priority
    	if (numPriorities < 1) {
    		numPriorities = 1;
    	}
    	
    	// create array of MessageQueues for each priority
    	queue = (ArrayQueue<Message>[]) new ArrayQueue<?>[numPriorities];
    	
    	// initialize elements to queues for each priority
    	for (int i = 0; i < numPriorities; i++) {
    		queue[i] = new ArrayQueue<Message>(capacity);
    	}
    }

    /**
     * Copy constructor performs shallow copy of other.
     * 
     * @param other another instance
     */
    @SuppressWarnings("unchecked")
	public MessageMultiQueue(MessageMultiQueue other) {
    	queue = (ArrayQueue<Message>[]) new ArrayQueue[other.priorities()];
    	
    	// assign copies of each queue to new array
    	for (int i = 0; i < priorities(); i++) {
    		queue[i] = new ArrayQueue<Message>(other.queue[i]);
    	}
    }
    
    /**
     * Inserts an element to the queue at lowest priority.
     * 
     * @param m message to be inserted.
     */
    @Override
    public void enqueue(Message m) {
    	enqueue(m, priorities()-1);
    }

    /**
     * Inserts an element to the queue at specified priority.
     * 
     * @param m message to be inserted.
     * @param priority the priority of the message
     * @throws IndexOutOfBoundsException if invalid priority
     */
    public void enqueue(Message m, int priority) {
    	queue[priority].enqueue(m);
    }

    /**
     * Removes front element entered in the queue.
     * 
     * @return front message of queue or null if empty
     */
    @Override
    public Message dequeue() {
    	// dequeue from first queue with content
    	for (ArrayQueue<Message> mq : queue) {
    		if (!mq.isEmpty()) {
    			return mq.dequeue();
    		}
    	}
    	return null;
    }

    /**
     * Peeks the first message of the queue.
     *
     * @return front message of the queue or null if empty
     */
    @Override
    public Message peek() {
    	// peek at first queue with content
    	for (ArrayQueue<Message> mq : queue) {
    		if (!mq.isEmpty()) {
    			return mq.peek();
    		}
    	}
    	return null;
    }

    /**
     * Determines whether queue is empty or not.
     * 
     * @return true if queue is empty
     */
    @Override
    public boolean isEmpty() {
    	// empty if all queues are empty
    	for (ArrayQueue<Message> mq : queue) {
    		if (!mq.isEmpty()) {
    			return false;
    		}
    	}
        return true;
    }

    /**
     * Determines whether queue is full or not.
     * 
     * @return true if the queue is full.
     */
    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    /**
     * Number of elements the queue can occupy.
     * 
     * @return capacity of the queue.
     */
    @Override
    public int capacity() {
    	// capacity of all queues
    	int cap = 0;
    	for (ArrayQueue<Message> mq : queue) {
    		cap += mq.capacity();
    	}
        return cap;
    }

    /**
     * Number of elements in the queue.
     * 
     * @return size of queue.
     */
    @Override
    public int size() {
    	// number of elements in all queues
    	int total = 0;
    	for (ArrayQueue<Message> mq : queue) {
    		total += mq.size();
    	}
        return total;
    }
    
    /**
     * Number of elements in the queue with
     * a given priority.
     * 
     * @param priority the priority
     * @return size of queue.
     * @throws IndexOutOfBoundsException if invalid priority
     */
    public int size(int priority) {
    	return queue[priority].size();
    }
    
    /**
     * Number of priorities for the queue.
     * 
     * @return priorities for queue
     */
    public int priorities() {
    	return queue.length;
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
    	if (o instanceof MessageMultiQueue) {
    		MessageMultiQueue m = (MessageMultiQueue)o;
    		for (int i = 0; i < priorities(); i++) {
    			// false if queue not equal
    			if (!queue[i].equals(m.queue[i])) {
    				return false;
    			}
    		}
    		// true if all queues equal
        	return true;
    	}
    	return false;
    }

    /**
     * Return string representation of message queue. 
     * Format is:
     * "[[message-queue0], ... [message-queueN]]"
     * with elements from first to last in priority order.
     * 
     * @return string representation of deque
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	for (ArrayQueue<Message> mq : queue) {
    		sb.append(mq.toString());
    	}
    	sb.append("]");
    	return sb.toString();
    }
}

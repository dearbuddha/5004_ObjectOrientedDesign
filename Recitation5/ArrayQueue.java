package Recitation5;

/**
 * CS 5005 Recitation - Session 3
 * Queue of characters implemented as an array.
 */
public class ArrayQueue {

    /** Character array for values as circular array. */
    char[] queueArr;

    /** Points to the front element in the queue. */
    private int front = 0;

    /** Points to next available space from rear element. */
    private int rear = 0;

    /** Number of elements in the queue. */
    private int numOfElements = 0;

    /**
     * Constructor, to initialize the capacity of the queue.
     * If the input capacity is less than 1, then capacity 
     * is reinitialized as one.
     *
     * @param capacity capacity of the queue.
     */
    public ArrayQueue(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        queueArr = new char[capacity];
    }

    /**
     * Inserts an element to the queue.
     * 
     * @param c element to be inserted.
     */
    public void enqueue(char c) {
        if (isFull()) {
            resize();
        }

        queueArr[rear] = c;
        rear = (rear + 1) % capacity();
        numOfElements++;
    }

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue or '\0' if empty
     */
    public char dequeue() {
    	// return null character if empty
        if(isEmpty()) {
            return '\0';
        }

        // get front element to return
        char frontElement = queueArr[front];
        
        // erase char so we know it is gone
        queueArr[front] = '\0';
        
        // move front to next queue element
        front = (front + 1) % capacity();
        
        numOfElements--;  // decrease number elements in queue
        return frontElement;
    }

    /**
     * Peeks the first character element of the queue.
     *
     * @return first element of the queue or '\0' if empty
     */
    public char peek() {
        if (isEmpty()) {
            return '\0';  // indicates no element
        }

        return queueArr[front];
    }

    /**
     * Determines whether queue is empty or not.
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        // number of elements is zero
        return size() == 0;
    }

    /**
     * Determines whether queue is full or not
     * 
     * @return true if the queue is full.
     */
    public boolean isFull() {
        // number of elements is equal to size of the queue.
        return size() == capacity();
    }

    /**
     * Number of elements the queue can occupy.
     * 
     * @return capacity of the queue.
     */
    public int capacity() {
        return queueArr.length;
    }

    /**
     * Number of elements in the queue.
     * 
     * @return size of queue.
     */
    public int size() {
        return numOfElements;
    }

    /**
     * Resize the capacity of the queue array.
     */
    public void resize() {
        // allocate a new array twice the size
        char[] resizedArr = new char[2 * capacity()];

        // copy elements of the old array to a new array
        int oldIndex = front;
        for (int i = 0; i < size(); i++) {
            resizedArr[i] = queueArr[oldIndex];
            oldIndex = (oldIndex + 1) % capacity();
        }

        // replace the old array with the new array.
        queueArr = resizedArr;

        // reset the array of the queue indices.
        front = 0;
        rear = size();
    }
    
    /**
     * Return string representation of queue. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]"
     * 
     * @return string representation of queue
     */
    public String toString() {
    	// create string builder
    	StringBuilder sb = new StringBuilder();
    	
    	// add opening [
    	sb.append('[');
    	
    	// add capacity
    	sb.append("capacity: ");
    	sb.append(capacity());
    	
    	// add size
    	sb.append(", size: ");
    	sb.append(size());


    	// add opening [ for values
    	sb.append(", values: [");

    	// add values in dequeue order
    	int nextIndex = front;
    	for (int i = 0; i < size(); i++) {
    		sb.append(queueArr[nextIndex]);
    		nextIndex = (nextIndex + 1) % capacity();
    		if (nextIndex != rear) { // more chars to print
    			sb.append(", ");
    		}
    	}
    	
    	// add closing ] for values
    	sb.append("]");

    	// add closing ] for queue
    	sb.append(']');

    	// return builder as string
    	return sb.toString();
    }
}

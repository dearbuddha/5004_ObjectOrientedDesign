package Recitation6;

/**
 * CS 5005 Recitation - Session 2.
 *
 * This class provides methods to implement stack with character array.
 */
public class ArrayStack {
	/** Deque used as stack */
	private ArrayDeque deque;
	
    /**
     * Create stack with specified capacity.
     * 
     * @param capacity the stack capacity
     */
    public ArrayStack(int capacity) {
    	deque = new ArrayDeque(capacity);
    }
    
    /**
     * Push a character item to the stack.
     * @param item item to be pushed.
     */
    public void push(char c) {
    	deque.addLast(c);
    }

    /**
     * Remove and return the top character element out of the stack.
     *
     * @return top character element of stack.
     */
    public char pop() {
    	char c = deque.removeLast();
        return c;
    }

    /**
     * Peeks the top character element of the stack.
     *
     * @return top element of the stack or '\0' if empty
     */
    public char peek() {
    	char c = deque.peekLast();
        return c;
    }

    /**
     * Determines whether stack is empty or not.
     *
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        boolean empty = deque.isEmpty();
        return empty;
    }
    
    /**
     * Determines whether stack is full or not
     * 
     * @return true if the stack is full.
     */
    public boolean isFull() {
    	boolean full = deque.isFull();
    	return full;
    }

    /**
     * Gets the number of elements on the stack.
     *  
     * @return the number of elements on the stack
     */
    public int size() {
    	int siz = deque.size();
    	return siz;
    }
    
    /**
     * Gets the capacity of the stack.
     * 
     * @return the capacity of the stack
     */
    public int capacity() {
    	int cap = deque.capacity();
    	return cap;
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

    	// appends values in pop order
    	for (int i = size()-1; i >= 0; i--) {
    		char c = deque.peek(i);
    		sb.append(c);
    		if (i > 0) { // more chars to print
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
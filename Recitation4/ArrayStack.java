package Recitation4;

/**
 * CS 5005 Recitation - Session 2.
 *
 * This class provides methods to implement stack with character array.
 */
public class ArrayStack {

    /**  character array to represent a stack. */
    char[] items;

    /** index of the top element. */
    int topIndex = -1;

    /**
     * Create stack with specified capacity.
     * 
     * @param capacity the stack capacity
     */
    public ArrayStack(int capacity) {
    	if (capacity < 1) {
    		capacity = 1;
    	}
    	items = new char[capacity];
    }
    
    /**
     * Push a character item to the stack.
     * @param item item to be pushed.
     */
    public void push(char item) {
    	// ensure room to push item
        if (size() == capacity()) {
            resize();
        }

        // add item at next index
        items[++topIndex] = item;
    }

    /**
     * Remove and return the top character element out of the stack.
     *
     * @return top character element of stack.
     */
    public char pop() {
        if (isEmpty()) {
            return '\0';  // indicates no element
        }

        char poppedElement = items[topIndex];
        items[topIndex] = '\0';
        topIndex = topIndex - 1;

        return poppedElement;
    }

    /**
     * Peeks the top character element of the stack.
     *
     * @return top element of the stack or '\0' if empty
     */
    public char peek() {

        if (isEmpty()) {
            return '\0';  // indicates no element
        }

        return items[topIndex];
    }

    /**
     * Determines whether stack is empty or not.
     *
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        return topIndex == -1;
    }
    
    /**
     * Determines whether stack is full or not
     * 
     * @return true if the stack is full.
     */
    public boolean isFull() {
        // number of elements is equal to size of the stack.
        return size() == capacity();
    }

    /**
     * Gets the number of elements on the stack.
     *  
     * @return the number of elements on the stack
     */
    public int size() {
    	return topIndex+1;
    }
    
    /**
     * Gets the capacity of the stack.
     * 
     * @return the capacity of the stack
     */
    public int capacity() {
    	return items.length;
    }
    
    /**
     * Resize the capacity of the stack array.
     */
    private void resize() {
    	// get new capacity
    	int newCapacity = capacity() * 2;
    	
    	// create new array with new capacity
    	char[] newItems = new char[newCapacity];
    	
    	// copy current array elements into new array
    	for (int i = 0; i < size(); i++) {
    		newItems[i] = items[i];
    	}
    	
    	// replace current array with new array
    	items = newItems;
    }

    /**
     * Return string representation of stack. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]" (values in the order returned by pop())
     *
     * @return string representation of queue
     */
    public String toString(){

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

        // add values in pop order
        for(int i = topIndex; i>=0; i--){
            sb.append(items[i]);
            if(i > 0){
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
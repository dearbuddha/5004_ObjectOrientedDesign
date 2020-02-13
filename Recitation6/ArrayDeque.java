package Recitation6;

/**
 * CS 5005 Recitation - Session 5
 * Deque of characters implemented as an array.
 */
final public class ArrayDeque {

    /** Character array for values as circular array. */
    private char[] dequeArr;

    /** Points to the front element in the deque. */
    private int front = 0;

    /** Points to next available space from rear element. */
    private int rear = 0;

    /** Number of elements in the deque. */
    private int numOfElements = 0;

    /**
     * Constructor, to initialize the capacity of the deque.
     * If the input capacity is less than 1, then capacity 
     * is reinitialized as one.
     *
     * @param capacity capacity of the deque.
     */
    public ArrayDeque(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        dequeArr = new char[capacity];
    }

    /**
     * Inserts an element as the last element
     * of the deque.
     * 
     * @param c element to be inserted.
     */
    public void addLast(char c) {
        if (isFull()) {
            resize();
        }

        dequeArr[rear] = c;
        rear = (rear + 1) % capacity();
        numOfElements++;
    }

    /**
     * Inserts an element as the first element
     * of the deque.
     * 
     * @param c element to be inserted.
     */
    public void addFirst(char c) {
        if (isFull()) {
            resize();
        }

        front = (front+capacity()-1) % capacity();
        dequeArr[front] = c;
        numOfElements++;
    }

    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque or '\0' if empty
     */
    public char removeFirst() {
    	// return null character if empty
        if(isEmpty()) {
            return '\0';
        }

        // get front element to return
        char frontElement = dequeArr[front];
        
        // erase char so we know it is gone
        dequeArr[front] = '\0';
        
        // move front to next deque element
        front = (front + 1) % capacity();
        
        numOfElements--;  // decrease number elements in deque
        return frontElement;
    }

    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque or '\0' if empty
     */
   public char removeLast() {
   	    // return null character if empty
       if(isEmpty()) {
           return '\0';
       }

       rear = (rear+capacity()-1)%capacity();
       
       // get front element to return
       char rearElement = dequeArr[rear];
       
       // erase char so we know it is gone
       dequeArr[rear] = '\0';
       
       numOfElements--;  // decrease number elements in deque
       return rearElement;
   }

   /**
    * Peeks the nth character element from front or rear of the deque.
    *
    * @param n the index from front (0, 1, ...) or rear (-1, -2, ...) 
    * @return nth element of the dequeue or '\0' if
    *   does not exist
    */
   public char peek(int n) {  // think about the visibility of this method
       if (n < -size() || n >= size()) {
    	   return '\0';  // indicates no char
       }
       
       int index;
       if (n < 0) {
    	   index = (rear+capacity()+n)%capacity();
       } else {
    	   index = (front+n)%capacity();
       }
       return dequeArr[index];
   	}

   /**
    * Peeks the first character element of the deque.
    *
    * @return first element of the queue or '\0' if empty
    */
   public char peekFirst() {
	   char c = peek(0);  // first char
	   return c;
   	}

   /**
    * Peeks the last character element of the deque.
    *
    * @return first element of the deque or '\0' if empty
    */
   public char peekLast() {
	   char c = peek(-1);  // last char
       return c;
   }

   /**
    * Determines whether deque is empty or not.
    * 
    * @return true if deque is empty
    */
    public boolean isEmpty() {
        // number of elements is zero
        return size() == 0;
    }

    /**
     * Determines whether deque is full or not
     * 
     * @return true if the deque is full.
     */
    public boolean isFull() {
        // number of elements is equal to size of the deque.
        return size() == capacity();
    }

    /**
     * Number of elements the deque can occupy.
     * 
     * @return capacity of the deque.
     */
    public int capacity() {
        return dequeArr.length;
    }

    /**
     * Number of elements in the deque.
     * 
     * @return size of deque.
     */
    public int size() {
        return numOfElements;
    }

    /**
     * Resize the capacity of the deque array.
     */
    private void resize() {
        // allocate a new array twice the size
        char[] resizedArr = new char[2 * capacity()];

        // copy elements of the old array to a new array
        int oldIndex = front;
        for (int i = 0; i < size(); i++) {
            resizedArr[i] = dequeArr[oldIndex];
            oldIndex = (oldIndex + 1) % capacity();
        }

        // replace the old array with the new array.
        dequeArr = resizedArr;

        // reset the array of the deque indices.
        front = 0;
        rear = size();
    }
    
    /**
     * Return string representation of deque. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]"
     * with elements from first to last in deque order.
     * 
     * @return string representation of deque
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

    	// add values in removeFirst order
    	for (int i = size(); i >= 1; i--) {    		
    		sb.append(peek(-i));
    		if (i > 1) { // more chars to print
    			sb.append(", ");
    		}
    	}
    	
    	// add closing ] for values
    	sb.append("]");

    	// add closing ] for deque
    	sb.append(']');

    	// return builder as string
    	return sb.toString();
    }
}

package Recitation12;

import java.util.NoSuchElementException;

/**
 * CS 5005 Recitation - Session 7
 * Deque of characters implemented as an array.
 */
final public class ArrayDeque<T> implements Deque<T> {

    /** Character array for values as circular array. */
    private T[] dequeArr;

    /** Points to the front element in the deque. */
    private int front = 0;

    /** Points to next available space from rear element. */
    private int rear = 0;

    /** Number of elements in the deque. */
    private int numOfElements = 0;

    /**
     * Constructor for a deque with a default size of 4.
     */
    public ArrayDeque() {
    	this(4); // default size
    }
    
    /**
     * Constructor to initialize the capacity of the deque.
     * If the input capacity is less than 1, then capacity 
     * is reinitialized as one.
     *
     * @param capacity capacity of the deque.
     */
    @SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        dequeArr = (T[]) new Object[capacity];
    }

    /**
     * Copy constructor performs shallow copy of other.
     * 
     * @param other another instance
     */
    public ArrayDeque(ArrayDeque<T> other) {
    	dequeArr = other.dequeArr.clone();
    	
    	front = other.front;
    	rear = other.rear;
    	numOfElements = other.numOfElements;
    }
    
    /**
     * Inserts an element as the last element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @return true if added, false if full
     */
    public boolean offerLast(T o) {
        if (isFull()) {
            resize();
        }

        dequeArr[rear] = o;
        // move rear to next deque element
        rear = arrayIndex(rear+1);
        numOfElements++;
        
        return true;
    }

    /**
     * Inserts an element as the last element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @throws IllegalStateException if deque is full
     */
    public void addLast(T o) {
    	if (!offerLast(o)) {
    		throw new IllegalStateException("addLast");
    	}
    }

    /**
     * Inserts an element as the first element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @return true if added, false if full
     */
    public boolean offerFirst(T o) {
        if (isFull()) {
            resize();
        }

        // move front to next deque element
        front = arrayIndex(front-1);
        dequeArr[front] = o;
        numOfElements++;
       
        return true;
    }

    /**
     * Inserts an element as the first element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @throws IllegalStateException if deque is full
     */
    public void addFirst(T o) {
    	if (!offerFirst(o)) {
    		throw new IllegalStateException("addFirst");
    	}
    }

    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque or null if empty
     */
    public T pollFirst() {
    	// return null if empty
        if(isEmpty()) {
        	return null;
        }

        // get front element to return
        T frontElement = dequeArr[front];
        
        // erase T so we know it is gone
        dequeArr[front] = null;
        
        // move front to next deque element
        front = arrayIndex(front+1);
        
        numOfElements--;  // decrease number elements in deque
        return frontElement;
    }

    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque
     * @throws NoSuchElementException if deque is empty
     */
    public T removeFirst() {
    	// return null if empty
        if(isEmpty()) {
            throw new NoSuchElementException("removeFirst");
        }
        return pollFirst();
    }
    
    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque or null if empty
     */
   public T pollLast() {
   		// return null if empty
       if(isEmpty()) {
    	   return null;
       }

       // move rear index to previous deque element
       rear = arrayIndex(rear-1);
       
       // get front element to return
       T rearElement = dequeArr[rear];
       
       // erase T so we know it is gone
       dequeArr[rear] = null;
       
       numOfElements--;  // decrease number elements in deque
       return rearElement;
   }

   /**
    * Removes the first element entered in the deque.
    * 
    * @return first element of deque or null if empty
    * @throws NoSuchElementException if deque is empty
    */
	public T removeLast() {
		// throw exception if empty
		if(isEmpty()) {
        	throw new NoSuchElementException("removeLast");
		}
		return pollLast();
  	}
	
   /**
    * Gets array index (0..capacity-1) of nth element 
    * from front (+) or rear (-) of the array.
    * 
    * @param n the position from array front (+) or rear (-) 
    * @return index in range (0..capacity-1)
    */
   private int arrayIndex(int n) {
	   int index = n % capacity();
	   if (index < 0) {
		   index += capacity();
	   }
	   return index;
   }

   /**
    * Gets array index (0..capacity-1) of nth element 
    * from front (+) or rear (-) of the deque.
    *
    * @param n the position from deque front (+) or rear (-) 
    * @return index in range (0..capacity-1)
    *   does not exist
    */
   private int arrayDequeIndex(int n) {
       int index;
       if (n < 0) {
    	   index = arrayIndex(rear+n);  // relative to rear
       } else {
    	   index = arrayIndex(front+n); // relative to front
       }
       return index;	   
   }
   
   /**
    * Peeks the nth element from front or rear of the deque.
    *
    * @param n the position from deque front (+) or rear (-) 
    * @return nth element of the dequeue or null if
    *   does not exist
    */
   public T peek(int n) {
       if (n < -size() || n >= size()) {
    	   return null;  // indicates no T
       }
       int index = arrayDequeIndex(n);
       return dequeArr[index];
   	}

   /**
    * Peeks the nth element from front or rear of the deque.
    *
    * @param n the position from deque front (+) or rear (-) 
    * @return nth element of the dequeue
    * @throws NoSuchElementException if dequeue is empty
    */
   public T get(int n) {
	   T c = peek(n);
	   if (c == null) {
		   throw new NoSuchElementException("get");
	   }
       return c;
   	}

   /**
    * Peeks the first element of the deque.
    *
    * @return first element of the queue or null if empty
    */
   public T peekFirst() {
	   T c = peek(0);  // first T
	   return c;
   	}

   /**
    * Peeks the first element of the deque.
    *
    * @return first element of the queue or null if empty
    * @throws NoSuchElementException if dequeue is empty
    */
   public T getFirst() {
	   if (isEmpty()) {
		   throw new NoSuchElementException("getFirst");
	   }
	   T c = peekFirst();  // first T
	   return c;
   	}

   /**
    * Peeks the last element of the deque.
    *
    * @return first element of the deque or null if empty
    */
   public T peekLast() {
	   T c = peek(-1);  // last T
       return c;
       
   }

   /**
    * Peeks the last element of the deque.
    *
    * @return first element of the queue or null if empty
    * @throws NoSuchElementException if dequeue is empty
    */
   public T getLast() {
	   if (isEmpty()) {
		   throw new NoSuchElementException("getLast");
	   }
	   T c = peekLast();  // last T
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
     * Determines whether deque is full or not.
     * 
     * @return true if the deque is full.
     */
    public boolean isFull() {
        // size is equal to capacity of the deque.
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
        @SuppressWarnings("unchecked")
		T[] resizedArr = (T[])new Object[2 * capacity()];

        // copy elements of the old array to a new array
        for (int i = 0; i < size(); i++) {
        	resizedArr[i] = peek(i);
        }

        // replace the old array with the new array.
        dequeArr = resizedArr;

        // reset the array of the deque indices.
        front = 0;
        rear = size();
    }
    
    /**
     * Determines whether this instance is equal
     * to another instance. A deque is equal to 
     * another deque if it has the same number of
     * elements and each corresponding element
     * equals() the other.
     * 
     * @param o an object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
    	// equal if same
    	if (o == this) {
    		return true;
    	}
    	
    	// not equal if obj not an ArrayDeque
    	if (! (o instanceof ArrayDeque<?>)) {
    		return false;
    	}
    	
    	// cast obj to ArrayDeque
    	@SuppressWarnings("unchecked")
		ArrayDeque<T> other = (ArrayDeque<T>)o;
    	
    	// not equal if different sizes
    	if (size() != other.size()) {
    		return false;
    	}
    	
    	// ensure each element equals element of other instance
    	for (int i = 0; i < size(); i++) {
    		T this_o = peek(i);  // element of this instance
    		T other_o = other.peek(i);  // element of other instance
    		
    		// deque not equal of elements not equal
    		if (! this_o.equals(other_o)) {
    			return false;
    		}
    	}
    	
    	return true;  // true if all elements are equal
    }
    
    /**
     * Return string representation of deque. Format is:
     * "[capacity: n, size: n, values: [v1, v2, ..., vn]]"
     * with elements from first to last in deque order.
     * 
     * @return string representation of deque
     */
    @Override
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

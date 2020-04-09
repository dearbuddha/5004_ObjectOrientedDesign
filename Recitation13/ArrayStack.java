package Recitation13;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * CS 5005 Recitation - Session 7.
 *
 * This class provides methods to implement stack with array.
 */
public class ArrayStack <T>  extends AbstractCollection<T> implements Stack<T> {
	/** Deque used as stack */
	private ArrayDeque<T> deque;
	
    /**
     * Create stack with specified capacity.
     * 
     * @param capacity the stack capacity
     */
    public ArrayStack(int capacity) {
    	deque = new ArrayDeque<T>(capacity);
    }
    
    /**
     * Copy constructor performs shallow copy of other.
     * 
     * @param other another instance
     */
    public ArrayStack(ArrayStack<T> other) {
    	deque = new ArrayDeque<T>(other.deque);
    }
    
    /**
     * Push a item to the stack.
     * @param o item to be pushed.
     * @throws IllegalStateException if full
     */
    public void push(T o) {
    	deque.addLast(o);
    }

    /**
     * Inserts an element to the queue.
     * 
     * @param o element to be inserted.
     * @return true if pushed
     */
    public boolean offer(T o) {
    	return deque.offerLast(o);
    }

    /**
     * Inserts an element to the queue.
     * 
     * @param o element to be inserted.
     * @return true if enqueued
     */
    public boolean add(T o) {
    	return offer(o);
    }

    /**
     * Remove and return the top element out of the stack.
     *
     * @return top element of stack.
     */
    public T pop() {
    	T o = deque.removeLast();
        return o;
    }

    /**
     * Remove and return the top element out of the stack.
     *
     * @return top element of stack.
     * @throws NoSuchElementException if full
     */
    public T poll() {
    	T o = deque.pollLast();
        return o;
    }

    /**
     * Remove and return the top element out of the stack.
     *
     * @return top element of stack.
     * @throws NoSuchElementException if full
     */
    public T remove() {
    	T o = poll();
        return o;
    }

    /**
     * Peeks the first element of the queue.
     *
     * @return first element of the queue
     */
    public T get() {
    	T o = deque.getLast();
    	return o;
    }

    /**
     * Peeks the top element of the stack.
     *
     * @return top element of the stack or null if empty
     */
    public T peek() {
    	T o = deque.peekLast();
        return o;
    }

    /**
     * Peeks the nth element from top or bottom of the stack.
     *
     * @param n the position from stack top (+) or bottom (-) 
     * @return nth element of the stack
     * @throws NoSuchElementException of empty
     */
    public T get(int n) {
    	int stkn = -(n+1);
    	T o = deque.get(stkn);
    	return o;
    }

    /**
     * Peeks the nth element from top or bottom of the stack.
     *
     * @param n the position from stack top (+) or bottom (-) 
     * @return nth element of the stack or null not found
     */
    public T peek(int n) {
    	int stkn = -(n+1);
    	T o = deque.peek(stkn);
    	return o;
    }

    /**
     * Remove all elements from the collection.
     */
    public void clear() {
 	   deque.clear();
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
    	if (o instanceof ArrayStack<?>) {
    		@SuppressWarnings("unchecked")
			ArrayStack<T> other = (ArrayStack<T>)o;
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
    		T o = deque.peek(i);
    		sb.append(o);
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

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
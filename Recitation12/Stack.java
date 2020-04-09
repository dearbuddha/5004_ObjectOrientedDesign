/*
 * CS 5005 Recitation - Session 7
 * Deque of characters implemented as an array.
 */
package Recitation12;

/**
 * Interface for a generic Stack.
 * 
 * @author phil
 * @since 2020-03-19
 */
public interface Stack<T> {
    /**
     * Push a item to the stack.
     * @param o item to be pushed.
     */
    public void push(T o);

    /**
     * Remove and return the top element out of the stack.
     *
     * @return top element of stack.
     */
    public T pop();

    /**
     * Peeks the top element of the stack.
     *
     * @return top element of the stack or null if empty
     */
    public T peek();

    /**
     * Determines whether stack is empty or not.
     *
     * @return true if stack is empty.
     */
    public boolean isEmpty();
    
    /**
     * Determines whether stack is full or not
     * 
     * @return true if the stack is full.
     */
    public boolean isFull();

    /**
     * Gets the number of elements on the stack.
     *  
     * @return the number of elements on the stack
     */
    public int size();
    
    /**
     * Gets the capacity of the stack.
     * 
     * @return the capacity of the stack
     */
    public int capacity();

}

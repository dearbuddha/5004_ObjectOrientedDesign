/*
 * CS 5005 Recitation - Session 7
 * Deque of characters implemented as an array.
 */
package Recitation13;

import java.util.NoSuchElementException;

/**
 * Interface for a generic Deque.
 * 
 * @author phil
 * @since 2020-03-19
 */
public interface Deque<T> extends Collection<T> {
    /**
     * Inserts an element as the last element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @return true if added, false if full
     */
    public boolean offerLast(T o);

    /**
     * Inserts an element as the last element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @throws IllegalStateException if deque is full
     */
    public void addLast(T o);

    /**
     * Inserts an element as the first element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @return true if added, false if full
     */
    public boolean offerFirst(T o);

    /**
     * Inserts an element as the first element
     * of the deque.
     * 
     * @param o element to be inserted.
     * @throws IllegalStateException if deque is full
     */
    public void addFirst(T o);

    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque or null if empty
     */
    public T pollFirst();

    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque
     * @throws NoSuchElementException if deque is empty
     */
    public T removeFirst();
    
    /**
     * Removes the first element entered in the deque.
     * 
     * @return first element of deque or null if empty
     */
   public T pollLast();

   /**
    * Removes the first element entered in the deque.
    * 
    * @return first element of deque or null if empty
    * @throws NoSuchElementException if deque is empty
    */
	public T removeLast();
	
   /**
    * Peeks the first element of the deque.
    *
    * @return first element of the queue or null if empty
    */
   public T peekFirst();

   /**
    * Peeks the first element of the deque.
    *
    * @return first element of the queue or null if empty
    * @throws NoSuchElementException if dequeue is empty
    */
   public T getFirst();

   /**
    * Peeks the last element of the deque.
    *
    * @return first element of the deque or null if empty
    */
   public T peekLast();

   /**
    * Peeks the last element of the deque.
    *
    * @return first element of the queue or null if empty
    * @throws NoSuchElementException if dequeue is empty
    */
   public T getLast();

   /**
    * Determines whether deque is empty or not.
    * 
    * @return true if deque is empty
    */
    public boolean isEmpty();

    /**
     * Determines whether deque is full or not.
     * 
     * @return true if the deque is full.
     */
    public boolean isFull();

    /**
     * Number of elements the deque can occupy.
     * 
     * @return capacity of the deque.
     */
    public int capacity();

    /**
     * Number of elements in the deque.
     * 
     * @return size of deque.
     */
    public int size();
}

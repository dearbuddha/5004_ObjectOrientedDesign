/*
 * CS 5005 Recitation - Session 7
 * Deque of characters implemented as an array.
 */
package Recitation12;

/**
 * Interface for a generic Queue.
 * 
 * @author phil
 * @since 2020-03-19
 */
public interface Queue<T> {
    /**
     * Inserts an element to the queue.
     * 
     * @param o element to be inserted.
     */
    public void enqueue(T o);

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue or '\0' if empty
     */
    public T dequeue();

    /**
     * Peeks the first element of the queue.
     *
     * @return first element of the queue or '\0' if empty
     */
    public T peek();

    /**
     * Determines whether queue is empty or not.
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty();

    /**
     * Determines whether queue is full or not
     * 
     * @return true if the queue is full.
     */
    public boolean isFull();

    /**
     * Number of elements the queue can occupy.
     * 
     * @return capacity of the queue.
     */
    public int capacity();

    /**
     * Number of elements in the queue.
     * 
     * @return size of queue.
     */
    public int size();
}

/**
 * 
 */
package Recitation12;

/**
 * @author phil
 *
 */
public interface MultiQueue<T> extends Queue<T> {
    /**
     * Inserts an element to the queue at specified priority.
     * 
     * @param m message to be inserted.
     * @param priority the priority of the message
     * @throws IndexOutOfBoundsException if invalid priority
     */
    public void enqueue(T m, int priority);

    
    /**
     * Number of elements in the queue with
     * a given priority.
     * 
     * @param priority the priority
     * @return size of queue.
     * @throws IndexOutOfBoundsException if invalid priority
     */
    public int size(int priority);
}

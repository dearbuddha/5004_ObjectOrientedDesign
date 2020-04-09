/*
 * CS 5005 Recitation - Session 7
 * Generc Collection
 */
package Recitation13;

/**
 * Interface for a generic Collection.
 * 
 * @author phil
 * @since 2020-03-19
 */
public abstract class AbstractCollection<T> implements Collection<T> {
    /**
     * Add a item to the collection
     * @param o item to be pushed.
     * @return true if added
     */
    public boolean add(T o) {
    	throw new UnsupportedOperationException();
    }
    
    /**
     * Remove and return the top element out of the collection.
     *
     * @return top element of collection or null if not found
     */
    public T remove() {
    	throw new UnsupportedOperationException();
    }

    /**
     * Remove all items from the collection
     */
    public void clear() {
    	throw new UnsupportedOperationException();
    }

    /**
     * Determines whether collection is full or not
     * 
     * @return true if the collection is full.
     */
    public boolean isFull() {
    	return false;
    }

    /**
     * Gets the capacity of the collection.
     * 
     * @return the capacity of the collection
     */
    public int capacity() {
    	return Integer.MAX_VALUE;
    }
    
    /**
     * Determines whether collection is empty or not.
     *
     * @return true if collection is empty.
     */
    public boolean isEmpty() {
    	return (size() == 0);
    }

}

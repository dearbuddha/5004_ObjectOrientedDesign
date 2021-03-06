package Recitation13;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * CS 5005 Recitation - Session 7
 * Queue of characters implemented as an array.
 */
public class ArrayQueue<T>  extends AbstractCollection<T> implements Queue<T> {
	/** Deque used as queue */
	private ArrayDeque<T> deque;
	
    /**
     * Constructor for a queue with a default size of 4.
     */
    public ArrayQueue() {
    	deque = new ArrayDeque<>();
    }
    
    /**
     * Constructor, to initialize the capacity of the queue.
     * If the input capacity is less than 1, then capacity 
     * is reinitialized as one.
     *
     * @param capacity capacity of the queue.
     */
    public ArrayQueue(int capacity) {
    	deque = new ArrayDeque<>(capacity);
    }

    /**
     * Copy constructor performs shallow copy of other.
     * 
     * @param other another instance
     */
    public ArrayQueue(ArrayQueue<T> other) {
    	deque = new ArrayDeque<>(other.deque);
    }
    
    /**
     * Inserts an element to the queue.
     * 
     * @param o element to be inserted.
     * @throws IllegalStateException if full
     */
    public void enqueue(T o) {
    	deque.addLast(o);
    }

    /**
     * Inserts an element to the queue.
     * 
     * @param o element to be inserted.
     * @return true if enqueued
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
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue
     */
    public T dequeue() {
    	T o = deque.removeFirst();
    	return o;
    }

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue or null if empty
     */
    public T poll() {
    	T o = deque.pollFirst();
    	return o;
    }

    /**
     * Gives the front element entered in the queue.
     * 
     * @return front element of queue or null if empty
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
    	T o = deque.getFirst();
    	return o;
    }

    /**
     * Peeks the first element of the queue.
     *
     * @return first element of the queue or null if empty
     */
    public T peek() {
    	T o = deque.peekFirst();
    	return o;
    }

    /**
     * Peeks the nth element from front or rear of the queue.
     *
     * @param n the position from queue front (+) or rear (-) 
     * @return nth element of the queue or null if
     *   does not exist
     */
    public T peek(int n) {
    	T o = deque.peek(n);
    	return o;
    }

    /**
     * Remove all elements from the collection.
     */
    public void clear() {
 	   deque.clear();
    }

    /**
     * Determines whether queue is empty or not.
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty() {
    	boolean empty = deque.isEmpty();
        return empty;
    }

    /**
     * Determines whether queue is full or not
     * 
     * @return true if the queue is full.
     */
    public boolean isFull() {
    	boolean full = deque.isFull();
    	return full;
    }

    /**
     * Number of elements the queue can occupy.
     * 
     * @return capacity of the queue.
     */
    public int capacity() {
    	int cap = deque.capacity();
        return cap;
    }

    /**
     * Number of elements in the queue.
     * 
     * @return size of queue.
     */
    public int size() {
    	int siz = deque.size();
        return siz;
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
    	if (o instanceof ArrayQueue<?>) {
    		@SuppressWarnings("unchecked")
			ArrayQueue<T> other = (ArrayQueue<T>)o;
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
    	return deque.toString();
    }
    
    /**
     * Examples from recitation 10
     * @param args
     */
    public static void main(String[] args) {
    	/*
    	 * Example of Integer ArrayDeque
    	 */
    	ArrayQueue<Integer> integerQueue = new ArrayQueue<>();
    	
    	integerQueue.enqueue(1);
    	integerQueue.enqueue(3);
    	
    	Integer firstInteger = integerQueue.peek();
    	System.out.println(firstInteger);
    	
    	/*
    	 * Example of String ArrayQueue
    	 */
    	ArrayQueue<String> stringQueue = new ArrayQueue<>();
    	
    	stringQueue.enqueue("First String");
    	stringQueue.enqueue("Second String");
    	
    	String firstString = stringQueue.peek();
    	System.out.println(firstString);
    	
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

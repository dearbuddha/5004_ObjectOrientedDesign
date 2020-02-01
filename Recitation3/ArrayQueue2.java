package Recitation3;

/**
 * CS 5005 Recitation - Session 3
 * Implementation of Queue.
 */
class ArrayQueue {

    /**
     * Constructor, to initialize the capacity of the queue.
     * If the input capacity is less than one, then capacity is reinitialized as one.
     *
     * @param capacity capacity of the queue.
     */
    public ArrayQueue(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        queueArr = new char[capacity];
    }


    /**
     * Character Array that represents queue
     * This is managed as circular queue array.
     */
    char[] queueArr;

    /**
     * Points to the front element in the queue.
     */
    private int front = 0;

    /**
     * Points to the next available space from the rear element in the queue.
     */
    private int rear = 0;

    /**
     * represents the number of elements in the queue.
     */
    private int numOfElements = 0;

    /**
     * Inserts an element to the queue
     * @param c element to be inserted.
     */
    public void enqueue(char c) {
        if (isFull()) {
            resize();
        }

        queueArr[rear] = c;
        rear = (rear + 1) % capacity();
        numOfElements++;
    }

    /**
     * Gives the front element entered in the queue.
     * @return front element of the queue.
     */
    public char dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return '\0';
        }

        char frontElement = queueArr[front];
        queueArr[front] = '\0';
        front = (front + 1) % capacity();
        numOfElements--;
        return frontElement;
    }

    /**
     * Determines whether queue is empty or not.
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        // number of elements is zero
        return size() == 0;
    }

    /**
     * Determines whether queue is full or not
     * @return true if the queue is full.
     */
    public boolean isFull() {
        // number of elements is equal to size of the queue.
        return size() == capacity();
    }

    /**
     * Number of elements the queue can occupy.
     * @return capacity of the queue.
     */
    public int capacity() {
        return queueArr.length;
    }

    /**
     * Number of elements in the queue.
     * @return size of queue.
     */
    public int size() {
        return numOfElements;
    }

    /**
     * Resizes the queue array.
     * It doubles the existing size.
     */
    public void resize() {

        // allocate a new array twice the size
        char[] resizedArr = new char[2 * capacity()];

        // copy elements of the old array to a new array
        int oldIndex = front;
        for (int i = 0; i < size(); i++) {
            resizedArr[i] = queueArr[oldIndex];
            oldIndex = (oldIndex + 1) % capacity();
        }

        // replace the old array with the new array.
        queueArr = resizedArr;

        // reset the array of the queue indices.
        front = 0;
        rear = size();
    }
}
